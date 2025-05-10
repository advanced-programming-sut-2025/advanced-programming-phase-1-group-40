package org.example.models.enums;


public enum SkillLevels {

    LEVEL_ZERO(0),
    LEVEL_ONE(1),
    LEVEL_TWO(2),
    LEVEL_THREE(3);


    private final int level;

    SkillLevels(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
