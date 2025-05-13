package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.commands.LoginCommands;

public class ProfileController {

    public Result changeUsername(String newUsername) {
        Player currentPlayer = App.dataManager.getCurrentPlayer();

        if (currentPlayer == null) {
            return new Result(false, "No user is currently logged in.");
        }

        // Check if username is the same as current
        if (currentPlayer.getUsername().equals(newUsername)) {
            return new Result(false, "The new username is the same as your current username.");
        }

        // Check if username is valid
        if (!LoginCommands.USERNAME_REGEX.matches(newUsername)) {
            return new Result(false, "Invalid username format. Username can only contain letters, numbers, and hyphens.");
        }

        // Check if username already exists
        if (App.dataManager.getUserByUsername(newUsername) != null) {
            return new Result(false, "Username already exists.");
        }

        currentPlayer.setUsername(newUsername);
        return new Result(true, "Username successfully changed.");
    }

    public Result changeNickname(String newNickname) {
        Player currentPlayer = App.dataManager.getCurrentPlayer();

        if (currentPlayer == null) {
            return new Result(false, "No user is currently logged in.");
        }

        // Check if nickname is the same as current
        if (currentPlayer.getNickname().equals(newNickname)) {
            return new Result(false, "The new nickname is the same as your current nickname.");
        }

        currentPlayer.setNickname(newNickname);
        return new Result(true, "Nickname successfully changed.");
    }

    public Result changeEmail(String newEmail) {
        Player currentPlayer = App.dataManager.getCurrentPlayer();

        if (currentPlayer == null) {
            return new Result(false, "No user is currently logged in.");
        }

        // Check if email is the same as current
        if (currentPlayer.getEmail().equals(newEmail)) {
            return new Result(false, "The new email is the same as your current email.");
        }

        // Check if email is valid
        if (!LoginCommands.EMAIL_REGEX.matches(newEmail)) {
            return new Result(false, "Invalid email format. Please enter a valid email address.");
        }

        // Check if email already exists
        for (Player player : App.dataManager.getUsers()) {
            if (player.getEmail().equals(newEmail)) {
                return new Result(false, "Email already in use.");
            }
        }

        currentPlayer.setEmail(newEmail);
        return new Result(true, "Email successfully changed.");
    }

    public Result changePassword(String oldPassword, String newPassword) {
        Player currentPlayer = App.dataManager.getCurrentPlayer();

        if (currentPlayer == null) {
            return new Result(false, "No user is currently logged in.");
        }

        // Check if old password is correct
        if (!currentPlayer.getPassword().equals(oldPassword)) {
            return new Result(false, "Old password is incorrect.");
        }

        // Check if new password is the same as current
        if (currentPlayer.getPassword().equals(newPassword)) {
            return new Result(false, "The new password is the same as your current password.");
        }

        // Check if password is valid
        if (!LoginCommands.PASSWORD_REGEX.matches(newPassword)) {
            return new Result(false, "Invalid password format.");
        }

        // Check if password is strong
        if (newPassword.length() < 8) {
            return new Result(false, "Password is too weak: must be at least 8 characters long.");
        }

        boolean hasUpperCase = !newPassword.equals(newPassword.toLowerCase());
        boolean hasLowerCase = !newPassword.equals(newPassword.toUpperCase());
        boolean hasDigit = newPassword.matches(".*\\d.*");
        boolean hasSpecial = newPassword.matches(".*[?<>,\"';:\\\\/|\\[\\]{}+=)(*&^%$#!].*");

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecial)) {
            StringBuilder reason = new StringBuilder("Password is too weak: must contain ");
            if (!hasUpperCase) reason.append("uppercase letters, ");
            if (!hasLowerCase) reason.append("lowercase letters, ");
            if (!hasDigit) reason.append("digits, ");
            if (!hasSpecial) reason.append("special characters, ");

            return new Result(false, reason.substring(0, reason.length() - 2) + ".");
        }

        currentPlayer.setPassword(newPassword);
        return new Result(true, "Password successfully changed.");
    }
}
