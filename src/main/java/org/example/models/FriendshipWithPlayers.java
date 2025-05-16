package org.example.models;

import org.example.models.enums.FriendshipLevel;

public class FriendshipWithPlayers {

    private Player targetPlayer;
    private Integer friendshipXP;
    private FriendshipLevel friendshipLevel;
    private boolean interaction;
    private boolean talk;
    private boolean trade;
    private boolean gift;
    private boolean hug;
    private boolean flower;


    public FriendshipWithPlayers(Player targetPlayer, Integer friendshipXP, FriendshipLevel friendshipLevel) {
        this.targetPlayer = targetPlayer;
        this.friendshipXP = friendshipXP;
        this.friendshipLevel = friendshipLevel;
        this.interaction = false;
        this.talk = false;
        this.trade = false;
        this.gift = false;
        this.hug = false;
        this.flower = false;
    }

    public boolean isFlower() {
        return flower;
    }

    public void setFlower(boolean flower) {
        this.flower = flower;
    }

    public boolean isHug() {
        return hug;
    }

    public void setHug(boolean hug) {
        this.hug = hug;
    }

    public boolean isGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public boolean isTrade() {
        return trade;
    }

    public void setTrade(boolean trade) {
        this.trade = trade;
    }

    public boolean isTalk() {
        return talk;
    }

    public void setTalk(boolean talk) {
        this.talk = talk;
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
