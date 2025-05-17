package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.Menu;
import org.example.models.enums.SecurityQuestion;
import org.example.models.enums.commands.LoginCommands;


import java.util.*;
import java.util.regex.Matcher;

public class LoginController {


    ///  REGISTER

    public Result registerUser(Matcher input, Scanner scanner) {

        String username = input.group("username");
        String password = input.group("password");
        String repeatPassword = input.group("repeatPassword");
        String nickname = input.group("nickname");
        String email = input.group("email");
        String gender = input.group("gender");


        if (  usernameAlreadyExists(username)) {
            return new Result(false, "Username already exists!");
        }


        if ( ! isUsernameValid(username) ) {
            return new Result(false, "Invalid username format!");
        }


        if ( ! isEmailValid(email) ) {
            return new Result(false, "Invalid email format.");
        }

        if (password.trim().equalsIgnoreCase("random")) {
            password = generateRandomPassword();

            System.out.println("Generated password: " + password);
            System.out.print("Do you want to use this password? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                repeatPassword = password;
            } else {
                System.out.println("You chose not to use the generated password.");
                System.out.println("1. Enter a new password manually");
                System.out.println("2. Cancel registration");
                System.out.print("Your choice: ");
                String choice = scanner.nextLine().trim();

                if (choice.equals("1")) {
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    System.out.print("Repeat password: ");
                    repeatPassword = scanner.nextLine();
                } else {
                    return new Result(false, "Registration cancelled.");
                }
            }
        }



        else {


            if (!isPasswordValid(password)) {

                return new Result(false, "Invalid password format.");

            }

            if (isPasswordWeak(password)) {

                return new Result(false, "Password is weak!");

            }

            if (!password.equals(repeatPassword)) {

                return new Result(false, "Passwords do not match!");

            }


        }



        Matcher securityQuestion = handleSecurityQuestion(scanner);

        String questionNumber = securityQuestion.group("questionNumber");
        String answer = securityQuestion.group("answer");



        User newUser = new User(username, password, nickname, email, gender,SecurityQuestion.getByNumber(Integer.parseInt(questionNumber)),answer);

        App.dataManager.addUser(newUser);

        return new Result(true, "Successfully registered.");

    }

    private void showQuestions() {

        System.out.println("Choose one of the following questions and type down your answer:");
        for ( SecurityQuestion question : SecurityQuestion.values() ) {

            System.out.println(question.toString());

        }

    }
//    public Result registerUser(Matcher matcher, Scanner scanner, String generatedPassword) {
//        String username = matcher.group("username");
//        String password = generatedPassword != null ? generatedPassword : matcher.group("password");
//        String repeatPassword = generatedPassword != null ? generatedPassword : matcher.group("repeatPassword");
//        String nickname = matcher.group("nickname");
//        String email = matcher.group("email");
//        String gender = matcher.group("gender");
//
//        return register(username, password, repeatPassword, nickname, email, gender);
//    }
//    private Result register(String username, String password, String repeatPassword, String nickname, String email, String gender) {
//
//        if (!password.equals(repeatPassword)) {
//            return new Result(false, "Passwords do not match.");
//        }
//        return new Result(true, "User registered successfully!");
//    }
//



    private Matcher handleSecurityQuestion(Scanner scanner) {

        showQuestions();

        String securityQuestionAnswer = scanner.nextLine().trim();
        Matcher matcher = LoginCommands.PICK_QUESTION.getMatcher(securityQuestionAnswer);

        while ( !(

                        matcher != null

                        &&

                        (
                                matcher.group("answer")
                                                .equals(
                                        matcher.group("answerConfirm"))))
        )
        {

            if ( matcher == null ){
                System.out.println("Invalid input.");
            }
            else{
                System.out.println("Answers don't match.");
            }

            showQuestions();
            securityQuestionAnswer = scanner.nextLine();

        }

        return LoginCommands.PICK_QUESTION.getMatcher(securityQuestionAnswer);

    }

    public boolean usernameAlreadyExists(String username) {

        for ( User user : App.dataManager.getAllUsers() ){

            if ( user.getUsername().equals(username) ){

                return true;

            }

        }

        return false;

    }

    private boolean isUsernameValid(String username) {

        return (LoginCommands.USERNAME_REGEX.getMatcher(username) != null);

    }

