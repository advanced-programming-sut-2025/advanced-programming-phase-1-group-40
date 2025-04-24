package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class LoginController {
    public static User getUserByUsername(String username) {
            User user = new User();
            return user;
    }

    public Result registerUser(String username,
                               String password,
                               String email,
                               Gender gender) {
        return null;
    }

    public Result randomPasswordGenerator() {
        return null;
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
            return new Result(true, "Security question validated successfully.");
        } else {
            return new Result(false, "Incorrect answer.");
        }
    }


    public Result forgotPassword(String username, String email) {
        return null;
    }

}
