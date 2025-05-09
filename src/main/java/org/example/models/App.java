package org.example.models;

import org.example.models.enums.*;

import java.util.ArrayList;

public class App {


    public static ArrayList<Player> users = new ArrayList<>();
    public static ArrayList<Game> games = new ArrayList<>();
    public static Player currentPlayer = null;
    public static Menu currentMenu = Menu.LOGIN_MENU;

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static ArrayList<Player> getUsers() {
        return users;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static void setCurrentPlayer(Player user) {
        App.currentPlayer = user;
    }


    public static Object getLoggedIn() {
    }
}
