package org.example.models.Map;

import org.example.models.*;
import org.example.models.enums.enviroment.Season;


import java.util.*;

/**
 * Manages farm creation and association with users
 */
public class FarmManager {


    private static FarmManager instance;
    private ArrayList<Farm> userFarms; // Maps username to farm


    private FarmManager() {
        userFarms = new ArrayList<>();
    }


    public static FarmManager getInstance() {
        if (instance == null) {
            instance = new FarmManager();
        }
        return instance;
    }


    public Farm createFarmForUser(Player player, int mapType) {
        Farm farm;
        
        switch (mapType) {

            case 1:

                farm = MapBuilder.buildStandardFarm();
                break;

            case 2:

                farm = MapBuilder.buildFishingFarm();
                break;

            case 3:

                farm = MapBuilder.buildMiningFarm();
                break;

            case 4:

                farm = MapBuilder.buildForestFarm();
                break;

            case 5:

                farm = MapBuilder.buildRiverFarm();
                break;

            case 6:

                farm = MapBuilder.buildHillTopFarm();
                break;

            case 7:

                farm = MapBuilder.buildWildernessFarm();
                break;

            default:

                farm = MapBuilder.buildStandardFarm();
                break;
        }
        
        // Set the farm owner
        farm.setOwner(player);
        
        // Set the farm name
        farm.setName(player.getUsername() + "'s Farm");
        
        userFarms.add(farm);
        //userFarms.put(player.getUsername(), farm);
        
        // Also update the DataManager to ensure persistence
        //App.dataManager.addFarmForUser(player.getUsername(), farm);
        
        return farm;
    }
    
    /**
     * Gets the farm associated with a user
     * @param username The username to get the farm for
     * @return The user's farm, or null if they don't have one
     */
    public Farm getUserFarm(String username) {
        return userFarms.get(App.dataManager.getAllUsers().indexOf(username));
    }
    
    /**
     * Removes a user's farm
     * @param username The username to remove the farm for
     */
    public void removeFarm(String username) {
        userFarms.remove(username);
    }
    
    /**
     * Saves all farms to persistent storage
     * @return true if successful, false otherwise
     */
    public boolean saveFarms() {
        // Implementation for saving farms to files or database
        // This would use serialization or database operations
        return true;
    }
    
    /**
     * Loads all farms from persistent storage
     * @return true if successful, false otherwise
     */
    public boolean loadFarms() {
        // Implementation for loading farms from files or database
        return true;
    }
}

