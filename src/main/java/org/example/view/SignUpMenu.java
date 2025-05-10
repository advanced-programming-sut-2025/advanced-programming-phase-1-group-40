package org.example.view;

import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;
import org.example.models.enums.types.Gender;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpMenu implements AppMenu {
    private final LoginController controller = new LoginController();

    @Override
    public void getInput(String input, Scanner scanner) {
        // Handle register command with all details
        if (input.matches("\\s*register\\s+-u\\s+([a-zA-Z0-9-]+)\\s+-p\\s+(.+)\\s+(.+)\\s+-n\\s+(.+)\\s+-e\\s+(.+)\\s+-g\\s+(male|female)\\s*")) {
            Pattern pattern = Pattern.compile("\\s*register\\s+-u\\s+([a-zA-Z0-9-]+)\\s+-p\\s+(.+)\\s+(.+)\\s+-n\\s+(.+)\\s+-e\\s+(.+)\\s+-g\\s+(male|female)\\s*");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String username = matcher.group(1);
                String password = matcher.group(2);
                String confirmPassword = matcher.group(3);
                String nickname = matcher.group(4);
                String email = matcher.group(5);
                String genderStr = matcher.group(6);
                
                // Check if passwords match
                if (!password.equals(confirmPassword)) {
                    System.out.println("Passwords do not match!");
                    return;
                }
                
                // Convert gender string to enum
                Gender gender = genderStr.equalsIgnoreCase("male") ? Gender.MALE : Gender.FEMALE;
                
                Result result = controller.registerUser(username, nickname, password, email, gender);
                System.out.println(result.getMessage());
                
                if (result.isSuccess()) {
                    System.out.println("Registration successful! You can now set a security question.");
                }
            }
        }
        // Handle show security questions command
        else if (input.matches("\\s*show\\s+questions\\s*")) {
            controller.showSecurityQuestions();
        }
        // Handle pick security question command
        else if (input.matches("\\s*pick\\s+question\\s+-q\\s+(\\d+)\\s+-a\\s+(.+)\\s*")) {
            Pattern pattern = Pattern.compile("\\s*pick\\s+question\\s+-q\\s+(\\d+)\\s+-a\\s+(.+)\\s*");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int questionNumber = Integer.parseInt(matcher.group(1));
                String answer = matcher.group(2);
                
                if (App.getCurrentPlayer() == null) {
                    System.out.println("You need to register first before picking a security question.");
                    return;
                }
                
                Result result = controller.pickAndAnswerSecurityQuestion(App.getCurrentPlayer(), questionNumber, answer);
                System.out.println(result.getMessage());
            }
        }
        // Handle random password generation
        else if (input.matches("\\s*random\\s+password\\s*")) {
            Result result = controller.randomPasswordGenerator();
            System.out.println("Generated password: " + result.getMessage());
        }
        // Handle back command
        else if (input.matches("\\s*back\\s*")) {
            App.setCurrentMenu(Menu.LOGIN_MENU);
        }
        // Handle help command
        else if (input.matches("\\s*help\\s*")) {
            showHelp();
        }
        else {
            System.out.println("Invalid command. Type 'help' to see available commands.");
        }
    }
    
    private void showHelp() {
        System.out.println("=== SIGNUP MENU COMMANDS ===");
        System.out.println("register -u <username> -p <password> <password_confirm> -n <nickname> -e <email> -g <male|female> : Register with full details");
        System.out.println("show questions : Display available security questions");
        System.out.println("pick question -q <question_number> -a <answer> : Set a security question and answer");
        System.out.println("random password : Generate a random password");
        System.out.println("back : Return to login menu");
        System.out.println("help : Show this help message");
    }
}
