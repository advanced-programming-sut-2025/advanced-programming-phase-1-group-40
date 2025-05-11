package org.example.models.enums.types;

import org.example.models.enums.enviroment.Season;

/**
 * Enum representing different types of trees that can be on the farm
 */
public enum TreeType {

    /// !!!!!!!!!!!!!
    /// SEASON HAYE SPRING -> BA SPRING REPLACE SHODAN!!!

    APRICOT_TREE("Apricot Tree", "Apricot Sapling", FruitType.APRICOT, 1, Season.SPRING),
    CHERRY_TREE("Cherry Tree", "Cherry Sapling", FruitType.CHERRY, 1, Season.SPRING),
    BANANA_TREE("Banana Tree", "Banana Sapling", FruitType.BANANA, 1, Season.SUMMER),
    MANGO_TREE("Mango Tree", "Mango Sapling", FruitType.MANGO, 1, Season.SUMMER),
    ORANGE_TREE("Orange Tree", "Orange Sapling", FruitType.ORANGE, 1, Season.SUMMER),
    PEACH_TREE("Peach Tree", "Peach Sapling", FruitType.PEACH, 1, Season.SUMMER),
    APPLE_TREE("Apple Tree", "Apple Sapling", FruitType.APPLE, 1, Season.FALL),
    POMEGRANATE_TREE("Pomegranate Tree", "Pomegranate Sapling", FruitType.POMEGRANATE, 1, Season.FALL),
    OAK_TREE("Oak Tree", "Acorns", FruitType.OAK_RESIN, 7, Season.SPRING),
    MAPLE_TREE("Maple Tree", "Maple Seeds", FruitType.MAPLE_SYRUP, 9, Season.SPRING),
    PINE_TREE("Pine Tree", "Pine Cones", FruitType.PINE_TAR, 5, Season.SPRING),
    MAHOGANY_TREE("Mahogany Tree", "Mushroom Seeds", FruitType.MUSHROOM, 3, Season.SPRING),
    MUSHROOM_TREE("Mushroom Tree", "Mushroom Seeds", FruitType.MUSHROOM, 3, Season.SPRING),
    MYSTIC_TREE("Mystic Tree", "Mushroom Seeds", FruitType.MUSHROOM, 3, Season.SPRING);


    private final String name;
    private final String source;
    private final FruitType fruitType;
    private final Integer fruitHarvestCycle;
    private final Season season;

    TreeType(String name, String source, FruitType fruitType, Integer fruitHarvestCycle, Season season) {
        this.name = name;
        this.source = source;
        this.fruitType = fruitType;
        this.fruitHarvestCycle = fruitHarvestCycle;
        this.season = season;
    }
}