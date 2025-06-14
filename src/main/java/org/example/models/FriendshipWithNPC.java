package org.example.models;

import org.example.models.enums.*;

public class FriendshipWithNPC {

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
