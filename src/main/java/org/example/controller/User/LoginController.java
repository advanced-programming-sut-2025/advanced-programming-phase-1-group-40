package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.Menu;
import org.example.models.enums.SecurityQuestion;
import org.example.models.enums.commands.LoginCommands;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;

public class LoginController {


    ///  REGISTER

    public Result registerUser(Matcher input) {

        String username = input.group("username");
        String password = input.group("password");
        String repeatPassword = input.group("repeatPassword");
        String nickname = input.group("nickname");
        String email = input.group("email");
        String gender = input.group("gender");


        if ( ! usernameAlreadyExists(username)) {
            return new Result(false, "Username already exists!");
        }


        if ( ! isUsernameValid(username) ) {
            return new Result(false, "Invalid username format!");
        }


        if ( ! isEmailValid(email) ) {
            return new Result(false, "Invalid email format.");
        }




        // EVERYTHING FINE -> CREATE USER

        User newUser = new User(username, password, nickname, email, gender);



        return new Result(true, "Successfully registered.");
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

        if ( LoginCommands.EMAIL_USER_REGEX.getMatcher(user) != null ) {
            return false;
        }

        if ( LoginCommands.EMAIL_DOMAIN_REGEX.getMatcher(domain) != null ) {
            return false;
        }

        return true;


    }



    ///  LOGIN

    public Result login(String username, String password, boolean stayLoggedIn) {
        Player user = getUserByUsername(username);

        if (user == null) {
            return new Result(false, "Username not found!");
        }

        if (!user.getPassword().equals(password)) {
            return new Result(false, "Password is incorrect!");
        }

        App.dataManager.setCurrentUser(user);

        // Implement stay-logged-in functionality
        if (stayLoggedIn) {
            App.dataManager.setStayLoggedIn(username, true);
        }

        App.dataManager.setCurrentMenu(Menu.MAIN_MENU);
        return new Result(true, "Login successful! Welcome, " + username + "!");
    }






    public Result randomPasswordGenerator() {
        int length = new Random().nextInt(13) + 8;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?><,';:/|][}{+=)(*&^%$#!";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
        }
        return new Result(true, sb.toString());
    }



    public Result showSecurityQuestions() {
        for (SecurityQuestion question : SecurityQuestion.values()) {
            System.out.println(question);
        }
        return new Result(true, "Security questions displayed.");
    }



    public Result pickAndAnswerSecurityQuestion(Player user, int questionNumber, String answer) {
        if (user == null) {
            return new Result(false, "User not found");
        }

        if (user.getQAndA() == null) {
            user.setQAndA(new HashMap<>());
        }

        SecurityQuestion selectedQuestion = SecurityQuestion.getByNumber(questionNumber);

        if (selectedQuestion == null) {
            return new Result(false, "Invalid question number");
        }

        user.getQAndA().put(selectedQuestion, answer);

        return new Result(true, "Security question saved");
    }



    public Result forgotPassword(String username, String email) {
        Player user = (Player) getUserByUsername(username);
        if (user == null) {
            return new Result(false, "User not found");
        }

        // Check if email matches
        if (!user.getEmail().equals(email)) {
            return new Result(false, "Email does not match the username");
        }

        if (user.getQAndA() != null && !user.getQAndA().isEmpty()) {
            SecurityQuestion question = user.getQAndA().keySet().iterator().next();
            return new Result(true, "Security Question: " + question.getQuestionText());
        }

        // If no security question is set, generate a random password
        Result rand = randomPasswordGenerator();
        String newPassword = rand.message();
        user.setPassword(newPassword);
        return new Result(true, "Your new password is: " + newPassword);
    }



    public Result validateSecurityQuestion(Player user, String answerToSecurityQuestion) {
        if (user == null || user....getQAndA() == null || user.getQAndA().isEmpty()) {
            return new Result(false, "No security question set for this user.");
        }

        SecurityQuestion question = user.getQAndA().keySet().iterator().next();
        String correctAnswer = user.getQAndA().get(question);

        if (correctAnswer.equalsIgnoreCase(answerToSecurityQuestion)) {
            return new Result(true, "Security question has been validated successfully.");
        } else {
            return new Result(false, "Incorrect answer.");
        }
    }



    public Result resetPassword(Player user, String newPassword) {
        if (user == null) {
            return new Result(false, "User not found");
        }

        user.setPassword(newPassword);
        return new Result(true, "Password has been reset successfully.");
    }




    private User getUserByUsername(String username) {
        for (User user : App.dataManager.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }



    private String generateAlternativeUsername(String username) {
        Random random = new Random();
        return username + "-" + random.nextInt(1000);
    }





    public Result checkSecurityAnswer(String forgotPasswordUsername, String answer) {
        // TODO
        return null;
    }


}
