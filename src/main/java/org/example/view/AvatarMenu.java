package org.example.view;

import org.example.models.App;
import org.example.models.enums.Menu;

import java.util.Scanner;

public class AvatarMenu implements AppMenu {

    @Override
    public void getInput(String input, Scanner scanner) {
        // Handle menu navigation
        if (input.matches("\\s*menu\\s+enter\\s+(.+)\\s*")) {
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
            System.out.println("You are now in Avatar Menu");
        }
        // Handle help command
        else if (input.matches("\\s*help\\s*")) {
            showHelp();
        }
        else {
            System.out.println("Avatar customization is not implemented in this phase.");
        }
    }


    private void handleMenuNavigation(String menuName) {
        switch (menuName.toLowerCase()) {
            case "main menu":
                App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
                System.out.println("Returned to Main Menu");
                break;
            case "avatar customization":
                System.out.println("Avatar customization is not implemented in this phase.");
                break;
            default:
                System.out.println("Invalid menu name. Type 'help' for available commands.");
        }
    }

    private void showHelp() {
        System.out.println("Available commands in Avatar Menu:");
        System.out.println("  menu enter <menu_name> - Enter a specific menu");
        System.out.println("  menu exit - Return to Main Menu");
        System.out.println("  show current menu - Display the current menu name");
        System.out.println("  help - Show this help message");
    }
}
