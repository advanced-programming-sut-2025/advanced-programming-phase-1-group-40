package org.example.view;

import org.example.controller.Game.GameController;
import org.example.controller.Game.PreGameMenuController;
import org.example.models.App;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.GameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;


public class PreGameMenu implements AppMenu {

    private final PreGameMenuController preGameMenuController = new PreGameMenuController();



    @Override
    public void getInput(String input, Scanner scanner) {
        Matcher matcher;
        if ( (matcher = GameMenuCommands.NEW_GAME.getMatcher(input)) != null ) {

            System.out.println(preGameMenuController.createNewGame(matcher.group("users"), scanner).message());
            preGameMenuController.setNewGameWeather();

        }
        else if (  GameMenuCommands.SHOW_CURRENT_MENU.getMatcher(input) != null  ) {

            preGameMenuController.showCurrentMenu();

        }

        else if ( GameMenuCommands.SHOW_MAP.getMatcher(input) != null ) {
            System.out.println(preGameMenuController.handleShowMap());
        }

        else if ( GameMenuCommands.GO_TO_MAIN_MENU.getMatcher(input) != null  ) {

            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);

        }
        else{

            System.out.println("Invalid input");

        }

    }


}
