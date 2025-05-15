package org.example.models.Map;

import org.example.models.Position;
import org.example.models.enums.enviroment.Season;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents a lake on the farm where fishing can be done
 */
public class Lake extends MapComponents {
    private Map<String, Integer> fishPopulation;
    private Season currentSeason;
    private int fishingQuality; // 1-10 scale
    
    public Lake(int x, int y, int width, int height) {
        super(new Position(x, y), width, height);
        this.name = "Lake";
        this.fishingQuality = 5; // Default quality
        this.fishPopulation = new HashMap<>();
        this.currentSeason = Season.SPRING;
        initializeFishPopulation();
    }

    public Lake(Position pos, int width, int height) {
        super(pos, width, height);
        this.name = "Lake";
        this.fishingQuality = 5; // Default quality
        this.fishPopulation = new HashMap<>();
        this.currentSeason = Season.SPRING;
        initializeFishPopulation();
    }
    
    public int getFishingQuality() {
        return fishingQuality;
    }
    
    public void setFishingQuality(int fishingQuality) {
        this.fishingQuality = Math.max(1, Math.min(10, fishingQuality));
    }
    
    public Season getCurrentSeason() {
        return currentSeason;
    }
    
    /**
     * Update fish population based on season change
     */
    public void updateFishPopulation() {
        // Clear old population
        fishPopulation.clear();
        
        // Add season-specific fish
        switch (currentSeason) {
            case SPRING:
                fishPopulation.put("Herring", 30);
                fishPopulation.put("Anchovy", 25);
                fishPopulation.put("Sardine", 20);
                fishPopulation.put("Sunfish", 15);
                fishPopulation.put("Catfish", 10);
                break;
            case SUMMER:
                fishPopulation.put("Tuna", 30);
                fishPopulation.put("Red Snapper", 25);
                fishPopulation.put("Tilapia", 20);
                fishPopulation.put("Rainbow Trout", 15);
                fishPopulation.put("Sturgeon", 10);
                break;
            case FALL:
                fishPopulation.put("Salmon", 30);
                fishPopulation.put("Walleye", 25);
                fishPopulation.put("Eel", 20);
                fishPopulation.put("Red Mullet", 15);
                fishPopulation.put("Tiger Trout", 10);
                break;
            case WINTER:
                fishPopulation.put("Perch", 30);
                fishPopulation.put("Pike", 25);
                fishPopulation.put("Lingcod", 20);
                fishPopulation.put("Tuna", 15);
                fishPopulation.put("Ice Pip", 10);
                break;
        }
        
        // Add rare fish with low probability
        fishPopulation.put("Legendary Fish", 1);
    }
    
    /**
     * Initialize fish population based on default season (Spring)
     */
    private void initializeFishPopulation() {
        fishPopulation.put("Herring", 30);
        fishPopulation.put("Anchovy", 25);
        fishPopulation.put("Sardine", 20);
        fishPopulation.put("Sunfish", 15);
        fishPopulation.put("Catfish", 10);
        fishPopulation.put("Legendary Fish", 1);
    }
    
    /**
     * Try to catch a fish from the lake
     * @param fishingSkill The player's fishing skill level (1-10)
     * @param luckFactor Additional luck factor (0-1)
     * @return The name of the caught fish, or null if no fish was caught
     */
    public String catchFish(int fishingSkill, double luckFactor) {
        Random random = new Random();
        
        // Base chance to catch something
        double baseChance = 0.5 + (fishingSkill * 0.05) + (fishingQuality * 0.02) + (luckFactor * 0.1);
        
        if (random.nextDouble() > baseChance) {
            return null; // Failed to catch anything
        }
        
        // Determine which fish to catch based on population
        List<String> fishTypes = new ArrayList<>(fishPopulation.keySet());
        List<Integer> weights = new ArrayList<>();
        
        int totalWeight = 0;
        for (String fish : fishTypes) {
            int weight = fishPopulation.get(fish);
            weights.add(weight);
            totalWeight += weight;
        }
        
        int roll = random.nextInt(totalWeight);
        int currentWeight = 0;
        
        for (int i = 0; i < fishTypes.size(); i++) {
            currentWeight += weights.get(i);
            if (roll < currentWeight) {
                return fishTypes.get(i);
            }
        }
        
        return "Seaweed"; // Fallback
    }
    
    @Override
    public void update() {
        // Small chance to improve fishing quality
        Random random = new Random();
        if (random.nextInt(100) < 10) {
            fishingQuality = Math.min(10, fishingQuality + 1);
        }
        
        // Small chance to decrease fishing quality
        if (random.nextInt(100) < 5) {
            fishingQuality = Math.max(1, fishingQuality - 1);
        }
    }
    
    /**
     * Update the current season and refresh fish population
     */
    public void changeSeason(Season newSeason) {
        this.currentSeason = newSeason;
        updateFishPopulation();
    }
}
