package org.example.models.enums;


public enum SkillLevels {
    LEVEL_ZERO(0),
    LEVEL_ONE(1),
    LEVEL_TWO(2),
    LEVEL_THREE(3);

    private final Integer level;

    SkillLevels(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

}
