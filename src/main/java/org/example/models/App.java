package org.example.models;

import org.example.models.enums.*;
import org.example.models.enums.enviroment.Weather;

import java.util.ArrayList;

public class App {

    // Keep static methods but make them pure delegates
    public static ArrayList<Player> getUsers() {
        return DataManager.getInstance().getAllUsers();
    }
    
    public static void addUser(Player player) {
        DataManager.getInstance().addUser(player);
    }
    
    public static Menu getCurrentMenu() {
        return DataManager.getInstance().getCurrentMenu();
    }
    
    public static void setCurrentMenu(Menu currentMenu) {
        DataManager.getInstance().setCurrentMenu(currentMenu);
    }

    public static Player getCurrentPlayer() {
        return DataManager.getInstance().getCurrentPlayer();
    }

    

    public static ArrayList<Game> getGames() {
        return DataManager.getInstance().getActiveGames();
    }

    public static void setCurrentPlayer(Player user) {
        DataManager.getInstance().setCurrentPlayer(user);
        
    }
    
    public static void addGame(Game game) {
        DataManager.getInstance().addGame(game);
    }

    public static Player getPlayerByUsername(String username) {
    return DataManager.getInstance().getUserByUsername(username);
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
