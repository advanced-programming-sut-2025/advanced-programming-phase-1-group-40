package org.example.view;

import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;

import java.util.Scanner;

public class MainMenu implements AppMenu {
    private final MainMenuController controller = new MainMenuController();

    @Override
    public void getInput(String input, Scanner scanner) {
        // Handle menu navigation
        if (input.matches("\\s*menu\\s+enter\\s+(.+)\\s*")) {
            String menuName = input.replaceAll("\\s*menu\\s+enter\\s+(.+)\\s*", "$1");
            handleMenuNavigation(menuName);
        }
        // Handle menu exit
        else if (input.matches("\\s*menu\\s+exit\\s*")) {
            Result result = controller.exitMenu();
            System.out.println(result.message());
        }
        // Handle show current menu
        else if (input.matches("\\s*show\\s+current\\s+menu\\s*")) {
            Result result = controller.showCurrentMenu();
            System.out.println(result.message());
        }
        // Handle user logout
        else if (input.matches("\\s*user\\s+logout\\s*")) {
            App.dataManager.setCurrentUser(null);
            App.dataManager.setCurrentMenu(Menu.LOGIN_MENU);
            System.out.println("Logged out successfully.");
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
        Result result = controller.enterMenu(menuName);
        System.out.println(result.message());
    }
    
    private void showHelp() {
        System.out.println("=== MAIN MENU COMMANDS ===");
        System.out.println("menu enter <menu_name> : Enter a specific menu (Profile Menu, Game Menu, Avatar Menu)");
        System.out.println("menu exit : Exit to previous menu");
        System.out.println("show current menu : Display the current menu name");
        System.out.println("user logout : Logout from your account");
        System.out.println("help : Show this help message");
    }
}
