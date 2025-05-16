package org.example.models.enums;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum FriendshipLevel {

    STRANGER("Stranger",0),
    FRIEND("Friend",1),
    CLOSE_FRIEND("Close friend",2),
    BEST_FRIEND("Best friend",3),
    MARRIED("Married",4);

    private final int level;
    private final String displayName;

    FriendshipLevel(String displayName,int level) {
        this.level = level;
        this.displayName = displayName;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
    }

}

