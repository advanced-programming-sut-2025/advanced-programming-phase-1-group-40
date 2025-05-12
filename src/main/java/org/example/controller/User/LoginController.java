package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.Menu;
import org.example.models.enums.SecurityQuestion;
import org.example.models.enums.types.Gender;
import org.example.models.persistence.DataManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LoginController {

    public Result login(String username, String password, boolean stayLoggedIn) {
        Player user = getUserByUsername(username);
        
        if (user == null) {
            return new Result(false, "Username not found!");
        }
        
        if (!user.getPassword().equals(password)) {
            return new Result(false, "Password is incorrect!");
        }
        
        App.setCurrentPlayer(user);
        
        // Implement stay-logged-in functionality
        if (stayLoggedIn) {
            DataManager.getInstance().setStayLoggedIn(username, true);
        }
        
        App.setCurrentMenu(Menu.MAIN_MENU);
        return new Result(true, "Login successful! Welcome, " + username + "!");
    }

    public Result registerUser(String username, String nickname, String password, String email, Gender gender) {
        // Check if username already exists
        if (getUserByUsername(username) != null) {
            // Generate alternative username
            String alternativeUsername = generateAlternativeUsername(username);
            return new Result(false, "Username already exists. Would you like to use " + alternativeUsername + " instead?");
        }
        
        // Validate username format
        if (!isUsernameValid(username)) {
            return new Result(false, "Invalid username format. Username can only contain letters, numbers, and hyphens.");
        }
        
        // Validate email format
        if (!isEmailValid(email)) {
            return new Result(false, "Invalid email format. Please enter a valid email address.");
        }
        
        // Create new player
        Player newPlayer = createUser(username, password, email, email, gender.name());
        newPlayer.setNickname(nickname);
        if (gender != null) {
            newPlayer.setGender(gender.name());
        }
        
        App.currentPlayer = newPlayer;
        App.users.add(newPlayer);
        return new Result(true, "Successfully registered.");
    }

    public Player createUser(String username, String password, String email, String nickname, String gender) {
        Player newPlayer = new Player(new User(username, password, email, nickname, gender));
        return newPlayer;
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
        Player user = getUserByUsername(username);
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
        if (user == null || user.getQAndA() == null || user.getQAndA().isEmpty()) {
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

    // Helper methods
    private Player getUserByUsername(String username) {
        for (Player user : App.users) {
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

    private boolean isUsernameValid(String username) {
        return username.matches("[a-zA-Z0-9-]+");
    }

    private boolean isEmailValid(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
}
