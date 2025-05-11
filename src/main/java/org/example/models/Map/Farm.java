package org.example.models.Map;

import org.example.models.enums.enviroment.Season;
import org.example.models.enums.types.StoneType;
import org.example.models.enums.types.TreeType;
import org.example.models.farming.Crop;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Represents a farm with a grid of tiles
 */
public class Farm implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int width;
    private int height;
    private MapTile[][] tiles;
    private Season currentSeason;
    private List<MapComponents> components;
    
    public Farm(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.tiles = new MapTile[height][width];
        this.components = new ArrayList<>();
        this.currentSeason = Season.SPRING; // Default season
        
        // Initialize all tiles as GROUND
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = new MapTile(TileType.GROUND);
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public MapTile[][] getTiles() {
        return tiles;
    }
    
    public void setTiles(MapTile[][] tiles) {
        this.tiles = tiles;
    }
    
    public Season getCurrentSeason() {
        return currentSeason;
    }
    
    public void setCurrentSeason(Season currentSeason) {
        this.currentSeason = currentSeason;
    }
    
    public List<MapComponents> getComponents() {
        return components;
    }
    
    public void addComponent(MapComponents component) {
        components.add(component);
        
        // Update tiles covered by this component
        for (int y = component.getY(); y < component.getY() + component.getHeight(); y++) {
            for (int x = component.getX(); x < component.getX() + component.getWidth(); x++) {
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    if (component instanceof Cabin) {
                        tiles[y][x] = new MapTile(TileType.CABIN);
                    } else if (component instanceof Greenhouse) {
                        tiles[y][x] = new MapTile(TileType.GREENHOUSE);
                    } else if (component instanceof Quarry) {
                        tiles[y][x] = new MapTile(TileType.QUARRY);
                    } else if (component instanceof Lake) {
                        tiles[y][x] = new MapTile(TileType.WATER);
                    }
                }
            }
        }
    }
    
    public MapTile getTileAt(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return tiles[y][x];
        }
        return null;
    }
    
    public void setTileAt(int x, int y, MapTile tile) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            tiles[y][x] = tile;
        }
    }
    
    // Methods for farm operations
    
    public boolean tillSoil(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.canTill()) {
            tile.till();
            return true;
        }
        return false;
    }
    
    public boolean plantCrop(int x, int y, Crop crop) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.canPlant()) {
            tile.setCrop(crop);
            return true;
        }
        return false;
    }
    
    public boolean waterTile(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.canWater()) {
            tile.setWatered(true);
            return true;
        }
        return false;
    }
    
    public boolean fertilizeTile(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && (tile.getType() == TileType.TILLED_SOIL || tile.getType() == TileType.PLANTED_SOIL) && !tile.isFertilized()) {
            tile.setFertilized(true);
            return true;
        }
        return false;
    }
    
    public Crop harvestCrop(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.canHarvest()) {
            Crop harvestedCrop = tile.getCrop();
            if (harvestedCrop.isOneTime()) {
                tile.setCrop(null);
                tile.setType(TileType.TILLED_SOIL);
            } else {
                harvestedCrop.harvest(); // Reset growth for regrowable crops
            }
            return harvestedCrop;
        }
        return null;
    }
    
    // Method to update all crops (called at the end of each day)
    public void updateCrops() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = tiles[y][x];
                if (tile.getType() == TileType.PLANTED_SOIL && tile.getCrop() != null) {
                    if (tile.isWatered()) {
                        tile.getCrop().grow();
                    }
                    // Reset watered status for the next day
                    tile.setWatered(false);
                }
            }
        }
    }
    
    // Method to change seasons and update the farm accordingly
    public void changeSeason(Season newSeason) {
        this.currentSeason = newSeason;
        
        // Update crops based on season change
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = tiles[y][x];
                if (tile.getType() == TileType.PLANTED_SOIL && tile.getCrop() != null) {
                    // Check if crop is out of season and should die
                    if (!tile.getCrop().canGrowInSeason(newSeason)) {
                        tile.setCrop(null);
                        tile.setType(TileType.TILLED_SOIL);
                    }
                }
            }
        }
        
        // Update components based on season
        for (MapComponents component : components) {
            if (component instanceof Lake) {
                ((Lake) component).updateFishPopulation();
            }
        }
    }
    
    // Method to get a string representation of the farm for display
    public String getMapDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm: ").append(name).append(" (").append(currentSeason).append(")\n");
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = tiles[y][x];
                switch (tile.getType()) {
                    case GROUND:
                        sb.append(".");
                        break;
                    case TILLED_SOIL:
                        sb.append("_");
                        break;
                    case WATERED_SOIL:
                        sb.append("~");
                        break;
                    case PLANTED_SOIL:
                        if (tile.isWatered()) {
                            sb.append("w");
                        } else {
                            sb.append("p");
                        }
                        break;
                    case WATER:
                        sb.append("W");
                        break;
                    case CABIN:
                        sb.append("C");
                        break;
                    case GREENHOUSE:
                        sb.append("G");
                        break;
                    case QUARRY:
                        sb.append("Q");
                        break;
                    case TREE:
                        sb.append("T");
                        break;
                    case STONE:
                        sb.append("S");
                        break;
                    case FORAGEABLE:
                        sb.append("F");
                        break;
                    case PATH:
                        sb.append("#");
                        break;
                    default:
                        sb.append("?");
                }
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    // Helper method to find a component at a specific location
    public MapComponents getComponentAt(int x, int y) {
        for (MapComponents component : components) {
            if (component.contains(x, y)) {
                return component;
            }
        }
        return null;
    }
    
    // Method to add a cabin to the farm
    public void addCabin(int x, int y) {
        Cabin cabin = new Cabin(x, y);
        addComponent(cabin);
    }
    
    // Method to add a greenhouse to the farm
    public void addGreenhouse(int x, int y) {
        Greenhouse greenhouse = new Greenhouse(x, y);
        addComponent(greenhouse);
    }
    
    // Method to add a quarry to the farm
    public void addQuarry(int x, int y, int width, int height) {
        Quarry quarry = new Quarry(x, y, width, height);
        addComponent(quarry);
    }
    
    // Method to add a lake to the farm
    public void addLake(int x, int y, int width, int height) {
        Lake lake = new Lake(x, y, width, height);
        addComponent(lake);
    }

    /**
     * Updates all components on the farm (called at the end of each day)
     */
    public void updateComponents() {
        for (MapComponents component : components) {
            component.update();
        }
    }

    /**
     * Adds a tree to the farm at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @param treeType Type of tree to add
     * @return true if successful, false otherwise
     */
    public boolean addTree(int x, int y, TreeType treeType) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.GROUND) {
            tile.setTreeType(treeType);
            return true;
        }
        return false;
    }

    /**
     * Adds a stone to the farm at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @param stoneType Type of stone to add
     * @return true if successful, false otherwise
     */
    public boolean addStone(int x, int y, StoneType stoneType) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.GROUND) {
            tile.setStoneType(stoneType);
            return true;
        }
        return false;
    }

    /**
     * Adds a forageable item to the farm at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @param item The forageable item to add
     * @return true if successful, false otherwise
     */
    public boolean addForageable(int x, int y, Object item) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.GROUND) {
            tile.setForageableItem(item);
            return true;
        }
        return false;
    }

    /**
     * Chops down a tree at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @return The type of tree that was chopped, or null if no tree was present
     */
    public TreeType chopTree(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.TREE) {
            TreeType treeType = tile.getTreeType();
            tile.setTreeType(null);
            tile.setType(TileType.GROUND);
            return treeType;
        }
        return null;
    }

    /**
     * Mines a stone at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @return The type of stone that was mined, or null if no stone was present
     */
    public StoneType mineStone(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.STONE) {
            StoneType stoneType = tile.getStoneType();
            tile.setStoneType(null);
            tile.setType(TileType.GROUND);
            return stoneType;
        }
        return null;
    }

    /**
     * Collects a forageable item at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @return The forageable item that was collected, or null if no item was present
     */
    public Object collectForageable(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.FORAGEABLE) {
            Object item = tile.getForageableItem();
            tile.setForageableItem(null);
            tile.setType(TileType.GROUND);
            return item;
        }
        return null;
    }

    /**
     * Creates a path at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @return true if successful, false otherwise
     */
    public boolean createPath(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.GROUND) {
            tile.setType(TileType.PATH);
            return true;
        }
        return false;
    }

    /**
     * Removes a path at the specified location
     * @param x X coordinate
     * @param y Y coordinate
     * @return true if successful, false otherwise
     */
    public boolean removePath(int x, int y) {
        MapTile tile = getTileAt(x, y);
        if (tile != null && tile.getType() == TileType.PATH) {
            tile.setType(TileType.GROUND);
            return true;
        }
        return false;
    }

    /**
     * Updates the farm for a new day
     * This includes updating crops, components, and other time-based elements
     */
    public void newDay() {
        // Update all crops
        updateCrops();
        
        // Update all components
        updateComponents();
        
        // Reset daily flags if needed
    }

    /**
     * Calculates the total farm value based on improvements and components
     * @return The total value of the farm
     */
    public int calculateFarmValue() {
        int value = 1000; // Base value
        
        // Add value for each component
        for (MapComponents component : components) {
            if (component instanceof Cabin) {
                value += 5000 * ((Cabin) component).getUpgradeLevel();
            } else if (component instanceof Greenhouse) {
                value += 10000;
            } else if (component instanceof Quarry) {
                value += 15000;
            } else if (component instanceof Lake) {
                value += 5000 * ((Lake) component).getFishingQuality() / 5;
            }
        }
        return value;
    }

    /**
     * Saves this farm to a file
     * @param filePath The path to save the farm to
     * @return true if successful, false otherwise
     */
    public boolean saveToFile(String filePath) {
        try {
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream(filePath);
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Loads a farm from a file
     * @param filePath The path to load the farm from
     * @return The loaded farm, or null if loading failed
     */
    public static Farm loadFromFile(String filePath) {
        try {
            java.io.FileInputStream fileIn = new java.io.FileInputStream(filePath);
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            Farm farm = (Farm) in.readObject();
            in.close();
            fileIn.close();
            return farm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

