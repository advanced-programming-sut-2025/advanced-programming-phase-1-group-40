package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class MainMenuController {

    public void goToMenu(Menu targetMenu){

        App.dataManager.setCurrentMenu(targetMenu);
        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());

    }

    public void logout(){

        App.dataManager.setCurrentUser(null);
        App.dataManager.setCurrentMenu(Menu.LOGIN_MENU);
        System.out.println("Logged out successfully.You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());

    }

    public void showCurrentMenu(){

        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());

    }


}
