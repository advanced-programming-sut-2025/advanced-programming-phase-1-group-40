package org.example.models;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
public class Interaction {

    InteractionType type;
    int XPEffect;

    public Interaction(InteractionType type, int XPEffect) {
        this.type = type;
        this.XPEffect = XPEffect;
    }

    public InteractionType getType() {
        return type;
    }

    public int getXPEffect() {
        return XPEffect;
    }

}
