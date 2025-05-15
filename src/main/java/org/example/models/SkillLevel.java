package org.example.models;

import org.example.models.enums.Skill;
import org.example.models.enums.SkillLevels;

public class SkillLevel {

    private int currentXP;
    private SkillLevels skillLevel;
    private Skill skillType;

    // Constants for XP calculation
    private static final int BASE_XP_FOR_LEVEL_UP = 50;
    private static final int XP_MULTIPLIER = 100;

    public SkillLevel(Skill skillType) {
        this.skillType = skillType;
        this.currentXP = 0;
        this.skillLevel = SkillLevels.LEVEL_THREE;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public SkillLevels getLevel() {
        return this.skillLevel;
    }

    public void setSkillLevel(SkillLevels skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Skill getSkillType() {
        return skillType;
    }

    public int getXPForNextLevel() {
        return XP_MULTIPLIER * (skillLevel.getIntLevel() + 1) + BASE_XP_FOR_LEVEL_UP;
    }

    public boolean addXP(int xpAmount) {
        boolean leveledUp = false;

        currentXP += xpAmount;

        while (currentXP >= getXPForNextLevel() && skillLevel.getIntLevel() < 3) { // Max level is 3
            currentXP -= getXPForNextLevel();
            setSkillLevel(SkillLevels.values()[skillLevel.getIntLevel()+1]);
            leveledUp = true;
        }

        if (skillLevel.getIntLevel() >= 3) {
            currentXP = Math.min(currentXP, getXPForNextLevel() - 1);
        }

        return leveledUp;
    }

    public int getRemainingXPForNextLevel() {
        if (skillLevel.getIntLevel() >= 3) { // Max level
            return 0;
        }
        return getXPForNextLevel() - currentXP;
    }

    public int getLevelProgressPercentage() {
        if (skillLevel.getIntLevel() >= 3) { // Max level
            return 100;
        }

        int xpForNextLevel = getXPForNextLevel();
        return (int) (((double) currentXP / xpForNextLevel) * 100);
    }

    @Override
    public String toString() {
        if (skillLevel.getIntLevel() >= 3) {
            return skillType + " - Level " + skillLevel.getIntLevel() + " (MAX)";
        }
        return skillType + " - Level " + skillLevel.getIntLevel() + " (" + currentXP + "/" + getXPForNextLevel() + " XP)";
    }
}
