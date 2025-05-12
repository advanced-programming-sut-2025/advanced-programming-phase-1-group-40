package org.example.models.Map;

import org.example.models.Position;
import org.example.models.enums.enviroment.Season;

/**
 * Represents a greenhouse on the farm where crops can grow in any season
 */
public class Greenhouse extends MapComponents {
    private boolean isUnlocked;
    private Season internalSeason; // Can be different from farm's season
    
    public Greenhouse(int x, int y) {
        super(new Position(x, y), 5, 6); // Greenhouse is 5x6 tiles
        this.name = "Greenhouse";
        this.isUnlocked = false;
        this.internalSeason = Season.SPRING; // Default internal season
    }
    
    public boolean isUnlocked() {
        return isUnlocked;
    }
    
    public void unlock() {
        this.isUnlocked = true;
    }
    
    public Season getInternalSeason() {
        return internalSeason;
    }
    
    public void setInternalSeason(Season season) {
        this.internalSeason = season;
    }
    
    @Override
    public void update() {
        // Nothing to update daily for greenhouse
    }
}
