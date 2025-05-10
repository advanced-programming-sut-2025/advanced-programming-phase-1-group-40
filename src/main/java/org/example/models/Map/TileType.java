package org.example.models.Map;

/**
 * Enum representing different types of tiles on the farm
 */
public enum TileType {
    GROUND,         // Basic untilled ground
    TILLED_SOIL,    // Soil that has been tilled but not watered
    WATERED_SOIL,   // Soil that has been tilled and watered
    PLANTED_SOIL,   // Soil with a crop planted in it
    WATER,          // Water tile (lake, pond, etc.)
    CABIN,          // Player's cabin
    GREENHOUSE,     // Greenhouse for year-round growing
    QUARRY,         // Mining area
    TREE,           // Tree (various types)
    STONE,          // Stone (various types)
    FORAGEABLE,     // Forageable item
    PATH;            // Constructed path



}
