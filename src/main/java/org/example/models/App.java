package org.example.models;

import org.example.models.enums.*;

import java.util.ArrayList;

public class App {

    public static DataManager dataManager = new DataManager();

    // Keep static methods but make them pure delegates
    public static ArrayList<Player> getUsers() {
        return App.dataManager.getAllUsers();
    }
    
    public static void addUser(Player player) {
        App.dataManager.addUser(player);
    }
    
    public static Menu getCurrentMenu() {
        return App.dataManager.getCurrentMenu();
    }
    
    public static void setCurrentMenu(Menu currentMenu) {
        App.dataManager.setCurrentMenu(currentMenu);
    }

    public static Player getCurrentPlayer() {
        return App.dataManager.getCurrentPlayer();
    }

    

    public static ArrayList<Game> getGames() {
        return App.dataManager.getGames();
    }

    public static void setCurrentPlayer(Player user) {
        App.dataManager.setCurrentPlayer(user);
        
    }
    
    public static void addGame(Game game) {
        App.dataManager.addGame(game);
    }

    public static Player getPlayerByUsername(String username) {
    return App.dataManager.getUserByUsername(username);
    }
    public static Object getLoggedIn() {
        return App.dataManager.getCurrentPlayer();
    }

    // Method to save all data
    public static boolean saveAllData() {
        return App.dataManager.saveAllData();
    }

    // Method to load all data
    public static boolean loadAllData() {
        return App.dataManager.loadAllData();
    }

}
