package org.example.view;

import org.example.controller.User.LoginController;
import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Menu;
import org.example.models.persistence.DataManager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu implements AppMenu {
    private final LoginController controller = new LoginController();
    private String forgotPasswordUsername = null;
    private String forgotPasswordEmail = null;

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
                System.out.println(result.message());
            }
        }
        // Handle forgot password command
        else if (input.matches("\\s*forget\\s+password\\s+-u\\s+([a-zA-Z0-9-]+)\\s*")) {
            String username = input.replaceAll("\\s*forget\\s+password\\s+-u\\s+([a-zA-Z0-9-]+)\\s*", "$1");
            handleForgotPassword(username, scanner);
        }
        // Handle answer command (for security question)
        else if (forgotPasswordUsername != null && input.matches("\\s*answer\\s+-a\\s+(.+)\\s*")) {
            String answer = input.replaceAll("\\s*answer\\s+-a\\s+(.+)\\s*", "$1");
            handleSecurityAnswer(answer, scanner);
        }
        // Handle menu navigation
        else if (input.matches("\\s*menu\\s+enter\\s+(.+)\\s*")) {
            String menuName = input.replaceAll("\\s*menu\\s+enter\\s+(.+)\\s*", "$1");
            handleMenuNavigation(menuName);
        }
        // Handle menu exit
        else if (input.matches("\\s*menu\\s+exit\\s*")) {
            System.out.println("Exiting the application...");
            System.exit(0);
        }
        // Handle show current menu
        else if (input.matches("\\s*show\\s+current\\s+menu\\s*")) {
            System.out.println("You are now in Login Menu");
        }
        // Handle help command
        else if (input.matches("\\s*help\\s*")) {
            showHelp();
        }
        else {
            System.out.println("Invalid command. Type 'help' to see available commands.");
        }
    }
    
    private void handleForgotPassword(String username, Scanner scanner) {
        System.out.print("Please enter your email: ");
        String email = scanner.nextLine().trim();
        
        Result result = controller.forgotPassword(username, email);
        System.out.println(result. message());
        
        if (result.success()) {
            forgotPasswordUsername = username;
            forgotPasswordEmail = email;
        }
    }
    
    private void handleSecurityAnswer(String answer, Scanner scanner) {
        Result result = controller.checkSecurityAnswer(forgotPasswordUsername, answer);
        
        if (result.success()) {
            System.out.println("Security answer is correct. Please enter a new password:");
            String newPassword = scanner.nextLine().trim();
            User user = DataManager.getInstance().getUserByUsername(forgotPasswordUsername);
            Result passwordResult = controller.resetPassword((Player) user, newPassword);
            System.out.println(passwordResult. message());
            
            // Reset the forgot password state
            forgotPasswordUsername = null;
            forgotPasswordEmail = null;
        } else {
            System.out.println("Incorrect security answer. Please try again or use a different recovery method.");
            // Reset the forgot password state
            forgotPasswordUsername = null;
            forgotPasswordEmail = null;
        }
    }
    
    private void handleMenuNavigation(String menuName) {
        if (menuName.equalsIgnoreCase("Signup Menu")) {
            App.setCurrentMenu(Menu.SIGNUP_MENU);
            System.out.println("Menu switched to Signup Menu");
        } else {
            System.out.println("Cannot switch to " + menuName + " from Login Menu.");
        }
    }
    
    private void showHelp() {
        System.out.println("=== LOGIN MENU COMMANDS ===");
        System.out.println("login -u <username> -p <password> [--stay-logged-in] : Login to your account");
        System.out.println("forget password -u <username> : Recover your password");
        System.out.println("answer -a <answer> : Answer the security question for password recovery");
        System.out.println("menu enter <menu_name> : Enter a specific menu (only Signup Menu is valid)");
        System.out.println("menu exit : Exit the application");
        System.out.println("show current menu : Display the current menu name");
        System.out.println("help : Show this help message");
    }
}
