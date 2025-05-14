package org.example.view;

import org.example.controller.User.LoginController;
import org.example.models.enums.commands.LoginCommands;

import java.util.Scanner;

public class LoginMenu implements AppMenu {

    private final LoginController loginController = new LoginController();


    @Override
    public void getInput(String input, Scanner scanner) {

        if ( LoginCommands.REGISTER.getMatcher(input) != null ) {

            System.out.println(loginController.registerUser(LoginCommands.REGISTER.getMatcher(input),scanner).message());

        }


        if ( LoginCommands.LOGIN.getMatcher(input) != null ) {

            System.out.println(loginController.login(LoginCommands.LOGIN.getMatcher(input)).message());

        }

        if ( LoginCommands.FORGET_PASSWORD.getMatcher(input) != null ) {

            System.out.println(loginController.forgotPassword(LoginCommands.FORGET_PASSWORD.getMatcher(input),scanner).message());

        }


        if ( LoginCommands.EXIT.getMatcher(input) != null ) {

            loginController.exit();

        }

        if ( LoginCommands.SHOW_CURRENT_MENU.getMatcher(input) != null ) {

            System.out.println(loginController.showCurrentMenu());

        }


        else{

            System.out.println("Invalid");

        }


    }
    


}
