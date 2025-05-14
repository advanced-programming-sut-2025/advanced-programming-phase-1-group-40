package org.example.controller.Game;

import org.example.models.*;
import org.example.models.Map.Farm;
import org.example.models.Map.FarmManager;
import org.example.models.enums.FriendshipLevel;
import org.example.models.enums.Menu;

import java.util.ArrayList;


public class GameMenuController {



    public Result newGame(String input) {


        input = input.substring(input.indexOf('u')+1).trim();
        input = input.replaceAll("\\s+", " ").trim();

        if (input.isEmpty()) {

            return new Result(false, "You must add at least one user");

        }

        String[] usernames = input.split(" ");

        if ( usernames.length > 3 ) {

            return new Result(false, "You must enter at most three users");

        }

        ArrayList<Player> players = new ArrayList<>();

        for ( String username : usernames ) {

            User addedUser = getUserByUsername(username);

            if ( addedUser != null ) {
                players.add( new Player(addedUser) );
            }

            else{
                return new Result(false, "Username " + username + " does not exist.");
            }

        }

        for ( Player player : players ) {

            if ( isPlayerInAnotherGame(player) ) {

                return new Result(false, player.getUsername() + " is already in a game");

            }

        }

        ///    SETTING FRIENDSHIPS -> ZERO


        for ( Player player1 : players ) {

            for ( Player player2 : players ) {

                if ( ! player1.equals(player2)  ) {


                    player1.setFriendships(player2,new FriendshipWithNPC(0,FriendshipLevel.STRANGER));


                }

            }

        }


        Player gameCreator = new Player(App.dataManager.getCurrentUser());
        players.add(gameCreator);


        // Create the game and set it as current in DataManager

        Game newGame = createNewGame(gameCreator,players);

        App.dataManager.setCurrentGame(newGame);


        App.dataManager.addGame(newGame);
        App.dataManager.setCurrentGame(newGame);

        return new Result(true, "New game created successfully");


    }

    public Game createNewGame(Player creator, ArrayList<Player> players) {

        Game newGame = new Game(creator,players);
        App.dataManager.addGame(newGame);
        App.dataManager.setCurrentGame(newGame);

        return newGame;

    }

    private User getUserByUsername(String username) {

        for ( User user : App.dataManager.getAllUsers() ){

            if ( user.getUsername().equals(username) ){

                return user;

            }

        }

        return null;

    }

    private boolean isPlayerInAnotherGame(Player player) {

        for ( Game game : App.dataManager.getGames() ){

            if ( game.getPlayers().contains(player) ){

                return true;

            }

        }

        return false;

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









