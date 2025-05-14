package org.example.controller.Game;

import org.example.models.*;
import org.example.models.Map.Farm;
import org.example.models.Map.FarmManager;
import org.example.models.enums.FriendshipLevel;

import java.util.*;

/**
 * Controller for the game menu functionality
 */
public class GameMenuController {
    private Game currentGame;
    

    // public GameMenuController() {
    //     mapSelections = new HashMap<>();
    // }

    /**
     * Creates a new game with the specified players
     * @param usernamesString List of usernames to add to the game
     * @return Result indicating success or failure
     */
    public Result createNewGame(String usernamesString) {
        List<String> usernames = new ArrayList<>();
        Collections.addAll(usernames, usernamesString.split("\\s+"));
        // TODO System.out.println(usernames.size());
        // Validate number of players (3)
        if (usernames == null || usernames.size() != 3) {
            return new Result(false, "Invalid number of players. Game requires 3 players.");
        }

        // Validate all usernames
        ArrayList<Player> players = new ArrayList<>();
        for (String username : usernames) {
            User user = App.dataManager.getUserByUsername(username);
            if (user == null) {
                return new Result(false, "User '" + username + "' does not exist.");
            }

            // Check if player is already in another active game
            if (isPlayerInActiveGame((Player)user)) {
                return new Result(false, "Player '" + username + "' is already in an active game.");
            }

            players.add((Player)user);
        }

        for ( Player player1 : players ) {

            for (Player player2 : players) {

                if( ! player1.equals(player2)) {

                    player1.setFriendships(player2,new FriendshipWithNPC(0,FriendshipLevel.STRANGER));

                }

            }

        }

        // Create the game and set it as current in DataManager
        Game newGame = App.dataManager.createNewGame(players);
        currentGame = newGame;
        Player creator = (Player) App.dataManager.getCurrentUser();
        newGame.setCreator(creator);//we should be careful in the casting here
        newGame.setCurrentTurnPlayer(creator);
        App.dataManager.addGame(newGame);
        App.dataManager.setCurrentGame(newGame);

        return new Result(true, "New game created successfully with " + players.size() + " players.");
    }

    /**
     * Selects a map type for the current player
     * @param mapNumber The map type number (1-7)
     * @return Result indicating success or failure
     */
    public Result selectMap(int mapNumber) {
        if (currentGame == null) {
            return new Result(false, "No active game. Please create a game first.");
        }

        Player currentPlayer = currentGame.getCurrentTurnPlayer();
        if (!currentGame.hasPlayer(currentPlayer.getUsername())) {
            return new Result(false, "You are not part of this game.");
        }

        // Validate map number
        if (mapNumber < 1 || mapNumber > 7) {
            return new Result(false, "Invalid map number. Please choose a number between 1-7.");
        }

        // Store the player's map selection
        //mapSelections.put(currentPlayer.getUsername(), mapNumber);
        Farm chosenFarm = FarmManager.getInstance().createFarmForUser(currentPlayer, mapNumber);

        currentGame.assignFarmToPlayer(currentPlayer, chosenFarm);
        // Check if all players have selected their maps
        boolean allPlayersSelected = true;
        for (Player player : currentGame.getPlayers()) {
            if (!currentGame.getPlayerFarms().containsKey(player.getUsername())) {
                allPlayersSelected = false;
                break;
            }
        }

        // If all players have selected, create farms for each player
        if (allPlayersSelected) {
            createFarmsForPlayers();
            //currentGame.setActive(true);
            return new Result(true, "All players have selected their maps. Game is now active!");
        }

        return new Result(true, "Map selection saved. Waiting for other players to select their maps.");
    }

    /**
     * Creates farms for all players based on their map selections
     */
    private void createFarmsForPlayers() {
        FarmManager farmManager = FarmManager.getInstance();

        for (Player player : currentGame.getPlayers()) {
            //int mapType = mapSelections.getOrDefault(player.getUsername(), 1); // Default to standard farm
            Farm farm = farmManager.createFarmForUser(player, 0); // TODO
            currentGame.addFarm(farm);

            // Set the player's current position to their farm's cabin
            if (farm.getCabin() != null) {
                player.setCurrentPosition(farm.getCabin().getPosition());
            }
        }

        // Initialize game time
        currentGame.initializeTime();

        // Set the first player as the current turn player
        currentGame.setCurrentTurnPlayer(currentGame.getPlayers().get(0));

        // Save the game state
        App.dataManager.saveGameData();
    }

