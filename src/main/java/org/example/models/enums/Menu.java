package org.example.models.enums;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import org.example.view.*;

import java.util.Scanner;

public enum Menu {
    LOGIN_MENU(new LoginMenu(), "Login Menu"),
    MAIN_MENU(new MainMenu(), "Main Menu"),
    GAME_MENU(new GameMenu(), "Game Menu"),
    PROFILE_MENU(new ProfileMenu(), "Profile Menu"),
    SIGNUP_MENU(new SignUpMenu(), "Sign up Menu"),
    EXIT(new ExitMenu(), "Exit");

    private final AppMenu menu;
    private final String displayName;

    Menu(AppMenu menu, String displayName) {
        this.menu = menu;
        this.displayName = displayName;
    }

    public AppMenu getMenu() {
        return menu;
    }

    public String getDisplayName() {
        return displayName;
    }
}
