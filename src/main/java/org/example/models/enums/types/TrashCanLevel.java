package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum TrashCanLevel {
    BASIC(0), COPPER(15), IRON(30), GOLD(45), IRIDIUM(60);

    int level;

    TrashCanLevel(int x) {
        this.level = level;
    }
}
