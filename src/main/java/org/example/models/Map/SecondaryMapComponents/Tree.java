package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Position;
import org.example.models.Map.MapComponents;
import org.example.models.enums.types.FruitType;
import org.example.models.enums.types.TreeType;

public class Tree extends MapComponents {

    private final TreeType treeType;
    private boolean isFullyGrown;
    private boolean isBurnt;
    private int growthStage; // 0-3 where 3 is fully grown
    private int daysUntilNextStage;

    public Tree(Position position, TreeType treeType) {
        super(position, 1, 1);
        this.treeType = treeType;
        this.isFullyGrown = false;
        this.isBurnt = false;
        this.growthStage = 0;
        this.daysUntilNextStage = 5; // Default 5 days between growth stages
        
        // Set name based on tree type
        switch (treeType) {
            case OAK:
                this.name = "Oak Tree";
                break;
            case MAPLE:
                this.name = "Maple Tree";
                break;
            case PINE:
                this.name = "Pine Tree";
                break;
            case FRUIT:
                this.name = "Fruit Tree";
                break;
            default:
                this.name = "Unknown Tree";
        }
    }

    public void setFullyGrown(boolean fullyGrown) {
        isFullyGrown = fullyGrown;
    }

    public void setBurnt(boolean burnt) {
        isBurnt = burnt;
    }

    public boolean isFullyGrown() {
        return isFullyGrown;
    }

    public boolean isBurnt() {
        return isBurnt;
    }

    public TreeType getTreeType() {
        return treeType;
    }
    
    public int getGrowthStage() {
        return growthStage;
    }
    
    @Override
    public void update() {
        // Only update if not fully grown and not burnt
        if (!isFullyGrown && !isBurnt) {
            daysUntilNextStage--;
            
            if (daysUntilNextStage <= 0) {
                growthStage++;
                
                if (growthStage >= 3) {
                    isFullyGrown = true;
                } else {
                    // Reset days until next stage
                    daysUntilNextStage = 5;
                }
            }
        }
    }
}
