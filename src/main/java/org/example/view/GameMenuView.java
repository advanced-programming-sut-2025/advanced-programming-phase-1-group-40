package org.example.view;

import org.example.models.App;
import org.example.controller.Game.GameMenuController;
import org.example.models.Game;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Menu;
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
    private final GameMenuController controller;

    public GameMenuView() {
        this.controller = new GameMenuController();
    }

    public void run(Scanner scanner) {
        System.out.println("=== GAME MENU ===");
        System.out.println("Type 'help' to see available commands.");

        while (App.dataManager.getCurrentMenu() == Menu.GAME_MENU) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            getInput(input, scanner);
        }
    }

    @Override
    public void getInput(String input, Scanner scanner) {
        // Handle new game command
        if (input.matches("\\s*game\\s+new\\s+-u\\s+([a-zA-Z0-9-]+)(\\s+[a-zA-Z0-9-]+){0,3}\\s*")) {
            handleNewGame(input, scanner);
        }
        // Handle map selection command
        else if (input.matches("\\s*game\\s+map\\s+(\\d+)\\s*")) {
            handleMapSelection(input);
        }
        // Handle next turn command
        else if (input.matches("\\s*next\\s+turn\\s*")) {
            handleNextTurn();
        }
        // Handle load game command
        else if (input.matches("\\s*load\\s+game\\s*")) {
            handleLoadGame();
        }
        // Handle exit game command
        else if (input.matches("\\s*exit\\s+game\\s*")) {
            handleExitGame();
        }
        // Handle vote to terminate command
        else if (input.matches("\\s*vote\\s+terminate\\s+(yes|no)\\s*")) {
            handleVoteTerminate(input);
        }
        // Handle game status command
        else if (input.matches("\\s*game\\s+status\\s*")) {
            handleGameStatus();
        }
        // Handle help command
        else if (input.matches("\\s*help\\s*")) {
            showHelp();
        }
        // Handle back command
        else if (input.matches("\\s*back\\s*")) {
            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
        }
        else {
            System.out.println("Invalid command. Type 'help' to see available commands.");
        }
    }

    private void handleNewGame(String input, Scanner scanner) {
        // Extract usernames
        Pattern pattern = Pattern.compile("\\s*game\\s+new\\s+-u\\s+([a-zA-Z0-9-]+(\\s+[a-zA-Z0-9-]+){0,3})\\s*");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String usernamesStr = matcher.group(1);
            List<String> usernames = new ArrayList<>(Arrays.asList(usernamesStr.split("\\s+")));

            // Add the current player if not already in the list
            String currentUsername = App.dataManager.getCurrentPlayer().getUsername();
            if (!usernames.contains(currentUsername)) {
                usernames.add(0, currentUsername);
            }

            // Ensure there's at least one other player besides the creator
            if (usernames.size() < 2) {
                System.out.println("Error: You need at least one other player to create a game.");
                return;
            }

            Result result = controller.createNewGame(usernames);
            System.out.println(result.message());

            if (result.success()) {
                // Ask each player to select a map
                System.out.println("\n" + controller.getMapTypeDescriptions());
                System.out.println("\nEach player needs to select a map type.");

                // Get map selections for all players
                Game currentGame = controller.getCurrentGame();
                if (currentGame != null) {
                    for (Player player : currentGame.getPlayers()) {
                        System.out.println("\n" + player.getUsername() + ", please select a map type (1-7):");

                        // If it's the current player, get input directly
                        if (player.getUsername().equals(currentUsername)) {
                            System.out.print("> ");
                            String mapInput = scanner.nextLine().trim();

                            if (mapInput.matches("\\d+")) {
                                int mapNumber = Integer.parseInt(mapInput);
                                Result mapResult = controller.selectMap(mapNumber);
                                System.out.println(mapResult.message());
                            } else {
                                System.out.println("Invalid map selection. Please use 'game map <number>' command.");
                            }
                        } else {
                            // For other players, we'll simulate their selection (in a real networked game, they would make their own selections)
                            // For now, we'll just assign a random map type
                            int randomMapType = 1 + (int)(Math.random() * 7);
                            System.out.println("(Simulating selection for " + player.getUsername() + ")");
                            System.out.println(player.getUsername() + " selected map type " + randomMapType);

                            // Temporarily set the current player to this player to make the selection
                            Player originalPlayer = App.dataManager.getCurrentPlayer();
                            App.dataManager.setCurrentPlayer(player);
                            Result mapResult = controller.selectMap(randomMapType);
                            System.out.println(mapResult.message());

                            // Restore the original player
                            App.dataManager.setCurrentPlayer(originalPlayer);
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
        Result result = controller.exitGame();
        System.out.println(result.message());

        if (result.success()) {
            // Return to main menu
            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
        }
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

    private void handleGameStatus() {
        String status = controller.getGameStatus();
        System.out.println(status);
    }

    private void showHelp() {
        System.out.println("=== GAME MENU COMMANDS ===");
        System.out.println("game new -u <username1> [username2] [username3] [username4] : Create a new game with specified players");
        System.out.println("game map <number> : Select a map type (1-7)");
        System.out.println("next turn : Pass turn to the next player");
        System.out.println("load game : Load a saved game");
        System.out.println("exit game : Exit the current game (only available to the game creator)");
        System.out.println("vote terminate <yes|no> : Vote to terminate the current game");
        System.out.println("game status : Show the current game status");
        System.out.println("back : Return to the main menu");
        System.out.println("help : Show this help message");
    }
}
