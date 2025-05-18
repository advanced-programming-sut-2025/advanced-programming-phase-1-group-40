package org.example.models.Map;

/**
 * Enum representing different types of tiles on the farm map
 */
public enum TileType {


                                               ///  SHOP MARNIE B MAP ADD BEDE!!!!!!!!!!!

    ///  FARM BUILDING TYPE!!!!    -> ANIMAL LIVING SAPCE

    BARN,
    BIG_BARN,
    DELUXE_BARN,
    COOP,
    BIG_COOP,
    DELUXE_COOP,
    WELL,
    SHIPPING_BIN,

    //some stores
    BLACKSMITH,
    JOJAMART,
    PIERRE_GENERAL_STORE,
    CARPENTER_SHOP,
    FISH_SHOP,
    MARNIES_RANCH,
    THE_STARDROP_SALOON,




    DIRT,
    ORE,
    MONSTER_SPAWN,
    GRASS,
    HILL,
    GROUND,         // Basic untilled ground
    TILLED_SOIL,    // Soil that has been tilled but not watered
    WATERED_SOIL,   // Soil that has been tilled and watered
    PLANTED_SOIL,   // Soil with a crop planted in it
    WATER,          // Water tile (lake, river, etc.)
    TREE,           // Tile with a tree
    STONE,          // Tile with a stone
    FORAGEABLE,     // Tile with a forageable item
    CABIN,          // Player's cabin
    GREENHOUSE,     // Greenhouse for year-round growing
    QUARRY,         // Mining area
    PATH,           // Decorative path
    COAL,
    FENCE;          // Fence to keep out animals
    
    
    /**
     * Check if this tile type can be walked on by the player
     * @return true if walkable, false otherwise
     */
    public boolean isWalkable() {
        switch (this) {
            case GROUND:
            case TILLED_SOIL:
            case WATERED_SOIL:
            case PLANTED_SOIL:
            case PATH:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Check if this tile type can be tilled
     * @return true if tillable, false otherwise
     */
    public boolean isTillable() {
        return this == GROUND;
    }
    
    /**
     * Check if this tile type can be planted on
     * @return true if plantable, false otherwise
     */
    public boolean isPlantable() {
        return this == TILLED_SOIL || this == WATERED_SOIL;
    }
    
    /**
     * Check if this tile type can be watered
     * @return true if waterable, false otherwise
     */
    public boolean isWaterable() {
        return this == TILLED_SOIL || this == PLANTED_SOIL;
    }
}
