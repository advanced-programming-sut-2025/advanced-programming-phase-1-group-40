package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import static org.example.controller.User.LoginController.getUserByUsername;

public class ProfileController {
    public Result changeUsername(String newUsername) {
        if(getUserByUsername(newusername)!= null)
            return new Result(false, "Username already exists");
        App.getLoggedIn().setusername(newusername);
        return new Result(true, "Username successfully changed");
    }

    public Result changeNickname(String newNickname) {
        if(getUserByUsername(newNickname)!= null)
            return new Result(false, "Nickname already exists");
        App.getLoggedIn().setusername(newusername);
        return new Result(true, "Nickname successfully changed");
    }

    private boolean getUserByUsername(String newNickname) {
        return false;
    }

    public Result changeEmail(String newEmail) {
        if(getUserByUsername(newEmail)!= null){
            return new Result(false, "Email already exists");
        }
        App.getLoggedIn().setusername(newusername);
        return new Result(true, "Email successfully changed");
    }

    public Result changePassword(String oldPassword, String newPassword) {
        return null;
        //
    }

}
