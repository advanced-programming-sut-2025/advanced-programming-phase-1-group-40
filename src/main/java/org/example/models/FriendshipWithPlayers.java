package org.example.models;

import org.example.models.enums.FriendshipLevel;

public class FriendshipWithPlayers {

    private Player targetPlayer;
    private Integer friendshipXP;
    private FriendshipLevel friendshipLevel;
    private boolean interaction;


    public FriendshipWithPlayers(Player targetPlayer, Integer friendshipXP, FriendshipLevel friendshipLevel) {
        this.targetPlayer = targetPlayer;
        this.friendshipXP = friendshipXP;
        this.friendshipLevel = friendshipLevel;
        this.interaction = false;
    }

    public boolean hadInteraction() {
        return interaction;
    }

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public void setTargetPlayer(Player targetPlayer) {
        this.targetPlayer = targetPlayer;
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
