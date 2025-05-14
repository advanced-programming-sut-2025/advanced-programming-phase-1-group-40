package org.example.view;

import org.example.controller.User.LoginController;
import org.example.controller.Game.GameMenuController;
import org.example.controller.Game.GameMenuController;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.GameMenuCommands;

import java.util.Scanner;


public class GameMenu implements AppMenu {

    private final GameMenuController gameMenuController = new GameMenuController();



    @Override
    public void getInput(String input, Scanner scanner) {

        if ( GameMenuCommands.NEW_GAME.getMatcher(input) != null ) {



        }
        else if (  GameMenuCommands.SHOW_CURRENT_MENU.getMatcher(input) != null  ) {

            gameMenuController.showCurrentMenu();

        }
        else if ( GameMenuCommands.GO_TO_MAIN_MENU.getMatcher(input) != null  ) {

            gameMenuController.goToMenu(Menu.MAIN_MENU);

        }
        else{

            System.out.println("Invalid input");

        }

    }


}