    /**
     * Moves to the next player's turn
     * @return Result indicating success or failure
     */
    public Result nextTurn() {
        Game currentGame = App.dataManager.getCurrentGame();
        if (currentGame == null) {
            return new Result(false, "No active game. Please create or load a game first.");
        }

        Player currentPlayer = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

        // Check if it's the current player's turn
        if (!currentGame.getCurrentTurnPlayer().getUsername().equals(currentPlayer.getUsername())) {
            return new Result(false, "It's not your turn.");
        }

        // Move to the next player's turn
        Player nextPlayer = currentGame.nextTurn();

        // Set the current player in DataManager to the next player
        App.dataManager.setCurrentUser(nextPlayer);

        // Save game state
        App.dataManager.saveGameData();

        return new Result(true, "Turn passed to " + nextPlayer.getUsername() + ". Time is now " +
                         currentGame.getTime().getHour() + ":00 on " +
                         currentGame.getTime().getWeekday() + ", " +
                         currentGame.getTime().getMonth() + " " +
                         currentGame.getTime().getDate() + ", Year " +
                         currentGame.getTime().getYear());
    }

    /**
     * Loads a saved game
     * @return Result indicating success or failure
     */
    public Result loadGame() {
        Player currentPlayer = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

        // Load the game and set it as current in DataManager
        Game savedGame = App.dataManager.loadGameForPlayer(currentPlayer.getUsername());

        if (savedGame == null) {
            return new Result(false, "No saved game found for " + currentPlayer.getUsername());
        }

        // Set the current player in the game
        savedGame.setCurrentTurnPlayer(currentPlayer);

        return new Result(true, "Game loaded successfully. It's your turn!");
    }

    /**
     * Exits the current game
     * @return Result indicating success or failure
     */
    public Result exitGame() {
        Game currentGame = App.dataManager.getCurrentGame();

        if (currentGame == null) {
            return new Result(false, "No active game to exit.");
        }

        Player currentPlayer = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

        // Only the game creator can exit the game
        if (!currentGame.getCreator().getUsername().equals(currentPlayer.getUsername())) {
            return new Result(false, "Only the game creator can exit the game.");
        }

        // Save the game state before exiting
        App.dataManager.saveGameData();

        // Reset the current game in DataManager
        App.dataManager.exitCurrentGame();

        return new Result(true, "Game exited successfully. Your progress has been saved.");
    }

    /**
     * Initiates a vote to terminate the current game
     * @return Result indicating success or failure
     */
    public Result voteToTerminateGame(boolean vote) {
        if (currentGame == null) {
            return new Result(false, "No active game to terminate.");
        }

        Player currentPlayer = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

        // Register the player's vote
        boolean allVotedToTerminate = currentGame.voteForTermination(currentPlayer, vote);

        if (allVotedToTerminate) {
            // If all players voted to terminate, delete the game
            App.dataManager.removeGame(currentGame);
            currentGame = null;
            return new Result(true, "All players voted to terminate the game. The game has been deleted.");
        }

        return new Result(true, "Your vote has been recorded. Waiting for other players to vote.");
    }

    /**
     * Checks if a player is already in an active game
     * @param player The player to check
     * @return true if the player is in an active game, false otherwise
     */
    private boolean isPlayerInActiveGame(Player player) {
        // A player can be in multiple games, so we don't need to check this anymore
        return false;
    }

    /**
     * Gets the current game
     * @return The current game, or null if no game is active
     */
    public Game getCurrentGame() {
        return App.dataManager.getCurrentGame();
    }

    /**
     * Gets a description of available map types
     * @return String describing the available map types
     */
    public String getMapTypeDescriptions() {
        StringBuilder sb = new StringBuilder("Available Map Types:\n");
        sb.append("1. Standard Farm - A balanced farm with a bit of everything\n");
        sb.append("2. Fishing Farm - More water areas for fishing\n");
        sb.append("3. Mining Farm - More mining resources and a larger quarry\n");
        sb.append("4. Forest Farm - More trees and foraging opportunities\n");
        sb.append("5. River Farm - Has a river running through it\n");
        sb.append("6. Hill-Top Farm - Multiple elevated areas with resources\n");
        sb.append("7. Wilderness Farm - More wild resources but more challenging\n");
        return sb.toString();
    }

    /**
     * Gets the current game status
     * @return String describing the current game status
     */
    public String getGameStatus() {
        if (currentGame == null) {
            return "No active game.";
        }

        StringBuilder sb = new StringBuilder("Current Game Status:\n");
        sb.append("Players: ");

        for (Player player : currentGame.getPlayers()) {
            sb.append(player.getUsername());
            if (player.equals(currentGame.getCurrentTurnPlayer())) {
                sb.append(" (current turn)");
            }
            if (player.equals(currentGame.getCreator())) {
                sb.append(" (creator)");
            }
            sb.append(", ");
        }

        // Remove trailing comma and space
        if (currentGame.getPlayers().size() > 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("\nTime: ").append(currentGame.getTime().getHour()).append(":00");
        sb.append("\nDay: ").append(currentGame.getTime().getWeekday());
        sb.append("\nDate: ").append(currentGame.getTime().getMonth()).append(" ");
        sb.append(currentGame.getTime().getDate()).append(", Year ");
        sb.append(currentGame.getTime().getYear());

        return sb.toString();
    }

    public void showCurrentMenu() {
        // TODO
    }
}








