package org.example.models.enums.types;

import java.util.HashMap;

public enum Craft {
    CHERRY_BOMB("Cherry Bomb", createIngredientsMap(IngredientType.COPPER_ORE, 4, IngredientType.COAL, 1), "Mining Level 1", 50),
    BOMB("Bomb", createIngredientsMap(IngredientType.IRON_ORE, 4, IngredientType.COAL, 1), "Mining Level 2", 50),
    MEGA_BOMB("Mega Bomb", createIngredientsMap(IngredientType.GOLD_ORE, 4, IngredientType.COAL, 1), "Mining Level 3", 50),
    SPRINKLER("Sprinkler", createIngredientsMap(IngredientType.COPPER_BAR, 1, IngredientType.IRON_BAR, 1), "Farming Level 1", 0),
    QUALITY_SPRINKLER("Quality Sprinkler", createIngredientsMap(IngredientType.IRON_BAR, 1, IngredientType.GOLD_BAR, 1), "Farming Level 2", 0),
    IRIDIUM_SPRINKLER("Iridium Sprinkler", createIngredientsMap(IngredientType.GOLD_BAR, 1, IngredientType.IRIDIUM_BAR, 1), "Farming Level 3", 0),
    CHARCOAL_KILN("Charcoal Kiln", createIngredientsMap(IngredientType.WOOD, 20, IngredientType.COPPER_BAR, 2), "Foraging Level 1", 0),
    FURNACE("Furnace", createIngredientsMap(IngredientType.COPPER_ORE, 20, IngredientType.STONE, 25), "-", 0),
    SCARECROW("Scarecrow", createIngredientsMap(IngredientType.WOOD, 50, IngredientType.COAL, 1, IngredientType.FIBER, 20), "-", 0),
    DELUXE_SCARECROW("Deluxe Scarecrow", createIngredientsMap(IngredientType.WOOD, 50, IngredientType.COAL, 1, IngredientType.FIBER, 20, IngredientType.IRIDIUM_ORE, 1), "Farming Level 2", 0),
    BEE_HOUSE("Bee House", createIngredientsMap(IngredientType.WOOD, 40, IngredientType.COAL, 8, IngredientType.IRON_BAR, 1), "Farming Level 1", 0),
    CHEESE_PRESS("Cheese Press", createIngredientsMap(IngredientType.WOOD, 45, IngredientType.STONE, 45, IngredientType.COPPER_BAR, 1), "Farming Level 2", 0),
    KEG("Keg", createIngredientsMap(IngredientType.WOOD, 30, IngredientType.COPPER_BAR, 1, IngredientType.IRON_BAR, 1), "Farming Level 3", 0),
    LOOM("Loom", createIngredientsMap(IngredientType.WOOD, 60, IngredientType.FIBER, 30), "Farming Level 3", 0),
    MAYONNAISE_MACHINE("Mayonnaise Machine", createIngredientsMap(IngredientType.WOOD, 15, IngredientType.STONE, 15, IngredientType.COPPER_BAR, 1), "-", 0),
    OIL_MAKER("Oil Maker", createIngredientsMap(IngredientType.WOOD, 100, IngredientType.GOLD_BAR, 1, IngredientType.IRON_BAR, 1), "Farming Level 3", 0),
    PRESERVES_JAR("Preserves Jar", createIngredientsMap(IngredientType.WOOD, 50, IngredientType.STONE, 40, IngredientType.COAL, 8), "Farming Level 2", 0),
    DEHYDRATOR("Dehydrator", createIngredientsMap(IngredientType.WOOD, 30, IngredientType.STONE, 20, IngredientType.FIBER, 30), "Pierre's General Store", 0),
    GRASS_STARTER("Grass Starter", createIngredientsMap(IngredientType.WOOD, 1, IngredientType.FIBER, 1), "Pierre's General Store", 0),
    FISH_SMOKER("Fish Smoker", createIngredientsMap(IngredientType.WOOD, 50, IngredientType.IRON_BAR, 3, IngredientType.COAL, 10), "Fish Shop", 0),
    MYSTIC_TREE_SEED("Mystic Tree Seed", createIngredientsMap(IngredientType.ACORN, 5, IngredientType.MAPLE_SEED, 5, IngredientType.PINE_CONE, 5, IngredientType.MAHOGANY_SEED, 5), "Foraging Level 4", 100);

    private final String name;
    private final HashMap<IngredientType, Integer> ingredients;
    private final String source;
    private final int sellPrice;

    Craft(String name, HashMap<IngredientType, Integer> ingredients, String source, int sellPrice) {
        this.name = name;
        this.ingredients = ingredients;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public HashMap<IngredientType, Integer> getIngredients() {
        return ingredients;
    }

    public String getSource() {
        return source;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    private static HashMap<IngredientType, Integer> createIngredientsMap(Object... items) {
        HashMap<IngredientType, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i += 2) {
            if (items[i] instanceof IngredientType && items[i + 1] instanceof Integer) {
                map.put((IngredientType) items[i], (Integer) items[i + 1]);
            }
        }
        return map;
    }
}
