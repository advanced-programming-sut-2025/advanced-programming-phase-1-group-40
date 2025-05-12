package org.example.models;

import org.example.models.enums.*;

public class Friendship {
    /*
    private Player friend1;
    private NPC friend2;
    private FriendshipLevel level;
    private int currentXP;
    private final int maxXP = 799;

    public Friendship(Player friend1, NPC friend2, FriendshipLevel level, int currentXP, int maxXP) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.level = level;
        this.currentXP = currentXP;
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
        currentXP = Math.min(currentXP + amount, maxXP);
        updateLevel();
    }
    public void decreaseXP(int amount) {
        currentXP = Math.max(currentXP - amount, 0);
        updateLevel();
    }
    private void updateLevel(){
        int newLevel = currentXP/200;
        this.level = FriendshipLevel.fromInt(newLevel);
    }
    public int requiredXPForNextLevel() {
        int nextLevelXp = (level.ordinal()+1)/200;
        return Math.min(nextLevelXp, maxXP) - currentXP;
    }
    public Boolean isMaxLevel(){
        return currentXP > maxXP;
    }
     */

    private Integer friendShipXP;
    private FriendshipLevel friendshipLevel;

    public Friendship(Integer friendShipXP, FriendshipLevel friendshipLevel) {
        this.friendShipXP = friendShipXP;
        this.friendshipLevel = friendshipLevel;
    }

    public Integer getFriendShipXP() {
        return friendShipXP;
    }

    public void setFriendShipXP(Integer friendShipXP) {
        this.friendShipXP = friendShipXP;
    }

    public FriendshipLevel getFriendshipLevel() {
        return friendshipLevel;
    }

    public void setFriendshipLevel(FriendshipLevel friendshipLevel) {
        this.friendshipLevel = friendshipLevel;
    }


}
