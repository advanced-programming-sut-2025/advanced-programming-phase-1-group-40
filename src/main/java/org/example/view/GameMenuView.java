package org.example.view;

import org.example.models.*;
import org.example.controller.Game.GameMenuController;
import org.example.models.Game;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.GameMenuCommands;
import org.example.view.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * View for the game menu
 */
public class GameMenuView implements AppMenu {
    private final GameMenuController controller = new GameMenuController();

    private void handleNewGame(String input, Scanner scanner) {
        // Extract usernames
        Pattern pattern = Pattern.compile(GameMenuCommands.NEW_GAME.getRegexString());
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String usernamesStr = matcher.group(1);
            List<String> usernames = new ArrayList<>(Arrays.asList(usernamesStr.split("\\s+")));

            // Add the current player if not already in the list
            Player currentPlayer = (Player)App.dataManager.getCurrentUser();
            String currentUsername = currentPlayer.getUsername();
            if (!usernames.contains(currentUsername)) {
                usernames.add(0, currentUsername);
            }

            // Ensure there's at least one other player besides the creator
            if (usernames.size() < 2) {
                System.out.println("Error: You need at least one other player to create a game.");
                return;
            }
            if (usernames.size() > 4) {
                System.out.println("Error: You can not have mpre thatn 4 p;ayers in the game.");
                return;
            }

            ArrayList<Player> players = new ArrayList<>(usernames.size());
            for (String username : usernames) {

                for (User user : App.dataManager.getAllUsers()) {

                    if (username.equals(user.getUsername())) {

                        players.add((Player) user);

                    }

                }

            }

            Result result = controller.createNewGame(usernamesStr);
            System.out.println(result.message());

            if (result.success()) {
                // Ask each player to select a map
                System.out.println("\nEach player needs to select a map type.");

                // Get map selections for all players
                Game currentGame = App.dataManager.getCurrentGame();
                if (currentGame != null) {
                    for (Player player : currentGame.getPlayers()) {
                        System.out.println("\n" + player.getUsername() + ", please select a map type (1-7):");

                        // If it's the current player, get input directly
                        if (player.getUsername().equals(currentUsername)) {
                            while (true) {
                                System.out.print("Select a map for yourself ");
                                String mapInput = scanner.nextLine().trim();

                                if (mapInput.matches("\\d+")) {
                                    int mapNumber = Integer.parseInt(mapInput);
                                    Result mapResult = controller.selectMap(mapNumber);
                                    System.out.println(mapResult.message());
                                    break;/////be careful kiaaaaaaaasha/////////////////////////////////////
                                } else {
                                    System.out.println("Invalid map selection. Please choose the right map number.");
                                }
                            }
                        } else {
                            // For other players, we'll simulate their selection (in a real networked game,
                            // they would make their own selections)
                            // For now, we'll just assign a random map type
                            // int randomMapType = 1 + (int)(Math.random() * 7);
                            // System.out.println("Selecting map for " + player.getUsername());
                            // System.out.println(player.getUsername() + " selected map type " +
                            // randomMapType);
                            while (true) {
                                System.out.println("Selecting map for " + player.getUsername());
                                String mapInput = scanner.nextLine().trim();

                                if (mapInput.matches("\\d+")) {
                                    int mapNumber = Integer.parseInt(mapInput);
                                    // Result mapResult = controller.selectMap(mapNumber);
                                    // System.out.println(mapResult.message());
                                    Player originalPlayer = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
                                    App.dataManager.getCurrentGame().setCurrentTurnPlayer(player);
                                    Result mapResult = controller.selectMap(mapNumber);
                                    System.out.println(mapResult.message());
                                    App.dataManager.getCurrentGame().setCurrentTurnPlayer(originalPlayer);
                                    if (mapResult.success()) {
                                        break;
                                    }
                                    /////be careful kiaaaaaaaasha/////////////////////////////////////
                                }
                                System.out.println("Invalid map selection. Please choose the right map number.");

                            }

                        }
                    }
                }
            }
        }
    }

    private void handleMapSelection(String input) {
        Pattern pattern = Pattern.compile("\\s*game\\s+map\\s+(\\d+)\\s*");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int mapNumber = Integer.parseInt(matcher.group(1));
            Result result = controller.selectMap(mapNumber);
            System.out.println(result.message());

            if (result.success() && result.message().contains("Game is now active")) {
                // Game is active, enter the game
                App.dataManager.setCurrentMenu(Menu.GAME_MENU);
            }
        }
    }

    private void handleNextTurn() {
        Result result = controller.nextTurn();
        System.out.println(result.message());
    }

    private void handleLoadGame() {
        Result result = controller.loadGame();
        System.out.println(result.message());

        if (result.success()) {
            // Enter the game
            App.dataManager.setCurrentMenu(Menu.GAME_MENU);
        }
    }

    private void handleExitGame() {

        // Return to main menu
        App.dataManager.setCurrentMenu(Menu.MAIN_MENU);

    }

    private void handleVoteTerminate(String input) {
        boolean vote = input.contains("yes");
        Result result = controller.voteToTerminateGame(vote);
        System.out.println(result.message());

        if (result.success() && result.message().contains("The game has been deleted")) {
            // Return to main menu
            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
        }
    }

    private void showHelp() {
        System.out.println("=== GAME MENU COMMANDS ===");
        System.out.println(
                "game new -u <username1> [username2] [username3] [username4] : Create a new game with specified players");
        System.out.println("game map <number> : Select a map type (1-7)");
        System.out.println("next turn : Pass turn to the next player");
        System.out.println("load game : Load a saved game");
        System.out.println("exit game : Exit the current game (only available to the game creator)");
        System.out.println("vote terminate <yes|no> : Vote to terminate the current game");
        System.out.println("game status : Show the current game status");
        System.out.println("back : Return to the main menu");
        System.out.println("help : Show this help message");
    }

    @Override
    public void getInput(String input, Scanner scanner) {

    }
}
