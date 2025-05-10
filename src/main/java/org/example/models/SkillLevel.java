package org.example.models;

import org.example.models.enums.Skill;

public class SkillLevel {

    private int currentXP;
    private int level;
    private Skill skillType;

    // Constants for XP calculation
    private static final int BASE_XP_FOR_LEVEL_UP = 50;
    private static final int XP_MULTIPLIER = 100;

    public SkillLevel(Skill skillType) {
        this.skillType = skillType;
        this.currentXP = 0;
        this.level = 0;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getLevel() {
        return level;
    }

    public Skill getSkillType() {
        return skillType;
    }

    public int getXPForNextLevel() {
        return XP_MULTIPLIER * (level + 1) + BASE_XP_FOR_LEVEL_UP;
    }

    public boolean addXP(int xpAmount) {
        boolean leveledUp = false;

        currentXP += xpAmount;

        while (currentXP >= getXPForNextLevel() && level < 3) { // Max level is 3
            currentXP -= getXPForNextLevel();
            level++;
            leveledUp = true;
        }

        if (level >= 3) {
            currentXP = Math.min(currentXP, getXPForNextLevel() - 1);
        }

        return leveledUp;
    }

    public int getRemainingXPForNextLevel() {
        if (level >= 3) { // Max level
            return 0;
        }
        return getXPForNextLevel() - currentXP;
    }

    public int getLevelProgressPercentage() {
        if (level >= 3) { // Max level
            return 100;
        }

        int xpForNextLevel = getXPForNextLevel();
        return (int) (((double) currentXP / xpForNextLevel) * 100);
    }

    @Override
    public String toString() {
        if (level >= 3) {
            return skillType + " - Level " + level + " (MAX)";
        }
        return skillType + " - Level " + level + " (" + currentXP + "/" + getXPForNextLevel() + " XP)";
    }
}
