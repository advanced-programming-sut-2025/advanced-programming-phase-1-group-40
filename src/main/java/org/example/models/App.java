package org.example.models;

import org.example.models.enums.*;
import org.example.models.enums.enviroment.Weather;
import org.example.models.persistence.DataManager;

import java.util.ArrayList;

public class App {

    public static ArrayList<Player> users = new ArrayList<>();
    public static ArrayList<User> items = new ArrayList<>();
    public static ArrayList<Game> games = new ArrayList<>();
    public static Player currentPlayer = null;
    public static Menu currentMenu = Menu.LOGIN_MENU;
    public static Weather currentWeather = Weather.SUNNY;

    // Initialize the DataManager when the app starts
    static {
        DataManager.getInstance().initializeFromApp();
    }

    public static Menu getCurrentMenu() {
        return DataManager.getInstance().getCurrentMenu();
    }

    public static void setCurrentMenu(Menu currentMenu) {
        DataManager.getInstance().setCurrentMenu(currentMenu);
        App.currentMenu = currentMenu; // For backward compatibility
    }

    public static Player getCurrentPlayer() {
        return DataManager.getInstance().getCurrentPlayer();
    }

    public static ArrayList<Player> getUsers() {
        return DataManager.getInstance().getAllUsers();
    }

    public static ArrayList<Game> getGames() {
        return DataManager.getInstance().getAllGames();
    }

    public static void setCurrentPlayer(Player user) {
        DataManager.getInstance().setCurrentPlayer(user);
        App.currentPlayer = user; // For backward compatibility
    }
    public static void addUser(Player player) {
        App.users.add(player);
    }
    public static void addGame(Game game) {
        App.games.add(game);
    }

    public static Player getPlayerByUsername(String username) {
        for (Player player : App.users) {
            if (player.getUsername().equals(username)) {
                return player;
            }
        }
        return null;
    }
    public static Object getLoggedIn() {
        return DataManager.getInstance().getCurrentPlayer();
    }

    // Method to save all data
    public static boolean saveAllData() {
        return DataManager.getInstance().saveAllData();
    }

    // Method to load all data
    public static boolean loadAllData() {
        return DataManager.getInstance().loadAllData();
    }
}
