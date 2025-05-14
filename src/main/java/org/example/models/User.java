package org.example.models;

import org.example.models.enums.SecurityQuestion;

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


    public User(String username, String password, String nickname, String email, String gender,SecurityQuestion securityQuestion, String securityAnswer) {

        super(new HashMap<>());
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
        this.stayLoggedInNextTime = false;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = this.securityAnswer;

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
}