    private boolean isEmailValid(String email) {

        if ( ! email.contains("@") ) {
            return false;
        }

        String user = email.substring(0, email.indexOf("@"));
        String domain = email.substring(email.indexOf("@") + 1);

        if ( user.contains("@") || domain.contains("@") || (user.isEmpty()) || (domain.isEmpty()) ) {

            return false;

        }

        if ( LoginCommands.EMAIL_USER_REGEX.getMatcher(user) == null ) {
            return false;
        }

        if ( LoginCommands.EMAIL_DOMAIN_REGEX.getMatcher(domain) == null ) {
            return false;
        }

        if ( email.contains(LoginCommands.EMAIL_SPECIAL_CHAR.getRegexString()) ) {
            return false;
        }


        return true;


    }

    private boolean isPasswordValid(String password) {

        return ( LoginCommands.PASSWORD_REGEX.getMatcher(password) != null );

    }

    private boolean isPasswordWeak(String password) {

        if ( password.length() < 8 ) {

            return true;

        }

        if ( password.toLowerCase().equals(password) || password.toUpperCase().equals(password) ) {
            //  AGE HAMASH KOOCHIK YA BOZORG BASHE

            return true;

        }

        if ( LoginCommands.PASSWORD_CONTAINS_DIGITS.getMatcher(password) == null ) {

            return true;

        }


        if ( LoginCommands.PASSWORD_SPECIAL_CHAR.getMatcher(password) == null ) {

            return true;

        }

        return false;

    }

    public String generateRandomPassword() {                       ///  TODO: BAYAD CHECK BESHE K PASS GENERATE SHODE OK BASHE!!!

        int length = new Random().nextInt(13) + 8;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?><,';:/|][}{+=)(*&^%$#!";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
        }

        return sb.toString();

    }




    ///  LOGIN

    public Result login(Matcher input) {

        String username = input.group("username");
        String password = input.group("password");
        boolean stayLoggedIn = (input.group(3) != null);


        for ( User user : App.dataManager.getAllUsers() ){

            if ( user.getUsername().equals(username) ){

                if ( user.getPassword().equals(password) ){


                    App.dataManager.setCurrentUser(user);
                    user.setStayLoggedInNextTime(stayLoggedIn);
                    App.dataManager.setCurrentMenu(Menu.MAIN_MENU);

                    return new Result(true, "Login Successful. You are now in Main Menu.");

                }


                return new Result(false, "Password is incorrect.");

            }

        }

        return new Result(false, "Username does not exist.");


    }

    public Result forgotPassword(Matcher input,Scanner scanner) {

        String username = input.group("username");

        for ( User user : App.dataManager.getAllUsers() ){

            if ( user.getUsername().equals(username) ){

                Result securityQuestionResult = validateSecurityQuestion(user,scanner);

                if ( securityQuestionResult.success() ){

                    System.out.println("Security Question Correct. Please enter your new password:");
                    String newPassword = scanner.nextLine().trim();

                    if ( newPassword.equals("random") ) {

                        newPassword = generateRandomPassword();

                    }

                    else {


                        if ( ! isPasswordValid(newPassword) ) {

                            return new Result(false, "Invalid password format.");

                        }

                        if ( isPasswordWeak(newPassword) ) {

                            return new Result(false, "Password is weak!");

                        }


                    }

                    user.setPassword(newPassword);
                    return new Result(true, "Password successfully changed.");

                }

                return new Result(false,securityQuestionResult.message());


            }

        }


        return new Result(false, "Username does not exist.");


    }

    private Result validateSecurityQuestion(User user,Scanner scanner) {

        System.out.println("Type down your answer to the security question:");
        System.out.println(user.getSecurityQuestion());
        System.out.println("Your answer:");
        String answer = scanner.nextLine().trim();

        if ( LoginCommands.ANSWER.getMatcher(answer) != null ) {
            return new Result(false,"Incorrect answer format. Try again");
        }

        if (user.getSecurityAnswer().equals(answer)) {
            return new Result(true,"");
        }
        return new Result(false,"Security Question answer was incorrect.");


    }


    ///  SHOW CURRENT MENU

    public String showCurrentMenu() {
        return Menu.LOGIN_MENU.getDisplayName();
    }

    ///  EXIT

    public void exit(){
        App.dataManager.setCurrentMenu(Menu.EXIT);
    }

}
