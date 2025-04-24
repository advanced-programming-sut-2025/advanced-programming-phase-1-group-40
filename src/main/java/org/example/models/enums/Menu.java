package org.example.models.enums;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


import java.util.Scanner;

public enum Menu {
    LOGIN_MENU(new LoginMenu(), "Login Menu"),
    MAIN_MENU(new MainMenu(), "Main Menu"),
    GAME_MENU(new GameMenu(), "Game Menu"),
    PROFILE_MENU(new ProfileMenu(), "Profile Menu"),
    EXIT(new ExitMenu(), "Exit");

    private final AppMenu menu;
    private final String displayName;

    Menu(AppMenu menu, String displayName) {
        this.menu = menu;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }

    public static Menu getMenuFromDisplayName(String displayName) {
        return switch (displayName) {
            case "Login Menu" -> LOGIN_MENU;
            case "Main Menu" -> MAIN_MENU;
            case "Profile Menu" -> PROFILE_MENU;
            case "Game Menu" -> GAME_MENU;
            case "Exit" -> EXIT;
            default -> null;
        };
    }

}
