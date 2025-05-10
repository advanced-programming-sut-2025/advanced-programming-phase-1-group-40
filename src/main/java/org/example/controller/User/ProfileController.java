package org.example.controller.User;

import org.example.models.*;

public class ProfileController {
    public Result changeUsername(String newUsername) {
        if(getUserByUsername(newUsername)!= null)
            return new Result(false, "Username already exists.");
        App.getLoggedIn().setUsername(newUsername);
        return new Result(true, "Username successfully changed.");
    }

    public Result changeNickname(String newNickname) {
        if(getUserByUsername(newNickname)!= null)
            return new Result(false, "Nickname already exists.");
        App.getLoggedIn().setUsername(newUsername);
        return new Result(true, "Nickname successfully changed.");
    }

    private boolean getUserByUsername(String newNickname) {
        return false;
    }

    public Result changeEmail(String newEmail) {
        if(getUserByUsername(newEmail)!= null){
            return new Result(false, "Email already exists.");
        }
        App.getLoggedIn().setusername(newUsername);
        return new Result(true, "Email successfully changed.");
    }

    public Result changePassword(String oldPassword, String newPassword) {
        return null;
        //
    }

}
