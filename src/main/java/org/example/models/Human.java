package org.example.models;

import java.util.HashMap;

public class Human {


    private HashMap<Human, FriendshipWithNPC> friendshipLevel = new HashMap<>();

    public Human(HashMap<Human, FriendshipWithNPC> friendshipLevel) {
        this.friendshipLevel = friendshipLevel;
    }

    public HashMap<Human, FriendshipWithNPC> getFriendshipLevel() {
        return friendshipLevel;
    }

    public void setFriendshipLevel(Human targerHuman, FriendshipWithNPC friendship) {
        this.friendshipLevel.put(targerHuman, friendship);
    }


}
