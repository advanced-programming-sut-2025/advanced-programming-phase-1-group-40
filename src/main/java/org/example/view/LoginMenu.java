package org.example.view;

import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.enums.Menu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu implements AppMenu {
    private final LoginController controller = new LoginController();

    @Override
    public void getInput(String input, Scanner scanner) {
        // Handle login command
        if (input.matches("\\s*login\\s+-u\\s+([a-zA-Z0-9-]+)\\s+-p\\s+(.+)(?:\\s+--stay-logged-in)?\\s*")) {
            Pattern pattern = Pattern.compile("\\s*login\\s+-u\\s+([a-zA-Z0-9-]+)\\s+-p\\s+(.+)(\\s+--stay-logged-in)?\\s*");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String username = matcher.group(1);
                String password = matcher.group(2);
                boolean stayLoggedIn = matcher.group(3) != null;
                
                Result result = controller.login(username, password, stayLoggedIn);
                System.out.println(result.getMessage());
                
                if (result.isSuccess()) {
                    App.setCurrentMenu(Menu.MAIN_MENU);
                }
            }
        }
        // Handle register command
        else if (input.matches("\\s*register\\s+-u\\s+([a-zA-Z0-9-]+)\\s+-p\\s+(.+)\\s+(.+)\\s+-n\\s+(.+)\\s+-e\\s+(.+)\\s+-g\\s+(male|female)\\s*")) {
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
                org.example.models.enums.types.Gender gender = genderStr.equalsIgnoreCase("male") ? 
                    org.example.models.enums.types.Gender.MALE : org.example.models.enums.types.Gender.FEMALE;
                
                Result result = controller.registerUser(username, nickname, password, email, gender);
                System.out.println(result.getMessage());
                
                if (result.isSuccess()) {
                    System.out.println("Registration successful! You can now login.");
                }
            }
        }
        // Handle forgot password command
        else if (input.matches("\\s*forget\\s+password\\s+-u\\s+([a-zA-Z0-9-]+)\\s*")) {
            String username = input.replaceAll("\\s*forget\\s+password\\s+-u\\s+([a-zA-Z0-9-]+)\\s*", "$1");
            
            // Ask for email
            System.out.print("Please enter your email: ");
            String email = scanner.nextLine();
            
            Result result = controller.forgotPassword(username, email);
            System.out.println(result.getMessage());
            
            if (result.isSuccess() && result.getMessage().startsWith("Security Question:")) {
                // If security question exists, ask for answer
                System.out.print("Enter your answer: ");
                String answer = scanner.nextLine();
                
                Player user = null;
                for (Player p : App.users) {
                    if (p.getUsername().equals(username)) {
                        user = p;
                        break;
                    }
                }
                
                if (user != null) {
                    Result validationResult = controller.validateSecurityQuestion(user, answer);
                    System.out.println(validationResult.getMessage());
                    
                    if (validationResult.isSuccess()) {
                        // Ask for new password
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        
                        Result resetResult = controller.resetPassword(user, newPassword);
                        System.out.println(resetResult.getMessage());
                    }
                }
            }
        }
        // Handle answer command for security questions
        else if (input.matches("\\s*answer\\s+-a\\s+(.+)\\s*")) {
            String answer = input.replaceAll("\\s*answer\\s+-a\\s+(.+)\\s*", "$1");
            
            if (App.getCurrentPlayer() == null) {
                System.out.println("You need to be in the password recovery process to use this command.");
                return;
            }
            
            Result result = controller.validateSecurityQuestion(App.getCurrentPlayer(), answer);
            System.out.println(result.getMessage());
            
            if (result.isSuccess()) {
                // Ask for new password
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                
                Result resetResult = controller.resetPassword(App.getCurrentPlayer(), newPassword);
                System.out.println(resetResult.getMessage());
            }
        }
        // Handle exit command
        else if (input.matches("\\s*exit\\s*")) {
            App.setCurrentMenu(Menu.EXIT);
        }
        // Handle signup menu command
        else if (input.matches("\\s*signup\\s+menu\\s*")) {
            App.setCurrentMenu(Menu.SIGNUP_MENU);
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
        System.out.println("=== LOGIN MENU COMMANDS ===");
        System.out.println("login -u <username> -p <password> [--stay-logged-in] : Login with your credentials");
        System.out.println("register -u <username> -p <password> <password_confirm> -n <nickname> -e <email> -g <gender> : Register a new account");
        System.out.println("forget password -u <username> : Recover your password");
        System.out.println("answer -a <answer> : Answer security question during password recovery");
        System.out.println("signup menu : Go to the signup menu for more registration options");
        System.out.println("exit : Exit the application");
        System.out.println("help : Show this help message");
    }
}
