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
    private  ArrayList<Item> favorites;
    private  HashMap<User, Boolean> hasBeenGiftedToday;
    private  HashMap<User, Integer> friendships;

    public NPC(HashMap<Human, FriendshipWithNPC> friendshipLevel, NPCType type) {

        super(friendshipLevel);
        this.type = type;
        this.name = type.getName();
        this.position = new Position(0,0); // TODO
        this.dialog = type.getDialog();
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

    public ArrayList<Item> getFavorites() {
        return favorites;
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

        if (this.friendships.get(player) == null ) {
            return 0;
        }

        return this.friendships.get(player);

    }
}
