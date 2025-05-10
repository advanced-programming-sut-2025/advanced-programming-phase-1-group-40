package org.example.models.Map;

import java.util.ArrayList;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Random;

/**
 * Represents a quarry on the farm where stones and minerals can be mined
 */
public class Quarry extends MapComponents {
    private int stoneCount;
    private int copperCount;
    private int ironCount;
    private int goldCount;
    private int iridiumCount;
    private boolean isUnlocked;
    
    public Quarry(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.name = "Quarry";
        this.isUnlocked = false;
        resetResources();
    }
    
    public boolean isUnlocked() {
        return isUnlocked;
    }
    
    public void unlock() {
        this.isUnlocked = true;
    }
    
    public int getStoneCount() {
        return stoneCount;
    }
    
    public int getCopperCount() {
        return copperCount;
    }
    
    public int getIronCount() {
        return ironCount;
    }
    
    public int getGoldCount() {
        return goldCount;
    }
    
    public int getIridiumCount() {
        return iridiumCount;
    }
    
    /**
     * Mine a resource from the quarry
     * @return The type of resource mined, or null if nothing was found
     */
    public String mineResource() {
        if (!isUnlocked) {
            return null;
        }
        
        Random random = new Random();
        int roll = random.nextInt(100);
        
        if (roll < 60 && stoneCount > 0) {
            stoneCount--;
            return "Stone";
        } else if (roll < 80 && copperCount > 0) {
            copperCount--;
            return "Copper";
        } else if (roll < 90 && ironCount > 0) {
            ironCount--;
            return "Iron";
        } else if (roll < 97 && goldCount > 0) {
            goldCount--;
            return "Gold";
        } else if (iridiumCount > 0) {
            iridiumCount--;
            return "Iridium";
        }
        
        return null;
    }
    
    private void resetResources() {
        Random random = new Random();
        this.stoneCount = 50 + random.nextInt(50);
        this.copperCount = 20 + random.nextInt(20);
        this.ironCount = 10 + random.nextInt(15);
        this.goldCount = 5 + random.nextInt(10);
        this.iridiumCount = 1 + random.nextInt(5);
    }
    
    @Override
    public void update() {
        // Small chance to replenish some resources each day
        Random random = new Random();
        if (random.nextInt(100) < 20) {
            stoneCount += random.nextInt(5);
            if (random.nextInt(100) < 30) {
                copperCount += random.nextInt(3);
            }
            if (random.nextInt(100) < 20) {
                ironCount += random.nextInt(2);
            }
            if (random.nextInt(100) < 10) {
                goldCount += random.nextInt(2);
            }
            if (random.nextInt(100) < 5) {
                iridiumCount += 1;
            }
        }
    }
}
