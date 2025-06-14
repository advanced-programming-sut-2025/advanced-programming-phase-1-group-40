package org.example.models;

import org.example.models.Animal.AnimalProduct;
import org.example.models.Animal.AnimalProductQuality;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.inventory.Inventory;
import org.example.models.inventory.Backpack;
import org.example.models.inventory.Refrigerator;
import org.example.models.tools.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player extends User {


    private int energy;
    private int maxEnergy;
    private boolean isEnergyUnlimited;
    private Position currentPosition;
    private Position farmPosition;
    private Tool currentTool;
    private ArrayList<SkillLevel> skillLevels = new ArrayList<>(); // Changed from SkillLevels to SkillLevel
    private Backpack backpack;
    private int highestMoney;
    private int gamesPlayed;
    private Refrigerator refrigerator;
    private Inventory inventory;
    private ArrayList<FriendshipWithPlayers> friendships;
    private ArrayList<Tool> tools = new ArrayList<>();
    private Integer gold;
    private HashMap<Player,ArrayList<String>> talkHistory;

    public Player(User user) {

        super(user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getGender(),user.getSecurityQuestion(),user.getSecurityAnswer());

        // Initialize backpack with default type
        this.backpack = new Backpack(InventoryType.INITIAL);
        this.backpack.addToInventory(new AnimalProduct(AnimalProductType.EGG, AnimalProductQuality.NORMAL),1);

        // Initialize skill levels
        this.skillLevels.add(new SkillLevel(Skill.FARMING));
        this.skillLevels.add(new SkillLevel(Skill.MINING));
        this.skillLevels.add(new SkillLevel(Skill.FORAGING));
        this.skillLevels.add(new SkillLevel(Skill.FISHING));

        this.gold = 1000;
        this.friendships = new ArrayList<>();
        this.talkHistory = new HashMap<>();
        this.energy = 200;


    }

    public void setFarmPosition(Position farmPosition) {
        this.farmPosition = farmPosition;
    }

    public Position getFarmPosition() {
        return farmPosition;
    }

    public ArrayList<FriendshipWithPlayers> getFriendships() {
        return friendships;
    }

    public void addFriendship(FriendshipWithPlayers friendship) {
        this.friendships.add(friendship);
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public void changeGold(Integer amount) {
        this.gold += gold;
    }

    public boolean hasEnoughEnergy(int energyCost) {
        return energy >= energyCost;
    }

    public void consumeEnergy(int energyCost) {
        this.energy -= energyCost;
        if(energy <= 0) {
            this.energy = 0;
        }
    }


    public void increaseEnergy(int energyCost) {
        this.energy = Math.min(this.maxEnergy, this.energy + energyCost);
    }


    public ArrayList<Tool> getTools() {

        return tools;

    }

    public void addTool(Tool tool) {

        tools.add(tool);

    }



    public int getHighestEarnedMoney() {
        return highestMoney;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
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

    public void setHighestMoney(int highestMoney) {
        this.highestMoney = highestMoney;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

//    public HashMap<Player, FriendshipWithNPC> getFriendships() {
//        return friendships;
//    }
//
//    public void setFriendships(Player targetPlayer, FriendshipWithNPC friendshipWithNPC) {
//        this.friendships.put(targetPlayer, friendshipWithNPC);
//    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public void setSkillLevels(ArrayList<SkillLevel> skillLevels) {
        this.skillLevels = skillLevels;
    }


    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
    public void setCurrentPosition(int x, int y) {
        this.currentPosition = new Position(x, y);
    }


    public Position getCurrentPosition() {
        return currentPosition;
    }

    public ArrayList<SkillLevel> getSkillLevels() {
        return skillLevels;
    }




    public boolean isEnergyUnlimited() {
        return this.isEnergyUnlimited;
    }

    public void setEnergyUnlimited(boolean unlimitedEnergy) {
        this.isEnergyUnlimited = unlimitedEnergy;
        if(unlimitedEnergy){
            this.energy = 200;
        }
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



    public Inventory getInventory() {
        return backpack;
    }

    public void cheatAddItemToInventory(Item item, int quantity) {
        backpack.CheatAddToInventory(item, quantity);
    }

    // Get skill level for a specific skill
    public SkillLevel getSkillLevel(Skill skill) {
        

        for( SkillLevel skillLevel : skillLevels ){
            if ( skillLevel.getSkillType().equals(skill) ){
                return skillLevel;
            }
        }
        return null;
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
    public SkillLevels getSkillLevelValue(Skill skill) {
        return getSkillLevel(skill).getLevel();
    }

    // Check if a skill is at max level
    public boolean isSkillMaxLevel(Skill skill) {
        return getSkillLevel(skill).getLevel().getIntLevel() >= 3;
    }

    // Get a formatted string with all skill levels
    // public String getSkillLevelsString() {
    //     StringBuilder sb = new StringBuilder("Skill Levels:\n");
    //     for (Map.Entry<Skill, SkillLevel> entry : skillLevels.entrySet()) {
    //         sb.append(entry.getValue().toString()).append("\n");
    //     }
    //     return sb.toString();
    // }

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
            // TODO
//            for (Map.Entry<Item, Integer> entry : oldItems) {
//                newBackpack.CheatAddToInventory(entry.getKey(), entry.getValue());
//            }
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
        return backpack != null && (backpack.hasItem(item) != 0);
    }

    // Method to get quantity of a specific item
    public int getItemQuantity(Item item) {
        //return backpack != null ? backpack.getItemQuantity(item) : 0;
        // TODO
        return -1;
    }

    public Iterable<? extends Gift> getGift() {
        return null;
    }


    public Inventory getRefrigerator() {
        return refrigerator;
    }
}
