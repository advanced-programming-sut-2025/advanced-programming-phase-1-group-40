package org.example.models.Map;

/**
 * Represents a cabin on the farm where the player lives
 */
public class Cabin extends MapComponents {
    private int upgradeLevel;
    private boolean hasBasement;
    
    public Cabin(int x, int y) {
        super(x, y, 4, 4); // Cabin is 4x4 tiles
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
