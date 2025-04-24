package models.enums;

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
