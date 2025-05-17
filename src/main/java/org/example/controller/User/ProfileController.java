package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.LoginCommands;

import java.util.regex.Matcher;

public class ProfileController {

    public void showCurrentMenu() {
        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());
    }

    public void goToMenu(Menu targetMenu){

        App.dataManager.setCurrentMenu(targetMenu);
        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());

    }

    public void showUserInfo() {

        System.out.println("Username: " + App.dataManager.getCurrentUser().getUsername());
        System.out.println("Nickname: " + App.dataManager.getCurrentUser().getNickname());
        System.out.println("Highest Earned Money: " + App.dataManager.getCurrentUser().getHighestEarnedMoney());
        System.out.println("Number of Games: " + App.dataManager.getCurrentUser().getGamesPlayed());


    }

    public Result changeUsername(Matcher input){

        String newUsername = input.group("username");

        if ( App.dataManager.getCurrentUser().getUsername().equals(newUsername) ) {
            return new Result(false, "You have to choose a ***NEW*** username");
        }

        if (  usernameAlreadyExists(newUsername)) {
            return new Result(false, "Username already exists!");
        }


        if ( ! isUsernameValid(newUsername) ) {
            return new Result(false, "Invalid username format!");
        }

        App.dataManager.getCurrentUser().setUsername(newUsername);
        return new Result(true, "Successfully changed username!");

    }

    public Result changeNickname(Matcher input){

        String newNickname = input.group("nickname");

        if ( App.dataManager.getCurrentUser().getNickname().equals(newNickname) ) {
            return new Result(false, "You have to choose a ***NEW*** nickname");
        }

        App.dataManager.getCurrentUser().setNickname(newNickname);
        return new Result(true, "Successfully changed nickname!");



    }

    public Result changeEmail(Matcher input){

        String newEmail = input.group("email");

        if ( App.dataManager.getCurrentUser().getEmail().equals(newEmail) ) {
            return new Result(false, "You have to choose a ***NEW*** email");
        }

        if ( ! isEmailValid(newEmail) ) {
            return new Result(false, "Invalid email format!");
        }

        App.dataManager.getCurrentUser().setEmail(newEmail);
        return new Result(true, "Successfully changed E-mail!");


    }

    public Result changePassword(Matcher input){

        String oldPassword = input.group("oldPassword");
        String newPassword = input.group("newPassword");

        if ( ! App.dataManager.getCurrentUser().getPassword().equals(oldPassword) ) {
            return new Result(false, "Wrong password!");
        }

        if ( oldPassword.equals(newPassword) ) {
            return new Result(false, "You have to choose a ***NEW*** password");
        }

        if ( !isPasswordValid(newPassword) ) {

            return new Result(false, "Invalid password format.");

        }

        if ( isPasswordWeak(newPassword) ) {

            return new Result(false, "Password is weak!");

        }

        App.dataManager.getCurrentUser().setPassword(newPassword);
        return new Result(true, "Successfully changed password!");

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

    public Result exitMenu() {

        App.dataManager.setCurrentMenu(Menu.MAIN_MENU);

        return new Result(true, "Exiting Profile Menu");

    }

}
