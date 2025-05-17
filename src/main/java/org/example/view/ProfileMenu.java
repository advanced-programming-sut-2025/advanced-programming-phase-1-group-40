package org.example.view;

import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.ProfileCommands;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu implements AppMenu {

    private final ProfileController profileController = new ProfileController();

    @Override
    public void getInput(String input, Scanner scanner) {

        if ( ProfileCommands.CHANGE_USERNAME.getMatcher(input) != null ) {

            System.out.println(profileController.changeUsername(ProfileCommands.CHANGE_USERNAME.getMatcher(input)).message());

        }
        else if ( ProfileCommands.CHANGE_NICKNAME.getMatcher(input) != null ) {

            System.out.println(profileController.changeNickname(ProfileCommands.CHANGE_NICKNAME.getMatcher(input)).message());


        }
        else if ( ProfileCommands.CHANGE_EMAIL.getMatcher(input) != null ) {

            System.out.println(profileController.changeEmail(ProfileCommands.CHANGE_EMAIL.getMatcher(input)).message());


        }
        else if ( ProfileCommands.CHANGE_PASSWORD.getMatcher(input) != null ) {

            System.out.println(profileController.changePassword(ProfileCommands.CHANGE_PASSWORD.getMatcher(input)).message());


        }
        else if ( ProfileCommands.SHOW_USER_INFO.getMatcher(input) != null ) {

            profileController.showUserInfo();

        }
        else if ( ProfileCommands.GO_TO_MAIN_MENU.getMatcher(input) != null ) {

            profileController.goToMenu(Menu.MAIN_MENU);

        }
        else if ( ProfileCommands.SHOW_CURRENT_MENU.getMatcher(input) != null ) {

            profileController.showCurrentMenu();

        }
        else if ( ProfileCommands.EXIT_MENU.getMatcher(input) != null ) {

            System.out.println(profileController.exitMenu().message());

        }
        else{

            System.out.println("Invalid input");

        }


    }

}
