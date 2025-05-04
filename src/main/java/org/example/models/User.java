package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private String email;
    private int energy;
    private boolean isEnergyUnlimited;
    private Position position;
    private Tool currentTool;
    private HashMap<Skill, SkillLevel> SkillLevels;
    private ArrayList<Farm> farms;
    private ArrayList<CraftRecipe> learntCraftRecipes;
    private ArrayList<Food> learntCookingRecipes;
    private Map<SecurityQuestion, String> qAndA;
    private Farm farm;
    private Farm chosenFarm;
    private Backpack backpack;

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energyAmount) {
        if (this.isEnergyUnlimited) {
            this.energy = Integer.MAX_VALUE;
        } else {
            this.energy = energyAmount;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Position getPosition() {
        return position;
    }

    public HashMap<Skill, SkillLevel> getSkillLevels() {
        return SkillLevels;
    }

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public ArrayList<CraftRecipe> getLearntCraftRecipes() {
        return learntCraftRecipes;
    }

    public ArrayList<Food> getLearntCookingRecipes() {
        return learntCookingRecipes;
    }

    public Map<SecurityQuestion, String> getqAndA() {
        return qAndA;
    }

    public Farm getFarm() {
        return farm;
    }

    public Farm getChosenFarm() {
        return chosenFarm;
    }

    public boolean isEnergyUnlimited() {
        return this.isEnergyUnlimited;
    }

    public void setEnergyUnlimited(boolean unlimitedEnergy) {
        this.isEnergyUnlimited = unlimitedEnergy;
    }

    public void faint() {
        // Set energy to 150 for the next day
        this.energy = 150;
        // Additional logic for skipping to the next day would go here
        // This might involve updating the game time, etc.
    }

    public Tool getCurrentTool() {
        return this.currentTool;
    }

    public void useTool(Direction direction) {

    }

    public void changePosition(Position newPosition) {
        this.position = newPosition;
    }


    public String getStringLearntCookingRecipes() {
        return null;
    }

    public String getStringLearntCraftRecipes() {
        return null;
    }

    public void LearnNewCraftRecipe(Food craftRecipe) {
    }

    public void LearnNewCookingRecipe(CookingRecipe cookingRecipe) {
    }

    public void eat(String foodName) {
    }

    public Map<SecurityQuestion, String> getQAndA() {
        return qAndA;
    }

    public void setQAndA(Map<SecurityQuestion, String> qAndA) {
        this.qAndA = qAndA;
    }

    public Inventory getInventory() {
        return backpack;
    }

    public void addItemToInventory(Item item, int quantity) {
        backpack.addToInventory(item, quantity);
    }

    public void removeItemFromInventory(Item item, int quantity) {
        backpack.removeFromInventory(item, quantity);
    }

    public void cheatAddItemToInventory(Item item, int quantity) {
        backpack.CheatAddToInventory(item, quantity);
    }
}
