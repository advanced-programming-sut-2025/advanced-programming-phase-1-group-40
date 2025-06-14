package org.example.view;

import org.example.controller.Game.PreGameMenuController;
import org.example.models.App;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.PreGameMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;


public class PreGameMenu implements AppMenu {

    private final PreGameMenuController preGameMenuController = new PreGameMenuController();



    @Override
    public void getInput(String input, Scanner scanner) {
        Matcher matcher;
//        System.err.println("GAME OBJECT IS " + App.dataManager.getCurrentGame());
        if ( (matcher = PreGameMenuCommands.NEW_GAME.getMatcher(input)) != null ) {

            System.out.println(preGameMenuController.createNewGame(matcher.group("users"), scanner).message());
            preGameMenuController.setUpNewGame();


        }
        else if (  PreGameMenuCommands.SHOW_CURRENT_MENU.getMatcher(input) != null  ) {

            preGameMenuController.showCurrentMenu();

        }

        else if ( PreGameMenuCommands.SHOW_MAP.getMatcher(input) != null ) {
            System.out.println(preGameMenuController.handleShowMap());
        }

        else if ( PreGameMenuCommands.GO_TO_MAIN_MENU.getMatcher(input) != null  ) {

            App.dataManager.setCurrentMenu(Menu.MAIN_MENU);

        }
        else if ( PreGameMenuCommands.LOAD_GAME.getMatcher(input) != null ){

            System.out.println(preGameMenuController.loadGame().message());
            System.out.printf("It is " + App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername() + "'s turn: ");

        }
        else{

            System.out.println("Invalid input");

        }
//        System.err.println("GAME OBJECT IS " + App.dataManager.getCurrentGame());

    }


}
