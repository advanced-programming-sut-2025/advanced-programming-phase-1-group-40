package org.example.models.Map;

import org.example.models.Animal.Animal;
import org.example.models.Animal.AnimalLivingSpace;
import org.example.models.FarmBuilding;
import org.example.models.Map.SecondaryMapComponents.*;
import org.example.models.Player;
import org.example.models.enums.enviroment.Season;
import org.example.models.enums.types.*;
import org.example.models.Position;
import org.example.models.Map.SecondaryMapComponents.Tree;

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
    private Season currentSeason;
    private List<MapComponents> components;
    private MapTile[][] mapTiles;
    
    // New lists for specific component types
    private ArrayList<Cabin> cabin;
    private ArrayList<Greenhouse> greenhouse;
    private ArrayList<Quarry> quarry;
    private ArrayList<Lake> lakes;
    private ArrayList<Crop> plantedCrops;
    private ArrayList<Tree> trees;
    private List<ForagingMineral> stones;
    private List<ForagingCrop> foragingCrops;
    private List<ForagingSeed> foragingSeeds;
    private List<ForagingTree> foragingTrees;
    private Player owner;

    /// ANIMALS IN FARM
    private ArrayList<Animal> animals;
    /// building haye farm
    private ArrayList<AnimalLivingSpace> animalLivingSpaces = new ArrayList<>();



    public Farm(String name, int width, int height) {

        this.name = name;
        this.width = width;
        this.height = height;
        this.mapTiles = new MapTile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapTiles[y][x] = new MapTile(new Position(x, y), TileType.GROUND);
            }
        }
        this.cabin = new ArrayList<>();
        this.greenhouse = new ArrayList<>();
        this.quarry = new ArrayList<>();
        this.lakes = new ArrayList<>();
        this.plantedCrops = new ArrayList<>();
        this.components = new ArrayList<>();
        this.trees = new ArrayList<>();
        this.stones = new ArrayList<>();
        this.foragingCrops = new ArrayList<>();
        this.foragingSeeds = new ArrayList<>();
        this.foragingTrees = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.currentSeason = Season.SPRING; // Default season
        
    }

    public ArrayList<Cabin> getCabin() {
        return cabin;
    }

    public ArrayList<Greenhouse> getGreenhouse() {
        return greenhouse;
    }

    public ArrayList<Quarry> getQuarry() {
        return quarry;
    }

    public ArrayList<Lake> getLakes() {
        return lakes;
    }

    public ArrayList<Crop> getPlantedCrops() {
        return plantedCrops;
    }

    public ArrayList<AnimalLivingSpace> getAnimalLivingSpaces() {
        return animalLivingSpaces;
    }

    public void addFarmBuildings(AnimalLivingSpace animalLivingSpace) {
        this.animalLivingSpaces.add(animalLivingSpace);
    }

    public void removeFarmBuildings(FarmBuilding farmBuilding) {
        this.animalLivingSpaces.remove(farmBuilding);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    public String getName() {
        return name;
    }
    
    public List<Tree> getTrees() {
        return trees;
    }
    
    public List<ForagingMineral> getForagingMinerals() {
        return stones;
    }
    
    public List<ForagingCrop> getforagingCrops() {
        return foragingCrops;
    }

    public List<ForagingSeed> getForagingSeeds() {
        return foragingSeeds;
    }

    public List<ForagingTree> getForagingTrees() {
        return foragingTrees;
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
        return mapTiles;
    }
    
    public void setTiles(MapTile[][] tiles) {
        this.mapTiles = tiles;
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
        
        // Add to specific list based on component type
        if (component instanceof Tree) {
            trees.add((Tree) component);
        } else if (component instanceof ForagingMineral) {
            stones.add((ForagingMineral) component);
        } else if (component instanceof ForagingCrop) {
            foragingCrops.add((ForagingCrop) component);
        }
        else if (component instanceof ForagingSeed) {
            foragingSeeds.add((ForagingSeed) component);
        }
        else if (component instanceof ForagingTree) {
            foragingTrees.add((ForagingTree) component);
        }

        else{
        // Update tiles covered by this component
        for (int y = component.getY(); y < component.getY() + component.getHeight(); y++) {
            for (int x = component.getX(); x < component.getX() + component.getWidth(); x++) {
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    if (component instanceof Cabin) {
                        setTileAt(x, y, new MapTile(new Position(x, y), TileType.CABIN));
                    } else if (component instanceof Greenhouse) {
                        setTileAt(x, y, new MapTile(new Position(x, y), TileType.GREENHOUSE));
                    } else if (component instanceof Quarry) {
                        setTileAt(x, y, new MapTile(new Position(x, y), TileType.QUARRY));
                    } else if (component instanceof Lake) {
                        setTileAt(x, y, new MapTile(new Position(x, y), TileType.WATER));
                    }
                    //  else if (component instanceof Tree) {
                    //     MapTile tile = new MapTile(new Position(x, y), TileType.TREE);
                    //     tile.setTreeType(((Tree) component).getTreeType());
                    //     setTileAt(x, y, tile);
                    // } else if (component instanceof ForagingMineral) {
                    //     setTileAt(x, y, new MapTile(new Position(x, y), TileType.STONE));
                    //     // TODO: set foraging mineral type if needed
                    // } else if (component instanceof ForagingCrop) {
                    //     MapTile tile = new MapTile(new Position(x, y), TileType.FORAGEABLE);
                    //     tile.setForageableItem(component);
                    //     setTileAt(x, y, tile);
                    // }
                }
            }
        }
    }
    }
    
    public MapTile getTileAt(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return mapTiles[x][y];
        }
        return null;
    }
    
    public void setTileAt(int x, int y, MapTile newTile) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            mapTiles[x][y] = newTile;
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
            // TODO
