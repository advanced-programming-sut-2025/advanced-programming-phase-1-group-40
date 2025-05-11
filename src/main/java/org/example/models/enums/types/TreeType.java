package org.example.models.enums.types;

/**
 * Enum representing different types of trees that can be on the farm
 */
public enum TreeType {
    OAK("Oak", 3, "Oak Wood", 25),
    MAPLE("Maple", 4, "Maple Wood", 30),
    PINE("Pine", 5, "Pine Wood", 35),
    FRUIT_APPLE("Apple Tree", 7, "Apple", 50),
    FRUIT_ORANGE("Orange Tree", 7, "Orange", 55),
    FRUIT_PEACH("Peach Tree", 7, "Peach", 60),
    FRUIT_CHERRY("Cherry Tree", 6, "Cherry", 65);
    
    private final String name;
    private final int growthTime; // Days to grow
    private final String product;
    private final int baseValue;
    
    TreeType(String name, int growthTime, String product, int baseValue) {
        this.name = name;
        this.growthTime = growthTime;
        this.product = product;
        this.baseValue = baseValue;
    }
    
    public String getName() {
        return name;
    }
    
    public int getGrowthTime() {
        return growthTime;
    }
    
    public String getProduct() {
        return product;
    }
    
    public int getBaseValue() {
        return baseValue;
    }
    
    public boolean isFruitTree() {
        return name.contains("Tree");
    }

}