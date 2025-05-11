package org.example.controller.User;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.enums.Menu;

public class MainMenuController {

    public Result enterMenu(String menuName) {
        Menu newMenu = Menu.getMenuFromDisplayName(menuName);
        if (newMenu == null) {
            return new Result(false, "Invalid menu name!");
        }
        if (!canSwitchMenu(newMenu)) {
            return new Result(false, "You cannot switch to " + menuName + " from here!");
        }
        App.setCurrentMenu(newMenu);
        return new Result(true, "Menu switched to " + menuName);
    }

    public Result exitMenu() {
        if (App.getCurrentMenu() == Menu.LOGIN_MENU) {
            App.setCurrentMenu(Menu.EXIT);
            return new Result(true, "Exiting the application...");
        }
        App.setCurrentMenu(Menu.MAIN_MENU);
        return new Result(true, "You are now in the Main Menu");
    }

    public Result showCurrentMenu() {
        return new Result(true, "You are now in " + App.getCurrentMenu().getDisplayName());
    }
    
    private boolean canSwitchMenu(Menu targetMenu) {
        Menu currentMenu = App.getCurrentMenu();
        
        // From Main Menu, you can go to Profile Menu, Game Menu, or Avatar Menu
        if (currentMenu == Menu.MAIN_MENU) {
            return targetMenu == Menu.PROFILE_MENU || 
                   targetMenu == Menu.GAME_MENU || 
                   targetMenu == Menu.AVATAR_MENU;
        }
        
        // From Login Menu, you can go to Signup Menu
        if (currentMenu == Menu.LOGIN_MENU) {
            return targetMenu == Menu.SIGNUP_MENU;
        }
        
        // From any other menu, you can only go back to Main Menu
        return targetMenu == Menu.MAIN_MENU;
    }
}
