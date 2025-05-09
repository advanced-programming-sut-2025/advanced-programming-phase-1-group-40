package org.example.models.enums;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;



public enum SkillLevels {
    LEVEL_ZERO(0),
    LEVEL_ONE(1),
    LEVEL_TWO(2),
    LEVEL_THREE(3);

    private final int levelCoEfficient;

    SkillLevels(int levelCoEfficient) {

        this.levelCoEfficient = levelCoEfficient;

    }

    public int getLevelCoEfficient() {
        return levelCoEfficient;
    }
}
