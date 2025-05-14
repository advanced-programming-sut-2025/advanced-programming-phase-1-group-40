package org.example.controller.Game;

import org.example.models.*;
import org.example.models.Map.Farm;
import org.example.models.Map.FarmManager;
import org.example.models.enums.FriendshipLevel;
import org.example.models.enums.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for the game menu functionality
 */
public class GameMenuController {



    public Result createNewGame(List<String> usernames) {
        // Validate number of players (2-4)
        if (usernames == null || usernames.size() < 2 || usernames.size() > 4) {
            return new Result(false, "Invalid number of players. Game requires 2-4 players.");
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


    private void createFarmsForPlayers() {
        FarmManager farmManager = FarmManager.getInstance();

        for (Player player : currentGame.getPlayers()) {
            int mapType = mapSelections.getOrDefault(player.getUsername(), 1); // Default to standard farm
            Farm farm = farmManager.createFarmForUser(player, mapType);
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





    public Result loadGame() {
        Player currentPlayer = App.dataManager.getCurrentPlayer();

        // Load the game and set it as current in DataManager
        Game savedGame = App.dataManager.loadGameForPlayer(currentPlayer.getUsername());

        if (savedGame == null) {
            return new Result(false, "No saved game found for " + currentPlayer.getUsername());
        }

        // Set the current player in the game
        savedGame.setCurrentTurnPlayer(currentPlayer);

        return new Result(true, "Game loaded successfully. It's your turn!");
    }



    public Result voteToTerminateGame(boolean vote) {
        if (currentGame == null || !currentGame.isActive()) {
            return new Result(false, "No active game to terminate.");
        }

        Player currentPlayer = App.dataManager.getCurrentPlayer();

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


    public void goToMenu(Menu targetMenu){

        App.dataManager.setCurrentMenu(targetMenu);
        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());

    }

    public void showCurrentMenu(){

        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());

    }


}









