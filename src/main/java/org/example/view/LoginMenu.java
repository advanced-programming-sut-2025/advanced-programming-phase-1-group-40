package org.example.view;

import org.example.controller.User.LoginController;
import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Menu;
import org.example.models.DataManager;
import org.example.models.enums.commands.LoginCommands;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu implements AppMenu {

    private final LoginController controller = new LoginController();


    @Override
    public void getInput(String input, Scanner scanner) {

        if (LoginCommands.REGISTER.equals(input)) {

            System.out.println("Register");

        }
        if (LoginCommands.PICK_QUESTION.equals(input)) {

            System.out.println("Pick question");

        }

        if (LoginCommands.LOGIN.equals(input)) {

            System.out.println("Login");

        }

        if (LoginCommands.FORGET_PASSWORD.equals(input)) {

            System.out.println("Forget password");

        }

        if (LoginCommands.ANSWER.equals(input)) {

            System.out.println("Answer");

        }

        if (LoginCommands.EXIT.equals(input)) {

            System.out.println("Exit");

        }

        if (LoginCommands.SHOW_CURRENT_MENU.equals(input)) {

            System.out.println("Show current menu");

        }


        else{

            System.out.println("Invalid");

        }


    }
    


}
