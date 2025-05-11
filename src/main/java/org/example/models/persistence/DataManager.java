package org.example.models.persistence;

import org.example.models.*;
import org.example.models.Map.Farm;
import org.example.models.enums.enviroment.Weather;
import org.example.models.enums.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class responsible for managing all application data and persistence
 * This class will store all data in memory and provide methods to save/load from persistent storage
 */
public class DataManager {
    private static DataManager instance;
    
    // Data collections
    private ArrayList<Player> users;
    private ArrayList<Game> games;
    private Map<String, Farm> userFarms;
    private Player currentPlayer;
    private Menu currentMenu;
    private Weather currentWeather;
    private Map<String, Boolean> stayLoggedInUsers;
    
    // Private constructor for singleton pattern
    private DataManager() {
        this.users = new ArrayList<>();
        this.games = new ArrayList<>();
        this.userFarms = new HashMap<>();
        this.stayLoggedInUsers = new HashMap<>();
        this.currentMenu = Menu.LOGIN_MENU;
        this.currentWeather = Weather.SUNNY;
    }
    
    /**
     * Get the singleton instance of DataManager
     * @return The DataManager instance
     */
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }
    
    /**
     * Initialize the DataManager with data from App class
     * This is a temporary method until we implement proper persistence
     */
    public void initializeFromApp() {
        this.users = App.users;
        this.games = App.games;
        this.currentPlayer = App.currentPlayer;
        this.currentMenu = App.currentMenu;
        this.currentWeather = App.currentWeather;
    }
    
    /**
     * Update the App class with data from DataManager
     * This is a temporary method until we implement proper persistence
     */
    public void updateApp() {
        App.users = this.users;
        App.games = this.games;
        App.currentPlayer = this.currentPlayer;
        App.currentMenu = this.currentMenu;
        App.currentWeather = this.currentWeather;
    }
    
    // User management methods
    
    /**
     * Add a new user to the system
     * @param user The user to add
     */
    public void addUser(Player user) {
        users.add(user);
    }
    
    /**
     * Get a user by username
     * @param username The username to search for
     * @return The user with the given username, or null if not found
     */
    public Player getUserByUsername(String username) {
        for (Player user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    /**
     * Get all users in the system
     * @return List of all users
     */
    public ArrayList<Player> getAllUsers() {
        return users;
    }
    
    /**
     * Set the current logged-in player
     * @param player The player to set as current
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }
    
    /**
     * Get the current logged-in player
     * @return The current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Set a user to stay logged in
     * @param username The username to stay logged in
     * @param stayLoggedIn Whether to stay logged in
     */
    public void setStayLoggedIn(String username, boolean stayLoggedIn) {
        stayLoggedInUsers.put(username, stayLoggedIn);
    }
    
    /**
     * Check if a user should stay logged in
     * @param username The username to check
     * @return True if the user should stay logged in, false otherwise
     */
    public boolean shouldStayLoggedIn(String username) {
        return stayLoggedInUsers.getOrDefault(username, false);
    }
    
    // Game management methods
    
    /**
     * Add a new game to the system
     * @param game The game to add
     */
    public void addGame(Game game) {
        games.add(game);
    }
    
    /**
     * Get a game by ID
     * @param gameId The game ID to search for
     * @return The game with the given ID, or null if not found
     */
    public Game getGameById(int gameId) {
        for (Game game : games) {
            if (game.getGameId() == gameId) {
                return game;
            }
        }
        return null;
    }
    
    /**
     * Get all games in the system
     * @return List of all games
     */
    public ArrayList<Game> getAllGames() {
        return games;
    }
    
    /**
     * Get the game a player is currently in
     * @param username The username to search for
     * @return The game the player is in, or null if not in a game
     */
    public Game getGameForPlayer(String username) {
        for (Game game : games) {
            for (Player player : game.getPlayers()) {
                if (player.getUsername().equals(username)) {
                    return game;
                }
            }
        }
        return null;
    }
    
    /**
     * Remove a game from the system
     * @param game The game to remove
     */
    public void removeGame(Game game) {
        games.remove(game);
    }
    
    // Farm management methods
    
    /**
     * Add a farm for a user
     * @param username The username to add the farm for
     * @param farm The farm to add
     */
    public void addFarmForUser(String username, Farm farm) {
        userFarms.put(username, farm);
    }
    
    /**
     * Get a farm for a user
     * @param username The username to get the farm for
     * @return The farm for the user, or null if not found
     */
    public Farm getFarmForUser(String username) {
        return userFarms.get(username);
    }
    
    // Application state methods
    
    /**
     * Set the current menu
     * @param menu The menu to set as current
     */
    public void setCurrentMenu(Menu menu) {
        this.currentMenu = menu;
    }
    
    /**
     * Get the current menu
     * @return The current menu
     */
    public Menu getCurrentMenu() {
        return currentMenu;
    }
    
    /**
     * Set the current weather
     * @param weather The weather to set as current
     */
    public void setCurrentWeather(Weather weather) {
        this.currentWeather = weather;
    }
    
    /**
     * Get the current weather
     * @return The current weather
     */
    public Weather getCurrentWeather() {
        return currentWeather;
    }
    
    // Persistence methods - to be implemented with JSON in the future
    
    /**
     * Save all data to persistent storage
     * This will be implemented to save to JSON files in the future
     * @return True if successful, false otherwise
     */
    public boolean saveAllData() {
        // This will be implemented to save to JSON files
        // For now, just return true
        return true;
    }
    
    /**
     * Load all data from persistent storage
     * This will be implemented to load from JSON files in the future
     * @return True if successful, false otherwise
     */
    public boolean loadAllData() {
        // This will be implemented to load from JSON files
        // For now, just return true
        return true;
    }
    
    /**
     * Save user data to persistent storage
     * This will be implemented to save to JSON files in the future
     * @return True if successful, false otherwise
     */
    public boolean saveUserData() {
        // This will be implemented to save to JSON files
        // For now, just return true
        return true;
    }
    
    /**
     * Load user data from persistent storage
     * This will be implemented to load from JSON files in the future
     * @return True if successful, false otherwise
     */
    public boolean loadUserData() {
        // This will be implemented to load from JSON files
        // For now, just return true
        return true;
    }
    
    /**
     * Save game data to persistent storage
     * This will be implemented to save to JSON files in the future
     * @return True if successful, false otherwise
     */
    public boolean saveGameData() {
        // This will be implemented to save to JSON files
        // For now, just return true
        return true;
    }
    
    /**
     * Load game data from persistent storage
     * This will be implemented to load from JSON files in the future
     * @return True if successful, false otherwise
     */
    public boolean loadGameData() {
        // This will be implemented to load from JSON files
        // For now, just return true
        return true;
    }
}