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

    public Result showCurrentMenu() {
        return new Result(true, "You are now in " + App.getCurrentMenu().toString());
    }

    private boolean canSwitchMenu(Menu newMenu) {
        // TODO: check if it is allowed to switch to that menu from the current menu
        return false;
    }


}
