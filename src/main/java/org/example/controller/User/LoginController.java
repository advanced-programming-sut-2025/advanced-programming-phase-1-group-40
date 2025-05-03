package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.Random;

public class LoginController {
    public static User getUserByUsername(String username) {
        for (User user : App.getusers()) {
            if (user.getUsername().equal(username))
                return user;
        }
        return null;
    }
    public static User getUserByEmail(String email){
        for(User user: App.getusers()){
            if(user.getEmail().equal(Email)){
                return user;
            }

        }
        return null;
    }

    public Result registerUser(String username,
                               String nickname,
                               String password,
                               String email,
                               Gender gender) {
        if (!LoginCommands.VALID_USERNAME.matches(username)) {
            return new Result(false, "Username is not valid.");
        }
        if(getUserByUsername(username) != null) {
            return new Result(false, "Username is already in use.");
        }
       /* if(!LoginCommands.VALID_NICKNAME.matches(nickname)){
            return new Result(false, "Nickname is not valid.");
        }*/
        if (!LoginCommands.VALID_PASSWORD.matches(password)) {
            return new Result(false, "Password is not valid.");
        }
        if (!LoginCommands.VALID_EMAIL.matches(email)) {
            return new Result(false, "Email format is not valid.");
        }
        if(getUserByEmail(email) != null) {
            return new Result(false, "Email is already in use.");
        }


        return new Result(true, "Successfully registered.");
    }

    public Result randomPasswordGenerator() {
        int length = 10;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?><,';:/|][}{+=)(*&^%$#!\n";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
            return new Result(true , sb.toString());
        }
    }

    public Result showSecurityQuestions() {
        for (SecurityQuestion question : SecurityQuestion.values()) {
            System.out.println(question);
        }
        return null;
    }

    public Result pickAndAnswerSecurityQuestion(User user, int questionNumber, String answer) {
        if (user == null) {
            return new Result(false, "User not found");
        }

        if (user.getQAndA() == null) {
            user.setQAndA(new HashMap<>());
        }

        SecurityQuestion[] questions = SecurityQuestion.values();

        if (questionNumber < 0 || questionNumber >= questions.length) {
            return new Result(false, "Invalid question number");
        }

        SecurityQuestion selectedQuestion = questions[questionNumber];
        user.getQAndA().put(selectedQuestion, answer);

        return new Result(true, "Security question saved");
    }


    public Result sha256() {
        return null;
    }


    public boolean isPasswordFormatValid() {
        return false;
    }

    public boolean isEmailFormatValid() {
        return false;
    }

    public boolean isNicknameFormatValid() {
        return false;
    }

    public Result login(String username, String password) {
        return null;
    }

    public Result askSecurityQuestion(User user) {
        if (user == null || user.getQAndA() == null || user.getQAndA().isEmpty()) {
            return new Result(false, "No security question set for this user.");
        }

        SecurityQuestion question = user.getQAndA().keySet().iterator().next();
        return new Result(true, "question");
    }

    public Result validateSecurityQuestion(User user, String answerToSecurityQuestion) {
        SecurityQuestion question = user.getQAndA().keySet().iterator().next();
        String correctAnswer = user.getQAndA().get(question);

        if (correctAnswer.equalsIgnoreCase(answerToSecurityQuestion)) {
            return new Result(true, "Security question has been validated successfully.");
        } else {
            return new Result(false, "Incorrect answer.");
        }
    }


    public Result forgotPassword(String username, String email) {
        User user = getUserByUsername(username);
        if (user == null) {
            return new Result(false, "User not found");
        }
        if(user.getQAndA() != null && !user.getQAndA().isEmpty()) {
            SecurityQuestion question = user.getQAndA().keySet().iterator().next();
            return new Result(true, question.name());
        }
        //result rand = randomPasswordGenerator();
        // String newpass = rand.getMessage();

    }

}
