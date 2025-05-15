package org.example.models;

import org.example.models.enums.types.*;

import java.util.ArrayList;

import java.util.*;

public class NPC extends Human {

    private  String name;
    private  NPCType type;
    private  Position position;
    private  Role role;
    private  ArrayList<String> dialog;
    private  HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>> quests;
    private  ArrayList<Item> favorites;

    public NPC(HashMap<Human, FriendshipWithNPC> friendshipLevel, NPCType type) {

        super(friendshipLevel);
        this.type = type;

        this.dialog = new ArrayList<>();
        this.dialog.add("Hello there! Another beautiful day in the valley.");
        this.dialog.add("Have you checked the crops today? They’re looking fantastic.");
        this.dialog.add("I heard strange noises near the mines last night… Be careful.");
        this.dialog.add("Summer’s here! Perfect weather for fishing.");
        this.dialog.add("The town festival is coming up soon—I can’t wait!");
        this.dialog.add("It’s been a long day… I think I’ll relax by the lake.");
        this.dialog.add("Winter chills my bones. A warm cup of tea is all I need.");
        this.dialog.add("Fall colors are breathtaking, don’t you think?");
        this.dialog.add("You know, I always dreamt of being a famous musician. Life had other plans.");
        this.dialog.add("Rainy days make me nostalgic… Something about the sound of raindrops.");
        this.dialog.add("I found something interesting in the forest yesterday. Want to take a look?");
        this.dialog.add("The fortune teller said today is a lucky day! Maybe I should go mining.");

    }

    public String getName() {
        return name;
    }

    public NPCType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public Role getRole() {
        return role;
    }

    public ArrayList<String> getDialog() {
        return dialog;
    }




    public HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>> getQuests() {
        return quests;
    }

    public ArrayList<Item> getFavorites() {
        return favorites;
    }

    public void addDialog(String sentence) {
        this.dialog.add(sentence);
    }

    /*public void giveGift(Item item) {
        if (favorites.contains(item)) {
            increaseFriendshipXP(200);
        }
    }*/

    public void viewQuests() {
        for (Map.Entry<HashMap<Item, Integer>, HashMap<Item, Integer>> quest : quests.entrySet()) {
            System.out.println("Request: " + quest.getKey());
            System.out.println("Reward: " + quest.getValue());
        }
    }

    private void increaseFriendshipXP(int xp) {
        System.out.println("Increased friendship XP by " + xp);
    }
}
