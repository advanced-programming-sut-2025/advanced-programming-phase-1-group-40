package org.example.controller.User;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class MainMenuController {

    public Result enterMenu(String menuName) {
        Menu newMenu = Menu.getMenuFromDisplayName(menuName);
        if (newMenu == null) {
            return new Result(false, "Invalid menu name!");
        }
        if (!canSwitchMenu(newMenu)) {
            return new Result(false, "You can not switch to " + menuName + " from here!");
        }
        App.setCurrentMenu(newMenu);
        return new Result(true, "Menu switched to " + menuName);
    }

    public Result exitMenu() {
        if (App.getCurrentMenu() == Menu.LOGIN_MENU) {
            App.setCurrentMenu(Menu.EXIT);
        }
        App.setCurrentMenu(Menu.MAIN_MENU);
        return new Result(true, "You are now in the Main Menu");
    }
    public Result logOut(){
        return null;
    }

    public Result showCurrentMenu() {
        return new Result(true, "You are now in " + App.getCurrentMenu().toString());
    }

    private boolean canSwitchMenu(Menu newMenu) {
        if(newMenu == App.currentMenu){
            return false;
        }
        else if(App.currentMenu ==Menu.LOGIN_MENU && newMenu==Menu.GAME_MENU){
            return false;
        }
        else if(App.currentMenu == Menu.GAME_MENU && newMenu ==Menu.LOGIN_MENU){
            return false;
        }
        return true;
    }


}
