package org.example.models;

import org.example.models.enums.SecurityQuestion;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;

public class User extends Human {

    private String username;
    private String password;
    private String nickname;
    private String email; 
    private String gender;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;
    private boolean stayLoggedInNextTime;
    private int highestEarnedMoney; // TODO
    private int gamesPlayed;
    private String hashedPassword;


    public User(String username, String password, String nickname, String email, String gender,SecurityQuestion securityQuestion, String securityAnswer) {

        super(new HashMap<>());
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
        this.stayLoggedInNextTime = false;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.highestEarnedMoney = 0;
        this.gamesPlayed = 0;
        this.hashedPassword = hashPassword(password);

    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch(NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setHighestEarnedMoney(int highestEarnedMoney) {
        this.highestEarnedMoney = highestEarnedMoney;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public SecurityQuestion getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public boolean isStayLoggedInNextTime() {
        return stayLoggedInNextTime;
    }

    public void setStayLoggedInNextTime(boolean stayLoggedInNextTime) {
        this.stayLoggedInNextTime = stayLoggedInNextTime;
    }

    public int getHighestEarnedMoney() {
        return highestEarnedMoney;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
}
