package org.example.models;

import org.example.models.enums.*;

public class Friendship {
    private Player friend1;
    private NPC friend2;
    private FriendshipLevel level;
    private int currentXP;
    private int maxXP;

    public Friendship(Player friend1, NPC friend2, FriendshipLevel level, int currentXP, int maxXP) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.level = level;
        this.currentXP = currentXP;
        this.maxXP = maxXP;
    }

    public Player getFriend1() {
        return friend1;
    }

    public NPC getFriend2() {
        return friend2;
    }

    public FriendshipLevel getLevel() {
        return level;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public void increaseXP(int amount) {
        // TODO
    }

    public void decreaseXP(int amount) {
        // TODO
    }

    public int requiredXPForNextLevel() {
        // TODO:
        return 0;
    }

    public boolean isMaxLevel() {
        // TODO
        return false;
    }
}