//            Crop harvestedCrop = tile.getCrop();
//            if (harvestedCrop.isOneTime()) {
//                tile.setCrop(null);
//                tile.setType(TileType.TILLED_SOIL);
//            } else {
//                harvestedCrop.harvest(); // Reset growth for regrowable crops
//            }
//            return harvestedCrop;
        }
        return null;
    }
    
    // Method to update all crops (called at the end of each day)
    public void updateCrops() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = getTileAt(x, y);
                if (tile != null && tile.getType() == TileType.PLANTED_SOIL && tile.getCrop() != null) {
                    if (tile.isWatered()) {
                        // TODO: tile.getCrop().grow();
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
                MapTile tile = getTileAt(x, y);
                if (tile != null && tile.getType() == TileType.PLANTED_SOIL && tile.getCrop() != null) {
                    // TODO: if (!tile.getCrop().canGrowInSeason(newSeason)) {
                    //         tile.setCrop(null);
                    //         tile.setType(TileType.TILLED_SOIL);
                    //     }
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
                MapTile tile = getTileAt(x, y);
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
    public void addCabin(Position pos) {
        Cabin cabin1 = new Cabin(pos);
        cabin.add(cabin1);
        addComponent(cabin1);
    }
    
    // Method to add a greenhouse to the farm
    public void addGreenhouse(Position pos) {
        Greenhouse gr = new Greenhouse(pos);
        greenhouse.add(gr);
        addComponent(gr);
    }
    
    // Method to add a quarry to the farm
    public void addQuarry(Position pos, int width, int height) {
        Quarry q = new Quarry(pos, width, height);
        quarry.add(q);
        addComponent(q);
    }
    
    // Method to add a lake to the farm
    public void addLake(Position pos, int width, int height) {
        Lake lake = new Lake(pos, width, height);
        lakes.add(lake);
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

    public void addTree(Position position, TreeType treeType) {
        MapTile tile = getTileAt(position.getX(), position.getY());
        if (tile != null ) {
            Tree tree = new Tree(treeType,position);
            trees.add(tree);
            addComponent(tree);
       
        }
      
    }

    public void addForagingSeed(Position position, ForagingSeedType foragingSeedType) {
        MapTile tile = getTileAt(position.getX(), position.getY());
        if (tile != null ) {
            ForagingSeed fs = new ForagingSeed(position, foragingSeedType);
            foragingSeeds.add(fs);
            addComponent(fs);
       
        }
      
    }
    public void addForagingCrop(Position position, ForagingCropType foragingCropType) {
        MapTile tile = getTileAt(position.getX(), position.getY());
        ForagingCrop fc = new ForagingCrop(position, foragingCropType);
        foragingCrops.add(fc);
        addComponent(fc);
    }
    //     public void addForagingSeed(ForagingSeed foragingSeed) {
    //     this.foragingSeeds.add(foragingSeed);
    // }

    public void addForagingTree(Position position,TreeType foragingTreeType) {
        MapTile tile = getTileAt(position.getX(), position.getY());
        if (tile != null ) {
            ForagingTree ft = new ForagingTree(position, foragingTreeType);
            foragingTrees.add(ft);
            addComponent(ft);
        }
        
    }
    

  
    public void addForagingMineral(Position position, ForagingMineralType foragingMineralType) {
        MapTile tile = getTileAt(position.getX(), position.getY());
        if (tile != null ) {
            ForagingMineral stone = new ForagingMineral(position);
            stones.add(stone);
            addComponent(stone);
            
        }
        
    }

   
    public void addForageable(Position position, ForagingType foragingType) {
        MapTile tile = getTileAt(position.getX(), position.getY());
        if (tile != null ) {
            ForagingCrop foragingCrop = new ForagingCrop(position);
            foragingCrops.add(foragingCrop);
            addComponent(foragingCrop);
            
        }
       
    }

 
    public Tree chopTree(Position position) {
        int x = position.getX();
        int y = position.getY();
        MapTile tile = getTileAt(x, y);
        
        if (tile != null && tile.getType() == TileType.TREE) {
            // Find the tree at this position
            for (int i = 0; i < trees.size(); i++) {
                Tree tree = trees.get(i);
                if (tree.contains(x, y)) {
                    // Remove from lists
                    trees.remove(i);
                    components.removeIf(component -> component == tree);
                    
                    // Update tile
                    tile.setTreeType(null);
                    tile.setType(TileType.GROUND);
                    
                    return tree;
                }
            }
        }
        return null;
    }

    /**
     * Mines a stone at the specified location
     * @param position Position of the stone
     * @return The stone that was mined, or null if no stone was present
     */
    public ForagingMineral mineForagingMineral(Position position) {
        int x = position.getX();
        int y = position.getY();
        MapTile tile = getTileAt(x, y);
        
        if (tile != null && tile.getType() == TileType.STONE) {
            // Find the stone at this position
            for (int i = 0; i < stones.size(); i++) {
                ForagingMineral stone = stones.get(i);
                if (stone.contains(x, y)) {
                    // Decrease resources
                    // TODO
                    // stone.decreaseResources();
                    
                    // If fully mined, remove it
//                    if (stone.isMined()) {
//                        stones.remove(i);
//                        components.removeIf(component -> component == stone);
//
//                        // Update tile
//                        tile.setForagingMineralType(null);
//                        tile.setType(TileType.GROUND);
//                    }
//
                    //return stone;
                }
            }
        }
        return null;
    }

    /**
     * Collects a forageable item at the specified location
     * @param position Position of the forageable item
     * @return The forageable item that was collected, or null if no item was present
     */
    public ForagingCrop collectForageable(Position position) {
        int x = position.getX();
        int y = position.getY();
        MapTile tile = getTileAt(x, y);
        
        if (tile != null && tile.getType() == TileType.FORAGEABLE) {
            // Find the forageable at this position
            for (int i = 0; i < foragingCrops.size(); i++) {
                ForagingCrop foragingCrop = foragingCrops.get(i);
                if (foragingCrop.contains(x, y)) {
                    // Remove from lists
                    foragingCrops.remove(i);
                    components.removeIf(component -> component == foragingCrop);
                    
                    // Update tile
                    tile.setForageableItem(null);
                    tile.setType(TileType.GROUND);
                    
                    return foragingCrop;
                }
            }
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

    /**
     * Sets the owner of this farm
     * @param owner The player who owns this farm
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * Gets the owner of this farm
     * @return The player who owns this farm
     */
    public Player getOwner() {
        return owner;
    }


    // public MapComponents getCabin() {
    //     // TODO
    //     return null;
    // }
}
