package org.example.models;

import org.example.models.enums.types.Gender;

import java.util.HashMap;

public class Human {


    private HashMap<Human, FriendshipWithNPC> friendshipLevel = new HashMap<>();

    public Human(HashMap<Human, FriendshipWithNPC> friendshipLevel) {
        this.friendshipLevel = friendshipLevel;
    }

    public HashMap<Human, FriendshipWithNPC> getFriendshipLevel() {
        return friendshipLevel;
    }

    public void setFriendshipLevel(Human ) {
        this.friendshipLevel = friendshipLevel;
    }


}
