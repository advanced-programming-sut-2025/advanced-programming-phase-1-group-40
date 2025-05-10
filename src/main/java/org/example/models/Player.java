package org.example.models;

import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.inventory.*;
import org.example.models.inventory.Backpack;
import org.example.models.tools.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player extends User{

    private int energy;
    private boolean isEnergyUnlimited;
    private Position currentPosition;
    private Tool currentTool;
    private HashMap<Skill, SkillLevels> skillLevels =  new HashMap<>();
    private Map<SecurityQuestion, String> qAndA;
    private Backpack backpack;
    private ArrayList<Item> items = new ArrayList<>();

    public Player(User user){

        super(user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getGender());

        this.skillLevels.put(Skill.FARMING, SkillLevels.LEVEL_ZERO);
        this.skillLevels.put(Skill.MINING, SkillLevels.LEVEL_ZERO);
        this.skillLevels.put(Skill.FORAGING, SkillLevels.LEVEL_ZERO);
        this.skillLevels.put(Skill.FISHING, SkillLevels.LEVEL_ZERO);

    }

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

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }


    public Position getCurrentPosition() {
        return currentPosition;
    }

    public HashMap<Skill, SkillLevels> getSkillLevels() {
        return skillLevels;
    }


    public Map<SecurityQuestion, String> getqAndA() {
        return qAndA;
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
        this.currentPosition = newPosition;
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

    public void cheatAddItemToInventory(Item item, int quantity) {
        backpack.CheatAddToInventory(item, quantity);
    }

    // Get skill level for a specific skill
    public SkillLevel getSkillLevel(Skill skill) {
        return skillLevels.getOrDefault(skill, new SkillLevel(skill));
    }

    // Add XP to a specific skill
    public boolean addSkillXP(Skill skill, int xpAmount) {
        SkillLevel skillLevel = getSkillLevel(skill);
        return skillLevel.addXP(xpAmount);
    }

    // Methods to add XP for specific activities
    public void addFarmingXP() {
        // Add 5 XP for farming activities as per the requirements
        addSkillXP(Skill.FARMING, 5);
    }

    public void addMiningXP() {
        // Add 10 XP for mining activities as per the requirements
        addSkillXP(Skill.MINING, 10);
    }

    public void addForagingXP() {
        // Add 10 XP for foraging activities as per the requirements
        addSkillXP(Skill.FORAGING, 10);
    }

    public void addFishingXP() {
        // Add 5 XP for fishing activities as per the requirements
        addSkillXP(Skill.FISHING, 5);
    }

    // Get the level of a specific skill
    public int getSkillLevelValue(Skill skill) {
        return getSkillLevel(skill).getLevel();
    }

    // Check if a skill is at max level
    public boolean isSkillMaxLevel(Skill skill) {
        return getSkillLevel(skill).getLevel() >= 3;
    }

    // Get a formatted string with all skill levels
    public String getSkillLevelsString() {
        StringBuilder sb = new StringBuilder("Skill Levels:\n");
        for (Map.Entry<Skill, SkillLevels> entry : skillLevels.entrySet()) {
            sb.append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }

    // Getter for backpack
    public Backpack getBackpack() {
        return backpack;
    }

    // Method to upgrade backpack
    public void upgradeBackpack(InventoryType newType) {
        // Create a new backpack with the new type
        Backpack newBackpack = new Backpack(newType);

        // Transfer all items from old backpack to new backpack
        if (this.backpack != null) {
            ArrayList<Item> oldItems = this.backpack.getItems();
            for (Map.Entry<Item, Integer> entry : oldItems) {
                newBackpack.CheatAddToInventory(entry.getKey(), entry.getValue());
            }
        }

        // Replace old backpack with new one
        this.backpack = newBackpack;
    }

    // Convenience methods for inventory operations
    public void addItemToInventory(Item item, int quantity) {
        if (backpack != null) {
            backpack.addToInventory(item, quantity);
        }
    }

    public void removeItemFromInventory(Item item, int quantity) {
        if (backpack != null) {
            backpack.removeFromInventory(item, quantity);
        }
    }

    // Method to check if user has a specific item
    public boolean hasItem(Item item) {
        return backpack != null && backpack.hasItem(item);
    }

    // Method to get quantity of a specific item
    public int getItemQuantity(Item item) {
        return backpack != null ? backpack.getItemQuantity(item) : 0;
    }
}
