package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum InteractionType {
    TALK(20),
    TRADE(50),
    GIFT(0), // TODO: XP depends on gift
    HUG(60),
    GIVE_FLOWER(100),
    MARRIAGE_REQUEST(500);

    int XP;

    InteractionType(int XP) {
        this.XP = XP;
    }
}
