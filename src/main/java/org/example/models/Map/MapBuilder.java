package org.example.models.Map;

import org.example.models.Map.SecondaryMapComponents.ForagingCrop;
import org.example.models.Map.SecondaryMapComponents.ForagingMineral;
import org.example.models.Position;
import org.example.models.Map.SecondaryMapComponents.Tree;
import org.example.models.enums.enviroment.Season;
import org.example.models.enums.types.ForagingType;
import org.example.models.enums.types.ForagingMineralType;
import org.example.models.enums.types.TreeType;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.tiles = new MapTile[width][height];
        
        // Initialize all tiles as GROUND
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Position pos = new Position(x, y);
                tiles[x][y] = new MapTile(pos, TileType.GROUND);
            }
        }
        
        return this;
    }
    
    public MapBuilder addCabin(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 4, 4)) {
            for (int dy = 0; dy < 4; dy++) {
                for (int dx = 0; dx < 4; dx++) {
                    // Position pos = new Position(x + dx, y + dy);
                    // tiles[x + dx][y + dy] = new MapTile(pos, TileType.CABIN);
                    tiles[x + dx][y + dy].setType(TileType.CABIN);
                }
            }
        }
        
        return this;
    }
    
    public MapBuilder addGreenhouse(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 5, 6)) {
            for (int dy = 0; dy < 6; dy++) {
                for (int dx = 0; dx < 5; dx++) {
                    Position pos = new Position(x + dx, y + dy);
                    tiles[x + dx][y + dy] = new MapTile(pos, TileType.GREENHOUSE);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addLake(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    Position pos = new Position(x + dx, y + dy);
                    tiles[x + dx][y + dy] = new MapTile(pos, TileType.WATER);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addQuarry(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    Position pos = new Position(x + dx, y + dy);
                    tiles[x + dx][y + dy] = new MapTile(pos, TileType.QUARRY);
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
                Position pos = new Position(x , y);
                tiles[y][x] = new MapTile(pos, TileType.TREE);
                
                // Set tree type based on season
                TreeType treeType;
                int treeRoll = random.nextInt(100);
                
                if (treeRoll < 40) {
                    treeType = TreeType.OAK_TREE;
                } else if (treeRoll < 70) {
                    treeType = TreeType.MAPLE_TREE;
                } else if (treeRoll < 90) {
                    treeType = TreeType.PINE_TREE;
                } else {
                    // TODO
                    treeType = TreeType.OAK_TREE;
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
                Position pos = new Position(x , y);
                tiles[y][x] = new MapTile(pos, TileType.STONE);
                
                // Set stone type
                ForagingMineralType foragingMineralType;
                int stoneRoll = random.nextInt(100);
                
                if (stoneRoll < 60) {
                    foragingMineralType = ForagingMineralType.REGULAR;
                } else if (stoneRoll < 80) {
                    foragingMineralType = ForagingMineralType.COPPER;
                } else if (stoneRoll < 90) {
                    foragingMineralType = ForagingMineralType.IRON;
                } else if (stoneRoll < 97) {
                    foragingMineralType = ForagingMineralType.GOLD;
                } else {
                    foragingMineralType = ForagingMineralType.IRIDIUM;
                }
                
                tiles[y][x].setStoneType(foragingMineralType);
            }
        }
        return this;
    }
    
    public MapBuilder randomlyPlaceForagingItems(int count, Season season) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            
            if (isValidPosition(x, y) && tiles[y][x].getType() == TileType.GROUND) {
                tiles[y][x] = new MapTile(new Position(x, y), TileType.FORAGEABLE);
                
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
                ForagingCrop foragingCrop = new ForagingCrop(new Position(x, y));
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

        // ArrayList<MapTile> tilesArrayList = new ArrayList<>();
        // for (int i = 0; i < tiles.length; i++) {
        //     tilesArrayList.addAll(Arrays.asList(tiles[i]));
        // }
        // farm.setTiles(tilesArrayList);
        MapTile[][] tilesMap = new MapTile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++){
                tilesMap[i][j] = tiles[i][j];
            }
        }
        farm.setTiles(tilesMap);

        
        // Add components to the farm
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = tiles[y][x];
                Position position = new Position(x, y);
                
                switch (tile.getType()) {
                    case TREE:
                        farm.addComponent(new Tree(tile.getTreeType(),position));
                        farm.getTrees().add(new Tree(tile.getTreeType(),position));
                        break;
                    case STONE:
                        farm.addComponent(new ForagingMineral(position, tile.getStoneType()));
                        farm.getForagingMinerals().add(new ForagingMineral(position, tile.getStoneType()));
                        break;
                    case FORAGEABLE:
                        if (tile.getForageableItem() instanceof ForagingCrop) {
                            farm.addComponent((ForagingCrop) tile.getForageableItem());
                            farm.getForagingItems().add((ForagingCrop) tile.getForageableItem());
                        }
                        break;
                    case CABIN:
                    if(isNewComponent(farm, new Cabin(position))){
                        farm.addComponent(new Cabin(position));
                        farm.getCabin().add(new Cabin(position));
                    }
                        break;
                    
                    case GREENHOUSE:
                    if(isNewComponent(farm, new Greenhouse(position))){
                        farm.addComponent(new Greenhouse(x, y));
                        farm.getGreenhouse().add(new Greenhouse(position));
                    }
                        break;
                    
                    case QUARRY:
                        // Find the full size of the quarry
                        int quarryWidth = 1;
                        int quarryHeight = 1;
                        
                        while (x + quarryWidth < width && 
                               tiles[y][x + quarryWidth].getType() == TileType.QUARRY) {
                            quarryWidth++;
                        }
                        
                        while (y + quarryHeight < height && 
                               tiles[y + quarryHeight][x].getType() == TileType.QUARRY) {
                            quarryHeight++;
                        }
                        if(isNewComponent(farm, new Quarry(position, quarryWidth, quarryHeight))){
                        farm.addComponent(new Quarry(position, quarryWidth, quarryHeight));
                        farm.getQuarry().add(new Quarry(position, quarryWidth, quarryHeight));
                        }
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
                        if(isNewComponent(farm, new Lake(position, lakeWidth, lakeHeight))){
                        farm.addComponent(new Lake(position, lakeWidth, lakeHeight));
                        farm.getLakes().add(new Lake(position, lakeWidth, lakeHeight));
                        }
                        break;
                    
                }
            }
        }
        
        return farm;
    }

    public boolean isNewComponent(Farm farm,
     MapComponents newComponent){
        for(MapComponents component : farm.getComponents()) {
            if(component.getClass().equals(newComponent.getClass())) {
                int x = component.getPosition().getX();
                int y = component.getPosition().getY();
                int dx = component.getWidth();
                int dy = component.getHeight();
                for(int i = x; i < x + dx; i++) {
                    for(int j = y; j < y + dy; j++) {
                        if(i == newComponent.getPosition().getX() &&
                         j == newComponent.getPosition().getY()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    // Pre-defined farm templates
    /**
     * Builds a standard farm with balanced resources
     */
    public static Farm buildStandardFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Standard Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(30, 10, 5, 8)
            .addQuarry(5, 30, 5, 5)
            .randomlyPlaceTrees(10, Season.SPRING)
            .randomlyPlaceStones(10)
            .randomlyPlaceForagingItems(10, Season.SPRING)
            .build();
    }
    
    /**
     * Builds a fishing farm with more water areas
     */
    public static Farm buildFishingFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Fishing Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(25, 10, 15, 12) // Larger lake
            .addLake(10, 30, 8, 8)   // Second lake
            .addRiver(0, 20, 50, 5)  // River across the farm
            .addQuarry(35, 30, 8, 8) // Smaller quarry
            .randomlyPlaceTrees(25, Season.SPRING)
            .randomlyPlaceStones(15)
            .randomlyPlaceForagingItems(10, Season.SPRING)
            .build();
    }
    
    /**
     * Builds a mining farm with more mining resources
     */
    public static Farm buildMiningFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Mining Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(40, 10, 8, 6)   // Smaller lake
            .addQuarry(20, 20, 20, 15) // Large central quarry
            .addQuarry(5, 30, 10, 10)  // Second quarry
            .randomlyPlaceTrees(20, Season.SPRING)
            .randomlyPlaceStones(40)   // More stones
            .randomlyPlaceOres(15)     // Special ores
            .randomlyPlaceForagingItems(10, Season.SPRING)
            .build();
    }
    
    /**
     * Builds a forest farm with more trees and foraging opportunities
     */
    public static Farm buildForestFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Forest Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(40, 10, 8, 6)     // Small lake
            .addQuarry(40, 40, 8, 8)   // Small quarry
            .randomlyPlaceTrees(60, Season.SPRING) // Many trees
            .randomlyPlaceStones(15)
            .randomlyPlaceForagingItems(30, Season.SPRING) // Many foraging items
            .build();
    }
    
    /**
     * Builds a river farm with a river running through it
     */
    public static Farm buildRiverFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("River Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addRiver(0, 15, 50, 8)    // Main river
            .addRiver(25, 0, 5, 50)    // Tributary
            .addLake(35, 35, 10, 10)   // Lake
            .addQuarry(5, 30, 10, 10)
            .randomlyPlaceTrees(30, Season.SPRING)
            .randomlyPlaceStones(20)
            .randomlyPlaceForagingItems(15, Season.SPRING)
            .build();
    }
    
    /**
     * Builds a hill-top farm with elevated areas
     */
    public static Farm buildHillTopFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Hill-Top Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addHill(20, 20, 15, 15)   // Central hill
            .addHill(40, 10, 8, 8)     // Small hill
            .addLake(10, 30, 8, 8)     // Lake
            .addQuarry(30, 35, 10, 10) // Quarry
            .randomlyPlaceTrees(35, Season.SPRING)
            .randomlyPlaceStones(25)
            .randomlyPlaceForagingItems(15, Season.SPRING)
            .build();
    }
    
    /**
     * Builds a wilderness farm with more wild resources but more challenging
     */
    public static Farm buildWildernessFarm() {
        return new MapBuilder()
            .setDimensions(50, 50)
            .setName("Wilderness Farm")
            .initialize()
            .addCabin(5, 5)
            .addGreenhouse(15, 5)
            .addLake(35, 15, 12, 10)   // Lake
            .addQuarry(10, 35, 12, 10) // Quarry
            .randomlyPlaceTrees(50, Season.SPRING) // Many trees
            .randomlyPlaceStones(30)               // Many stones
            .randomlyPlaceForagingItems(25, Season.SPRING) // Many foraging items
            .build();
    }

    // Helper methods for new features
    private MapBuilder addRiver(int x, int y, int width, int height) {
        for (int i = x; i < x + width && i < this.width; i++) {
            for (int j = y; j < y + height && j < this.height; j++) {
                tiles[j][i] = new MapTile(new Position(x, y), TileType.WATER);
            }
        }
        return this;
    }

    private MapBuilder addHill(int x, int y, int width, int height) {
        for (int i = x; i < x + width && i < this.width; i++) {
            for (int j = y; j < y + height && j < this.height; j++) {
                tiles[j][i] = new MapTile(new Position(x, y), TileType.HILL);
            }
        }
        return this;
    }

    private MapBuilder randomlyPlaceOres(int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            
            if (tiles[y][x].getType() == TileType.DIRT || 
                tiles[y][x].getType() == TileType.QUARRY) {
                tiles[y][x] = new MapTile(new Position(x, y), TileType.ORE);
            }
        }
        return this;
    }


}
