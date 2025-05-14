package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.ArrayList;

public class CookingRecipe{

    private int energyOfFood;
    private String nameOfFood;
    private int sellPrice;
    private FoodBuff buff;
    private int buffDurationInHours;
    private ArrayList<IngredientType> ingredients;
    public int getEnergyOfFood() {
        return energyOfFood;
    }
    public int getSellPrice() {
        return sellPrice;
    }
    public FoodBuff getBuff() {
        return buff;
    }
    public int getBuffDurationInHours() {
        return buffDurationInHours;
    }
    public String getNameOfFood() {
        return nameOfFood;
    }
}
