package org.example.models.Map;

import org.example.models.enums.types.StoneType;
import org.example.models.enums.types.TreeType;
import org.example.models.farming.Crop;
import java.io.Serializable;

/**
 * Represents a single tile on the farm map
 */
public class MapTile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private TileType type;
    private boolean isWatered;
    private boolean isFertilized;
    private Crop crop;
    private TreeType treeType;
    private StoneType stoneType;
    private MapComponents forageableItem;
    
    public MapTile(TileType type) {
        this.type = type;
        this.isWatered = false;
        this.isFertilized = false;
        this.crop = null;
        this.treeType = null;
        this.stoneType = null;
        this.forageableItem = null;
    }
    
    public TileType getType() {
        return type;
    }
    
    public void setType(TileType type) {
        this.type = type;
    }
    
    public boolean isWatered() {
        return isWatered;
    }
    
    public void setWatered(boolean watered) {
        this.isWatered = watered;
        if (watered && type == TileType.TILLED_SOIL) {
            type = TileType.WATERED_SOIL;
        } else if (!watered && type == TileType.WATERED_SOIL) {
            type = TileType.TILLED_SOIL;
        }
    }
    
    public boolean isFertilized() {
        return isFertilized;
    }
    
    public void setFertilized(boolean fertilized) {
        this.isFertilized = fertilized;
    }
    
    public Crop getCrop() {
        return crop;
    }
    
    public void setCrop(Crop crop) {
        this.crop = crop;
        if (crop != null && (type == TileType.TILLED_SOIL || type == TileType.WATERED_SOIL)) {
            type = TileType.PLANTED_SOIL;
        } else if (crop == null && type == TileType.PLANTED_SOIL) {
            type = isWatered ? TileType.WATERED_SOIL : TileType.TILLED_SOIL;
        }
    }
    
    public TreeType getTreeType() {
        return treeType;
    }
    
    public void setTreeType(TreeType treeType) {
        this.treeType = treeType;
    }
    
    public StoneType getStoneType() {
        return stoneType;
    }
    
    public void setStoneType(StoneType stoneType) {
        this.stoneType = stoneType;
    }
    
    public MapComponents getForageableItem() {
        return forageableItem;
    }
    
    public void setForageableItem(MapComponents forageableItem) {
        this.forageableItem = forageableItem;
    }
    
    // Helper methods for tile operations
    
    public boolean canTill() {
        return type == TileType.GROUND;
    }
    
    public void till() {
        if (canTill()) {
            type = TileType.TILLED_SOIL;
        }
    }
    
    public boolean canPlant() {
        return type == TileType.TILLED_SOIL || type == TileType.WATERED_SOIL;
    }
    
    public boolean canWater() {
        return type == TileType.TILLED_SOIL || type == TileType.PLANTED_SOIL;
    }
    
    public boolean canHarvest() {
        return type == TileType.PLANTED_SOIL && crop != null && crop.isReadyToHarvest();
    }
}

