package org.example.models;

import org.example.models.enums.types.IngredientType;
import java.util.Map;

public class CraftingRecipe {
    private final String name;
    private final String description;
    private final Map<IngredientType, Integer> ingredients;
    private final String source;
    private final int sellPrice;

    public CraftingRecipe(String name, String description, Map<IngredientType, Integer> ingredients, String source, int sellPrice) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.source = source;
        this.sellPrice = sellPrice;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Map<IngredientType, Integer> getIngredients() { return ingredients; }
    public String getSource() { return source; }
    public int getSellPrice() { return sellPrice; }
}
