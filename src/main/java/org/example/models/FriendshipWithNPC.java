package org.example.models;

import org.example.models.enums.*;

public class FriendshipWithNPC {

    /*
    private Player friend1;
    private NPC friend2;
    private FriendshipLevel level;
    private int currentXP;
    private final int maxXP = 799;

    public FriendshipWithNPC(Player friend1, NPC friend2, FriendshipLevel level, int currentXP, int maxXP) {
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

    public FriendshipLevel getIntLevel() {
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


    private Integer friendshipXP;
    private FriendshipLevel friendshipLevel;


    public FriendshipWithNPC(Integer friendshipXP, FriendshipLevel friendshipLevel) {
        this.friendshipXP = friendshipXP;
        this.friendshipLevel = friendshipLevel;
    }


    public Integer getFriendshipXP() {
        return friendshipXP;
    }

    public void setFriendshipXP(Integer friendshipXP) {
        this.friendshipXP = friendshipXP;
    }

    public FriendshipLevel getFriendshipLevel() {
        return friendshipLevel;
    }

    public void setFriendshipLevel(FriendshipLevel friendshipLevel) {
        this.friendshipLevel = friendshipLevel;
    }


}
