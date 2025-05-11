package org.example.models.enums.types;

/**
 * Enum representing different types of forageable items
 */
public enum ForagingType {
    WILD_BERRY,
    MUSHROOM,
    HERB,
    FLOWER,
    TRUFFLE;
    
    /**
     * Get the base value of this forageable type
     * @return The base value in gold
     */
    public int getBaseValue() {
        switch (this) {
            case WILD_BERRY:
                return 50;
            case MUSHROOM:
                return 75;
            case HERB:
                return 100;
            case FLOWER:
                return 60;
            case TRUFFLE:
                return 500;
            default:
                return 25;
        }
    }
    
    /**
     * Get the energy restoration value when consumed
     * @return The energy value
     */
    public int getEnergyValue() {
        switch (this) {
            case WILD_BERRY:
                return 15;
            case MUSHROOM:
                return 20;
            case HERB:
                return 10;
            case FLOWER:
                return 5;
            case TRUFFLE:
                return 40;
            default:
                return 5;
        }
    }
}