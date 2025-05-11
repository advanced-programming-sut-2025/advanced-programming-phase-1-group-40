package org.example.models;

import org.example.models.enums.types.*;

import java.util.ArrayList;

import java.util.*;

public class NPC {
    private  String name;
    private  NPCType type;
    private  Position position;
    private  Role role;
    private  ArrayList<String> dialog;
    private  HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>> quests;
    private  ArrayList<Item> favorites;
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
    /*public NPC(NPCType type) {
        this.type = type;
        this.name = type.getName();
        this.role = type.getRole();
        this.dialog = new ArrayList<>();
        this.quests = type.getQuests();
        this.favorites = type.getFavorites();
        this.position = new Position(0, 0);
    }*/



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
