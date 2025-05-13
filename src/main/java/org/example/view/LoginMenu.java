package org.example.view;

import org.example.controller.User.LoginController;
import org.example.models.enums.commands.LoginCommands;

import java.util.Scanner;

public class LoginMenu implements AppMenu {

    private final LoginController loginController = new LoginController();


    @Override
    public void getInput(String input, Scanner scanner) {

        if ( LoginCommands.REGISTER.getMatcher(input) != null ) {

            loginController.registerUser(LoginCommands.REGISTER.getMatcher(input));

        }
        if ( LoginCommands.PICK_QUESTION.getMatcher(input) != null ) {

            System.out.println("Pick question");

        }

        if ( LoginCommands.LOGIN.getMatcher(input) != null ) {

            System.out.println("Login");

        }

        if ( LoginCommands.FORGET_PASSWORD.getMatcher(input) != null ) {

            System.out.println("Forget password");

        }

        if ( LoginCommands.ANSWER.getMatcher(input) != null ) {

            System.out.println("Answer");

        }

        if ( LoginCommands.EXIT.getMatcher(input) != null ) {

            System.out.println("Exit");

        }

        if ( LoginCommands.SHOW_CURRENT_MENU.getMatcher(input) != null ) {

            System.out.println("Show current menu");

        }


        else{

            System.out.println("Invalid");

        }


    }
    


}
