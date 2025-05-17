package org.example.models;

import org.example.models.enums.types.*;

import java.util.ArrayList;

import java.util.*;

public class NPC extends Human {

    private  String name;
    private  NPCType type;
    private  Position position;
    private  Role role;
    private  HashMap<String, Situation> dialog;
    private  HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>> quests;
    private  ArrayList<Item> favorites;
    private  HashMap<User, Boolean> hasBeenGiftedToday;
    private  HashMap<User, Integer> friendships;

    public NPC(HashMap<Human, FriendshipWithNPC> friendshipLevel, NPCType type) {

        super(friendshipLevel);
        this.type = type;
        this.name = type.getName();
        this.position = new Position(0,0); // TODO
        this.dialog = type.getDialog();
        this.quests = type.getQuests();
        this.friendships = new HashMap<>();
        this.hasBeenGiftedToday = new HashMap<>();

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

    public HashMap<String, Situation> getDialog() {
        return dialog;
    }


    public HashMap<HashMap<Item, Integer>, HashMap<Item, Integer>> getQuests() {
        return quests;
    }

    public ArrayList<Item> getFavorites() {
        return favorites;
    }


    public void viewQuests() {
        for (Map.Entry<HashMap<Item, Integer>, HashMap<Item, Integer>> quest : quests.entrySet()) {
            System.out.println("Request: " + quest.getKey());
            System.out.println("Reward: " + quest.getValue());
        }
    }

    public void increaseFriendshipXP(Player player, int xp) {

        Integer previousXP = friendships.get(player);

        if ( previousXP == null ) {

            previousXP = 0;

        }

        this.friendships.put(player, previousXP + xp);

        System.out.println("Increased " + player.getUsername() + "'s friendship with " + this.name + " XP by " + xp);

    }

    public boolean hasBeenGiftedTody(Player player) {

        if ( this.hasBeenGiftedToday.get(player) == null ) {

            this.hasBeenGiftedToday.put(player, false);

        }

        return this.hasBeenGiftedToday.get(player);

    }

    public void setHasBeenGiftedToday(Player player, boolean value) {

        this.hasBeenGiftedToday.put(player, value);

    }

    public int getFriendshipXP(Player player) {
        return this.friendships.get(player);
    }
}
