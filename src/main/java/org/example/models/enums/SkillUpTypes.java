package org.example.models.enums;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;



public enum SkillUpTypes {

    FARMING(5),
    EXTRACTING(10),
    EXPLORING_NATURE(10),
    FISHING(5);

    private int increaseValue;

    SkillUpTypes(int increaseValue) {
        this.increaseValue = increaseValue;
    }

    public int getIncreaseValue() {
        return increaseValue;
    }

}
