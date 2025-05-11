package org.example.models.Map;

import org.example.models.Position;
import org.example.models.enums.types.ForagingMineralTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents a quarry on the farm where mining can be done
 */
public class Quarry extends MapComponents {
    private Map<ForagingMineralTypes, Integer> stoneDistribution;
    private int miningQuality; // 1-10 scale
    private Random random;
    
    public Quarry(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.name = "Quarry";
        this.miningQuality = 5; // Default quality
        this.random = new Random();
        initializeStoneDistribution();
    }
    
    public Quarry(Position position, int width, int height) {
        super(position, width, height);
        this.name = "Quarry";
        this.miningQuality = 5; // Default quality
        this.random = new Random();
        initializeStoneDistribution();
    }
    
    private void initializeStoneDistribution() {
        stoneDistribution = new HashMap<>();
        stoneDistribution.put(ForagingMineralTypes.REGULAR, 60);
        stoneDistribution.put(ForagingMineralTypes.COPPER, 20);
        stoneDistribution.put(ForagingMineralTypes.IRON, 10);
        stoneDistribution.put(ForagingMineralTypes.GOLD, 7);
        stoneDistribution.put(ForagingMineralTypes.IRIDIUM, 3);
    }
    
    public int getMiningQuality() {
        return miningQuality;
    }
    
    public void setMiningQuality(int miningQuality) {
        this.miningQuality = Math.max(1, Math.min(10, miningQuality));
    }
    
    /**
     * Gets a random stone type based on the quarry's distribution
     * @return A randomly selected stone type
     */
    public ForagingMineralTypes getRandomStoneType() {
        int roll = random.nextInt(100) + 1;
        int cumulativeProbability = 0;
        
        // Apply mining quality bonus to rare stones
        int qualityBonus = miningQuality / 2;
        
        // Adjust probabilities based on mining quality
        Map<ForagingMineralTypes, Integer> adjustedDistribution = new HashMap<>();
        adjustedDistribution.put(ForagingMineralTypes.REGULAR, Math.max(40, stoneDistribution.get(ForagingMineralTypes.REGULAR) - qualityBonus * 2));
        adjustedDistribution.put(ForagingMineralTypes.COPPER, stoneDistribution.get(ForagingMineralTypes.COPPER));
        adjustedDistribution.put(ForagingMineralTypes.IRON, stoneDistribution.get(ForagingMineralTypes.IRON) + qualityBonus);
        adjustedDistribution.put(ForagingMineralTypes.GOLD, stoneDistribution.get(ForagingMineralTypes.GOLD) + qualityBonus);
        adjustedDistribution.put(ForagingMineralTypes.IRIDIUM, stoneDistribution.get(ForagingMineralTypes.IRIDIUM) + qualityBonus);
        
        for (Map.Entry<ForagingMineralTypes, Integer> entry : adjustedDistribution.entrySet()) {
            cumulativeProbability += entry.getValue();
            if (roll <= cumulativeProbability) {
                return entry.getKey();
            }
        }
        
        return ForagingMineralTypes.REGULAR; // Default fallback
    }
    
    @Override
    public void update() {
        // Quarries don't change on daily updates
        // But we could implement regeneration logic here if needed
    }
}
