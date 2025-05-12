package org.example.models.Map;

import org.example.models.Position;

/**
 * Represents the player's cabin on the farm
 */
public class Cabin extends MapComponents {
    private int upgradeLevel;
    private boolean hasBasement;
    
    public Cabin(int x, int y) {
        super(new Position(x, y), 3, 3); // Default cabin size is 3x3
        this.name = "Cabin";
        this.upgradeLevel = 1;
        this.hasBasement = false;
    }
    
    public Cabin(Position position) {
        super(position, 3, 3);
        this.name = "Cabin";
        this.upgradeLevel = 1;
        this.hasBasement = false;
    }
    
    public int getUpgradeLevel() {
        return upgradeLevel;
    }
    
    public void upgrade() {
        if (upgradeLevel < 3) {
            upgradeLevel++;
            
            // Increase cabin size with upgrades
            if (upgradeLevel == 2) {
                this.width = 4;
                this.height = 4;
            } else if (upgradeLevel == 3) {
                this.width = 5;
                this.height = 5;
            }
        }
    }
    
    public boolean hasBasement() {
        return hasBasement;
    }
    
    public void buildBasement() {
        this.hasBasement = true;
    }
    
    @Override
    public void update() {
        // Nothing to update daily for cabin
    }
}
