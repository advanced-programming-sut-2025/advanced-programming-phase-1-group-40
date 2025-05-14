package org.example.view;

import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.MainMenuCommands;

import java.util.Scanner;

public class MainMenu implements AppMenu {

    private final MainMenuController mainMenuController = new MainMenuController();

    @Override
    public void getInput(String input, Scanner scanner) {

        if (MainMenuCommands.GO_TO_PROFILE_MENU.getMatcher(input) != null) {

            mainMenuController.goToMenu(Menu.PROFILE_MENU);

        }
        else if (MainMenuCommands.GO_TO_GAME_MENU.getMatcher(input) != null) {

            mainMenuController.goToMenu(Menu.GAME_MENU);

        }
        else if (MainMenuCommands.GO_TO_AVATAR_MENU.getMatcher(input) != null) {

            mainMenuController.goToMenu(Menu.AVATAR_MENU);

        }
        else if (MainMenuCommands.USER_LOGOUT.getMatcher(input) != null) {

            mainMenuController.logout();

        }
        else if (MainMenuCommands.SHOW_CURRENT_MENU.getMatcher(input) != null) {

            mainMenuController.showCurrentMenu();

        }
        else{

            System.out.println("Invalid input");

        }




    }

}
