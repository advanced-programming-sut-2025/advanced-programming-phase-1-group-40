package org.example.models.Map;

import org.example.models.Map.SecondaryMapComponents.ForagingCrop;
import org.example.models.Map.SecondaryMapComponents.ForagingMineral;
import org.example.models.Position;
import org.example.models.Map.SecondaryMapComponents.Tree;
import org.example.models.enums.enviroment.Season;
import org.example.models.enums.types.ForagingType;
import org.example.models.enums.types.ForagingMineralType;
import org.example.models.enums.types.TreeType;

import java.util.*;

/**
 * Builder class for creating farm maps
 */
public class MapBuilder {


    private String mapName;
    private int width;
    private int height;
    private ArrayList<MapTile> tiles;
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
        this.tiles = new ArrayList<>();

        // Initialize all tiles as GROUND
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Position position = new Position(x, y);
                tiles.add(new MapTile(position, TileType.GROUND));

            }
        }

        return this;
    }

   /* public MapBuilder addCabin(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 3, 3)) {
            for (int dy = 0; dy < 3; dy++) {
                for (int dx = 0; dx < 3; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.CABIN);
                }
            }
        }
        return this;
    }*/
   public MapBuilder addCabin(int x, int y) {
       if (isValidPosition(x, y) && isAreaClear(x, y, 3, 3)) {
           for (int dy = 0; dy < 3; dy++) {
               for (int dx = 0; dx < 3; dx++) {
                   int index = (y + dy) * width + (x + dx);
                   tiles.set(index, new MapTile(new Position(x + dx, y + dy), TileType.CABIN));
               }
           }
       }
       return this;
   }




    /*public MapBuilder addGreenhouse(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 5, 6)) {
            for (int dy = 0; dy < 6; dy++) {
                for (int dx = 0; dx < 5; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.GREENHOUSE);
                }
            }
        }
        return this;
    }*/
    public MapBuilder addGreenhouse(int x, int y) {
        if (isValidPosition(x, y) && isAreaClear(x, y, 5, 6)) {
            for (int dy = 0; dy < 6; dy++) {
                for (int dx = 0; dx < 5; dx++) {
                    int index = (y + dy) * width + (x + dx);
                    tiles.set(index, new MapTile(new Position(x + dx, y + dy), TileType.GREENHOUSE));
                }
            }
        }
        return this;
    }


    /*public MapBuilder addLake(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.WATER);
                }
            }
        }
        return this;
    }*/
    public MapBuilder addLake(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    int index = (y + dy) * this.width + (x + dx);
                    tiles.set(index, new MapTile(new Position(x + dx, y + dy), TileType.WATER));
                }
            }
        }
        return this;
    }


    /*public MapBuilder addQuarry(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    tiles[y + dy][x + dx] = new MapTile(TileType.QUARRY);
                }
            }
        }
        return this;
    }*/
    public MapBuilder addQuarry(int x, int y, int width, int height) {
        if (isValidPosition(x, y) && isAreaClear(x, y, width, height)) {
            for (int dy = 0; dy < height; dy++) {
                for (int dx = 0; dx < width; dx++) {
                    int index = (y + dy) * this.width + (x + dx);
                    tiles.set(index, new MapTile(new Position(x + dx, y + dy), TileType.QUARRY));
                }
            }
        }
        return this;
    }


    public MapBuilder randomlyPlaceTrees(int count, Season season) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int index = y * width + x;

            if (isValidPosition(x, y) && tiles.get(index).getType() == TileType.GROUND) {
                TreeType treeType;
                int treeRoll = random.nextInt(100);
                if (treeRoll < 40) {
                    treeType = TreeType.OAK_TREE;
                } else if (treeRoll < 70) {
                    treeType = TreeType.MAPLE_TREE;
                } else if (treeRoll < 90) {
                    treeType = TreeType.PINE_TREE;
                } else {
                    //
                }
                tiles.set(index, new MapTile(new Position(x, y), TileType.TREE));
            }
        }

        return this;
    }


    public MapBuilder randomlyPlaceStones(int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int index = y * width + x;

            if (isValidPosition(x, y) && tiles.get(index).getType() == TileType.GROUND) {
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

                // Create new tile with stone type
                MapTile stoneTile = new MapTile(new Position(x, y), TileType.STONE);
                stoneTile.setStoneType(foragingMineralType);

                tiles.set(index, stoneTile);
            }
        }

        return this;
    }

    public MapBuilder randomlyPlaceForagingItems(int count, Season season) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int index = y * width + x;

            if (isValidPosition(x, y) && tiles.get(index).getType() == TileType.GROUND) {
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

                ForagingCrop foragingCrop = new ForagingCrop(new Position(x, y));
                MapTile foragingTile = new MapTile(new Position(x, y), TileType.FORAGEABLE);
                foragingTile.setForageableItem(foragingCrop);
                tiles.set(index, foragingTile);
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
                if (!isValidPosition(checkX, checkY)) {
                    return false;
                }
                int index = checkY * width + checkX;
                if (tiles.get(index).getType() != TileType.GROUND) {
                    return false;
                }
            }
        }
        return true;
    }

    public Farm build() {
        Farm farm = new Farm(mapName, width, height);
        farm.setTiles(tiles);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                MapTile tile = tiles.get(index);
                Position position = new Position(x, y);

                switch (tile.getType()) {
                    case CABIN:
                        farm.addComponent(new Cabin(position));
                        break;
                    case GREENHOUSE:
                        farm.addComponent(new Greenhouse(x, y));
                        break;
                    case QUARRY:
                        // Find the full size of the quarry
                        int quarryWidth = 1;
                        int quarryHeight = 1;

                        // Find width
                        while (x + quarryWidth < width &&
                            tiles.get(index + quarryWidth).getType() == TileType.QUARRY) {
                            quarryWidth++;
                        }

                        // Find height
                        while (y + quarryHeight < height &&
                            tiles.get(index + quarryHeight * width).getType() == TileType.QUARRY) {
                            quarryHeight++;
                        }

                        farm.addComponent(new Quarry(position, quarryWidth, quarryHeight));
                        break;
                    case WATER:
                        int lakeWidth = 1;
                        int lakeHeight = 1;

                        while (x + lakeWidth < width &&
                            tiles.get(index + lakeWidth).getType() == TileType.WATER) {
                            lakeWidth++;
                        }

                        while (y + lakeHeight < height &&
                            tiles.get(index + lakeHeight * width).getType() == TileType.WATER) {
                            lakeHeight++;
                        }

                        farm.addComponent(new Lake(x, y, lakeWidth, lakeHeight));
                        break;
                    case TREE:
                        farm.addComponent(new Tree(tile.getTreeType(), new Position(x, y)));
                        break;
                    case STONE:
                        farm.addComponent(new ForagingMineral(position));
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







    // Pre-defined farm templates----------------------------------------------------------------------
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
            .addLake(30, 10, 10, 8)
            .addQuarry(5, 30, 12, 10)
            .randomlyPlaceTrees(30, Season.SPRING)
            .randomlyPlaceStones(20)
            .randomlyPlaceForagingItems(15, Season.SPRING)
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
                int index = j * this.width + i;
                tiles.set(index, new MapTile(new Position(x, y), TileType.WATER));
            }
        }
        return this;
    }


//    private MapBuilder addHill(int x, int y, int width, int height) {
//        for (int i = x; i < x + width && i < this.width; i++) {
//            for (int j = y; j < y + height && j < this.height; j++) {
//                int index = j * this.width + i;
//                tiles.set(index, new MapTile(TileType.HILL));
//            }
//        }
//        return this;
//    }

    private MapBuilder randomlyPlaceOres(int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            int index = y * this.width + x;

            if (tiles.get(index).getType() == TileType.DIRT || tiles.get(index).getType() == TileType.QUARRY) {
                tiles.set(index, new MapTile(new Position(x, y), TileType.ORE));
            }
        }
        return this;
    }



}
