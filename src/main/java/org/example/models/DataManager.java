package org.example.models;

import org.example.models.enums.Menu;
import org.example.models.enums.enviroment.Weather;

import java.util.ArrayList;

/**
 * Singleton class responsible for managing all application data and persistence
 * This class will store all data in memory and provide methods to save/load from persistent storage
 */
public class DataManager {


    private ArrayList<User> users;
    private ArrayList<Game> games;
    private User currentUser;
    private Menu currentMenu;
    private Game currentGame;
    private Player currentPlayer;

    // Private constructor for singleton pattern
    public DataManager() {

        this.users = new ArrayList<>();
        this.games = new ArrayList<>();
        this.currentMenu = Menu.LOGIN_MENU;

    }


    public boolean loadAllData() {
        // This will be implemented to load from JSON files
        // For now, just return true
        return true;
    }

    /**
     * Initialize the DataManager with data from App class
     * This is a temporary method until we implement proper persistence
     */
    public void initializeFromApp() {
        // Remove this method as App no longer stores data
        // Or keep it empty for backward compatibility
    }

    /**
     * Update the App class with data from DataManager
     * This is a temporary method until we implement proper persistence
     */
    public void updateApp() {
        // Remove this method as App no longer stores data
        // Or keep it empty for backward compatibility
    }

    // User management methods

    /**
     * Add a new user to the system
     * @param user The user to add
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Get a user by username
     * @param username The username to search for
     * @return The user with the given username, or null if not found
     */
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public ArrayList<User> getAllUsers() {
        return users;
    }


    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    /**
     * Get the current logged-in player
     * @return The current player
     */
    public User getCurrentUser() {
        return currentUser;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }



    // Game management methods

    /**
     * Adds a game to the data manager
     * @param game The game to add
     */
    public void addGame(Game game) {
        games.add(game);
    }

    /**
     * Removes a game from the data manager
     * @param game The game to remove
     */
    public void removeGame(Game game) {
        games.remove(game);
    }

    /**
     * Gets all active games
     * @return List of active games
     */
    public ArrayList<Game> getGames() {
        return games;
    }

    /**
     * Gets a game that a player is part of
     * @param username The username to check
     * @return The game the player is in, or null if not found
     */
    public Game getGameForPlayer(String username) {
        for (Game game : games) {
            if (game.hasPlayer(username)) {
                return game;
            }
        }
        return null;
    }

    // Farm management methods





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




    // Game management methods

    /**
     * Gets the current active game
     * @return The current game, or null if no game is active
     */
    public Game getCurrentGame() {
        return currentGame;
    }


    /**
     * Sets the current active game
     * @param game The game to set as current
     */
    public void setCurrentGame(Game game) {
        this.currentGame = game;
    }

    /**
     * Creates a new game with the specified users and sets it as the current game
     * @param users The users to add to the game
     * @return The newly created game
     */
    public Game createNewGame(ArrayList<Player> users) {
        Game newGame = new Game(users);
        games.add(newGame);
        this.currentGame = newGame;
        return newGame;
    }

    /**
     * Loads a game for a player and sets it as the current game
     * @param username The username of the player
     * @return The loaded game, or null if no game found
     */
    public Game loadGameForPlayer(String username) {
        Game game = getGameForPlayer(username);
        if (game != null) {
            currentGame = game;
        }
        return game;
    }

    /**
     * Exits the current game
     */
    public void exitCurrentGame() {
        currentGame = null;
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


