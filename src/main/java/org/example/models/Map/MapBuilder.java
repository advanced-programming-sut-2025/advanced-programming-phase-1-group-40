package org.example.models.Map;

import org.example.models.Position;
import org.example.models.Map.SecondaryMapComponents.Tree;
import org.example.models.enums.enviroment.Season;
import org.example.models.enums.types.ForagingType;
import org.example.models.enums.types.ForagingMineralTypes;
import org.example.models.enums.types.TreeType;

import java.util.Random;

/**
 * Builder class for creating farm maps
 */
public class MapBuilder {
    private String mapName;
    private int width;
    private int height;
    private MapTile[][] tiles;
    private Random random;
    
    public MapBuilder() {
        this.random = new Random();
    }
    
    public MapBuilder setName(String name) {
        this.mapName = name;
        return this;
    }
    
    public MapBuilder setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }
    
    public MapBuilder initialize() {
        this.tiles = new MapTile[height][width];
        
        // Initialize all tiles as GROUND
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = new MapTile(TileType.GROUND);
            }
        }
        
        return this;
    }
    
    public MapBuilder addCabin(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 3, 3)) {
            for (int dy = 0; dy < 3; dy++) {
                for (int dx = 0; dx < 3; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.CABIN);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addGreenhouse(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 5, 6)) {
            for (int dy = 0; dy < 6; dy++) {
                for (int dx = 0; dx < 5; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.GREENHOUSE);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addLake(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.WATER);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addQuarry(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.QUARRY);
                }
            }
        }
        return this;
    }
    
    public MapBuilder randomlyPlaceTrees(int count, Season season) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            
            if (isValidPosition(x, y) && tiles[y][x].getType() == TileType.GROUND) {
                tiles[y][x] = new MapTile(TileType.TREE);
                
                // Set tree type based on season
                TreeType treeType;
                int treeRoll = random.nextInt(100);
                
                if (treeRoll < 40) {
                    treeType = TreeType.OAK;
                } else if (treeRoll < 70) {
                    treeType = TreeType.MAPLE;
                } else if (treeRoll < 90) {
                    treeType = TreeType.PINE;
                } else {
                    treeType = TreeType.FRUIT;
                }
                
                tiles[y][x].setTreeType(treeType);
            }
        }
        return this;
    }
    
    public MapBuilder randomlyPlaceStones(int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            
            if (isValidPosition(x, y) && tiles[y][x].getType() == TileType.GROUND) {
                tiles[y][x] = new MapTile(TileType.STONE);
                
                // Set stone type
                ForagingMineralTypes foragingMineralTypes;
                int stoneRoll = random.nextInt(100);
                
                if (stoneRoll < 60) {
                    foragingMineralTypes = ForagingMineralTypes.REGULAR;
                } else if (stoneRoll < 80) {
                    foragingMineralTypes = ForagingMineralTypes.COPPER;
                } else if (stoneRoll < 90) {
                    foragingMineralTypes = ForagingMineralTypes.IRON;
                } else if (stoneRoll < 97) {
                    foragingMineralTypes = ForagingMineralTypes.GOLD;
                } else {
                    foragingMineralTypes = ForagingMineralTypes.IRIDIUM;
                }
                
                tiles[y][x].setStoneType(foragingMineralTypes);
            }
        }
        return this;
    }
    
    public MapBuilder randomlyPlaceForagingItems(int count, Season season) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            
            if (isValidPosition(x, y) && tiles[y][x].getType() == TileType.GROUND) {
                tiles[y][x] = new MapTile(TileType.FORAGEABLE);
                
                // Set foraging type based on season
                ForagingType foragingType;
                int foragingRoll = random.nextInt(100);
                
                if (foragingRoll < 30) {
                    foragingType = ForagingType.WILD_BERRY;
                } else if (foragingRoll < 60) {
                    foragingType = ForagingType.MUSHROOM;
                } else if (foragingRoll < 80) {
                    foragingType = ForagingType.HERB;
                } else if (foragingRoll < 95) {
                    foragingType = ForagingType.FLOWER;
                } else {
                    foragingType = ForagingType.TRUFFLE;
                }
                
                // Create a foraging crop and set it on the tile
                ForagingCrop foragingCrop = new ForagingCrop(new Position(x, y), foragingType, season);
                tiles[y][x].setForageableItem(foragingCrop);
            }
        }
        return this;
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    
    private boolean isAreaClear(int x, int y, int width, int height) {
        for (int dy = 0; dy < height; dy++) {
            for (int dx = 0; dx < width; dx++) {
                int checkX = x + dx;
                int checkY = y + dy;
                if (!isValidPosition(checkX, checkY) || tiles[checkY][checkX].getType() != TileType.GROUND) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Farm build() {
        Farm farm = new Farm(mapName, width, height);
        farm.setTiles(tiles);
        
        // Add components to the farm
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = tiles[y][x];
                Position position = new Position(x, y);
                
                switch (tile.getType()) {
                    case CABIN:
                        farm.addComponent(new Cabin(position));
                        break;
                    case GREENHOUSE:
                        farm.addComponent(new Greenhouse(position));
                        break;
                    case QUARRY:
                        // Find the full size of the quarry
                        int quarryWidth = 1;
                        int quarryHeight = 1;
                        
                        // Find width
                        while (x + quarryWidth < width && 
                               tiles[y][x + quarryWidth].getType() == TileType.QUARRY) {
                            quarryWidth++;
                        }
                        
                        // Find height
                        while (y + quarryHeight < height && 
                               tiles[y + quarryHeight][x].getType() == TileType.QUARRY) {
                            quarryHeight++;
                        }
                        
                        farm.addComponent(new Quarry(position, quarryWidth, quarryHeight));
                        break;
                    case WATER:
                        // Find the full size of the lake
                        int lakeWidth = 1;
                        int lakeHeight = 1;
                        
                        // Find width
                        while (x + lakeWidth < width && 
                               tiles[y][x + lakeWidth].getType() == TileType.WATER) {
                            lakeWidth++;
                        }
                        
                        // Find height
                        while (y + lakeHeight < height && 
                               tiles[y + lakeHeight][x].getType() == TileType.WATER) {
                            lakeHeight++;
                        }
                        
                        farm.addComponent(new Lake(position, lakeWidth, lakeHeight));
                        break;
                    case TREE:
                        farm.addComponent(new Tree(position, tile.getTreeType()));
                        break;
                    case STONE:
                        farm.addComponent(new Stone(position, tile.getStoneType()));
                        break;
                    case FORAGEABLE:
                        if (tile.getForageableItem() instanceof ForagingCrop) {
                            farm.addComponent((ForagingCrop) tile.getForageableItem());
                        }
                        break;
                }
            }
        }
        
        return farm;
    }
    
    // Pre-defined farm templates
    public static Farm buildStandardFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Standard Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(30, 10, 10, 8)
            .addQuarry(5, 30, 12, 10)
            .randomlyPlaceTrees(30, Season.SPRING)
            .randomlyPlaceStones(20)
            .randomlyPlaceForagingItems(15, Season.SPRING)
            .build();
    }
    
    public static Farm buildFishingFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Fishing Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(25, 10, 15, 12) // Larger lake
            .addLake(10, 30, 8, 8)   // Second lake
            .addQuarry(35, 30, 8, 8) // Smaller quarry
            .randomlyPlaceTrees(25, Season.SPRING)
            .randomlyPlaceStones(15)
            .randomlyPlaceForagingItems(15, Season.SPRING)
            .build();
    }
    
    public static Farm buildMiningFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Mining Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(35, 5, 8, 6)     // Smaller lake
            .addQuarry(5, 25, 20, 15) // Larger quarry
            .randomlyPlaceTrees(20, Season.SPRING)
            .randomlyPlaceStones(35)  // More stones
            .randomlyPlaceForagingItems(10, Season.SPRING)
            .build();
    }
}
