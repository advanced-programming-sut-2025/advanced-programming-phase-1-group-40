package org.example.models.enums.types;

import org.example.models.Item;

public enum FlowerType implements Item {

///  TODO
//    BLUE_JAZZ("Blue jazz", false),
//    CROCUS("Crocus", true),
    //FAIRY_ROSE(),
    POPPY("Poppy", false),
    SUMMER_SPANGLE("Summer spangle", falpll se),
    SWEET_PEA("Sweet pea", true),
    SUNFLOWER("Sunflower", false),
    TULIP("Tulip", false);

    private final String name;
    private final Boolean isForaging;

    FlowerType(String name, Boolean isForaging) {
        this.name = name;
        this.isForaging = isForaging;
    }
    public String getName() {
        return name;
    }
    public static FlowerType getFlowerTypeByName(String name) {
        for (FlowerType flowerType : FlowerType.values()) {
            if (flowerType.getName().equals(name)) {
                return flowerType;
            }
        }
        return null;
    }





}
