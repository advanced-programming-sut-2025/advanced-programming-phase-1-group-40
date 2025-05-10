package org.example.models.Map;

import org.example.models.enums.enviroment.Season;
import java.util.Random;

/**
 * Builder pattern implementation for creating farm maps
 */
public class MapBuilder {


    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    
    private int width;
    private int height;
    private MapTile[][] tiles;
    private String mapName;
    private Random random;
    
    public MapBuilder() {
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
        this.random = new Random();
    }
    
    public MapBuilder setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }
    
    public MapBuilder setName(String name) {
        this.mapName = name;
        return this;
    }
    
    public MapBuilder initialize() {
        this.tiles = new MapTile[height][width];
        
        // Initialize all tiles as empty ground
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = new MapTile(TileType.GROUND);
            }
        }
        
        return this;
    }
    
    public MapBuilder addCabin(int x, int y) {
        // Cabin is 4x4
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (isValidPosition(x + j, y + i)) {
                    tiles[y + i][x + j] = new MapTile(TileType.CABIN);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addGreenhouse(int x, int y) {
        // Greenhouse is 5x6
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (isValidPosition(x + j, y + i)) {
                    tiles[y + i][x + j] = new MapTile(TileType.GREENHOUSE);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addLake(int x, int y, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isValidPosition(x + j, y + i)) {
                    tiles[y + i][x + j] = new MapTile(TileType.WATER);
                }
            }
        }
        return this;
    }
    
    public MapBuilder addQuarry(int x, int y, int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isValidPosition(x + j, y + i)) {
                    tiles[y + i][x + j] = new MapTile(TileType.QUARRY);
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
                // Could set tree type based on season
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
                // Could set stone type randomly
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
                // Could set foraging type based on season
            }
        }
        return this;
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    
    public Farm build() {
        Farm farm = new Farm(mapName, width, height);
        farm.setTiles(tiles);
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