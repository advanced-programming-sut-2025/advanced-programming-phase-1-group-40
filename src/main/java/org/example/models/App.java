package org.example.models;

import org.example.models.enums.*;

import java.util.ArrayList;

public class App {


    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();
    private static User currentUser = null;
    private static Menu currentMenu = Menu.LOGIN_MENU;

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        App.currentUser = user;
    }


}
