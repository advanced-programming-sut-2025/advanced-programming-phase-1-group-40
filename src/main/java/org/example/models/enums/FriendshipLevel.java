package org.example.models.enums;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum FriendshipLevel {
    STRANGER(0),
    FRIEND(1),
    CLOSE_FRIEND(2),
    BEST_FRIEND(3),
    MARRIED(4);

    int level;

    FriendshipLevel(int level) {
        this.level = level;
    }
}
