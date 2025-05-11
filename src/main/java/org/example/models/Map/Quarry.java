package org.example.models.Map;

import org.example.models.Position;
import org.example.models.enums.types.StoneType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents a quarry on the farm where mining can be done
 */
public class Quarry extends MapComponents {
    private Map<StoneType, Integer> stoneDistribution;
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
        stoneDistribution.put(StoneType.REGULAR, 60);
        stoneDistribution.put(StoneType.COPPER, 20);
        stoneDistribution.put(StoneType.IRON, 10);
        stoneDistribution.put(StoneType.GOLD, 7);
        stoneDistribution.put(StoneType.IRIDIUM, 3);
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
    public StoneType getRandomStoneType() {
        int roll = random.nextInt(100) + 1;
        int cumulativeProbability = 0;
        
        // Apply mining quality bonus to rare stones
        int qualityBonus = miningQuality / 2;
        
        // Adjust probabilities based on mining quality
        Map<StoneType, Integer> adjustedDistribution = new HashMap<>();
        adjustedDistribution.put(StoneType.REGULAR, Math.max(40, stoneDistribution.get(StoneType.REGULAR) - qualityBonus * 2));
        adjustedDistribution.put(StoneType.COPPER, stoneDistribution.get(StoneType.COPPER));
        adjustedDistribution.put(StoneType.IRON, stoneDistribution.get(StoneType.IRON) + qualityBonus);
        adjustedDistribution.put(StoneType.GOLD, stoneDistribution.get(StoneType.GOLD) + qualityBonus);
        adjustedDistribution.put(StoneType.IRIDIUM, stoneDistribution.get(StoneType.IRIDIUM) + qualityBonus);
        
        for (Map.Entry<StoneType, Integer> entry : adjustedDistribution.entrySet()) {
            cumulativeProbability += entry.getValue();
            if (roll <= cumulativeProbability) {
                return entry.getKey();
            }
        }
        
        return StoneType.REGULAR; // Default fallback
    }
    
    @Override
    public void update() {
        // Quarries don't change on daily updates
        // But we could implement regeneration logic here if needed
    }
}
