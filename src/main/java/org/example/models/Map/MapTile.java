package org.example.models.Map;

import org.example.models.Map.SecondaryMapComponents.*;
import org.example.models.Map.SecondaryMapComponents.ForagingCrop;
import org.example.models.Position;
import org.example.models.enums.types.ForagingMineralType;
import org.example.models.enums.types.TreeType;
import java.io.Serializable;

/**
 * Represents a single tile on the farm map
 */
public class MapTile implements Serializable {

    private static final long serialVersionUID = 1L;

    private Position position;
    private TileType type;
    private boolean isWatered;
    private boolean isFertilized;
    private Crop crop;
    private TreeType treeType;
    private ForagingMineralType foragingMineralType;
    private MapComponents mapComponents;
    // private ForagingCrop foragingCrop;
    // private ForagingTree foragingTree;
    // private ForagingSeed foragingSeed;
    
    private boolean isEmpty;
    
    public MapTile(Position position, TileType type) {
        this.position = position;
        this.type = type;
        this.isWatered = false;
        this.isFertilized = false;
        this.crop = null;
        this.treeType = null;
        this.foragingMineralType = null;
        this.mapComponents = null;
        this.isEmpty = true;

    }

    public MapComponents getMapComponents() {
        return mapComponents;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ForagingMineralType getForagingMineralType() {
        return foragingMineralType;
    }

    public void setForagingMineralType(ForagingMineralType foragingMineralType) {
        this.foragingMineralType = foragingMineralType;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public TileType getType() {
        return type;
    }

    public Position getPosition(){
        return position;
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
    
    public ForagingMineralType getStoneType() {
        return foragingMineralType;
    }
    
    public void setStoneType(ForagingMineralType foragingMineralType) {
        this.foragingMineralType = foragingMineralType;
    }
    
    public MapComponents getForageableItem() {
        return mapComponents;
    }
    
    public void setForageableItem(MapComponents forageableItem) {
        this.mapComponents = forageableItem;
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

