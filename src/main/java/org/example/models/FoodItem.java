package org.example.models;
import org.example.models.Item;
import org.example.models.enums.types.Food;

public class FoodItem implements Item {

    private final Food food;

    public FoodItem(Food food) {
        this.food = food;
    }

    @Override
    public String getItemName() {
        return food.getName();
    }

    public Food getFood() {
        return food;
    }


    @Override
    public String toString() {
        return getItemName();
    }
}
