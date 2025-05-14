package org.example.view;

import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Menu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu implements AppMenu {
    private final ProfileController controller = new ProfileController();

    @Override
    public void getInput(String input, Scanner scanner) {
        // Handle change username command
        if (input.matches("\\s*change\\s+username\\s+-u\\s+([a-zA-Z0-9-]+)\\s*")) {
            String newUsername = input.replaceAll("\\s*change\\s+username\\s+-u\\s+([a-zA-Z0-9-]+)\\s*", "$1");
            Result result = controller.changeUsername(newUsername);
            System.out.println(result.message());
        }
        // Handle change nickname command
        else if (input.matches("\\s*change\\s+nickname\\s+-u\\s+([a-zA-Z0-9-]+)\\s*")) {
            String newNickname = input.replaceAll("\\s*change\\s+nickname\\s+-u\\s+([a-zA-Z0-9-]+)\\s*", "$1");
            Result result = controller.changeNickname(newNickname);
            System.out.println(result.message());
        }
        // Handle change email command
        else if (input.matches("\\s*change\\s+email\\s+-e\\s+(.+)\\s*")) {
            String newEmail = input.replaceAll("\\s*change\\s+email\\s+-e\\s+(.+)\\s*", "$1");
            Result result = controller.changeEmail(newEmail);
            System.out.println(result.message());
        }
        // Handle change password command
        else if (input.matches("\\s*change\\s+password\\s+-p\\s+(.+)\\s+-o\\s+(.+)\\s*")) {
            Pattern pattern = Pattern.compile("\\s*change\\s+password\\s+-p\\s+(.+)\\s+-o\\s+(.+)\\s*");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String newPassword = matcher.group(1);
                String oldPassword = matcher.group(2);
                Result result = controller.changePassword(oldPassword, newPassword);
                System.out.println(result.message());
            }
        }
        // Handle user info command
        else if (input.matches("\\s*user\\s+info\\s*")) {
            showUserInfo();
        }
        // Handle menu navigation
        else if (input.matches("\\s*menu\\s+enter\\s+(.+)\\s*")) {
            String menuName = input.replaceAll("\\s*menu\\s+enter\\s+(.+)\\s*", "$1");
            handleMenuNavigation(menuName);
        }
        // Handle menu exit
        else if (input.matches("\\s*menu\\s+exit\\s*")) {
            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
            System.out.println("Returned to Main Menu");
        }
        // Handle show current menu
        else if (input.matches("\\s*show\\s+current\\s+menu\\s*")) {
            System.out.println("You are now in Profile Menu");
        }
        // Handle help command
        else if (input.matches("\\s*help\\s*")) {
            showHelp();
        }
        else {
            System.out.println("Invalid command. Type 'help' to see available commands.");
        }
    }

    private void handleMenuNavigation(String menuName) {
        if (menuName.equalsIgnoreCase("Main Menu")) {
            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
            System.out.println("Menu switched to Main Menu");
        } else {
            System.out.println("Cannot switch to " + menuName + " from Profile Menu. Return to Main Menu first.");
        }
    }

    private void showUserInfo() {
        User currentPlayer = App.dataManager.getCurrentUser();
        if (currentPlayer != null) {
            System.out.println("=== USER INFORMATION ===");
            System.out.println("Username: " + currentPlayer.getUsername());
            System.out.println("Nickname: " + currentPlayer.getNickname());
            System.out.println("Highest Money: " + ((Player) currentPlayer).getHighestMoney());
            System.out.println("Games Played: " + ((Player) currentPlayer).getGamesPlayed());
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    private void showHelp() {
        System.out.println("=== PROFILE MENU COMMANDS ===");
        System.out.println("change username -u <username> : Change your username");
        System.out.println("change nickname -u <nickname> : Change your nickname");
        System.out.println("change email -e <email> : Change your email address");
        System.out.println("change password -p <new_password> -o <old_password> : Change your password");
        System.out.println("user info : Display your user information");
        System.out.println("menu enter <menu_name> : Enter a specific menu (only Main Menu is valid)");
        System.out.println("menu exit : Return to Main Menu");
        System.out.println("show current menu : Display the current menu name");
        System.out.println("help : Show this help message");
    }


}
