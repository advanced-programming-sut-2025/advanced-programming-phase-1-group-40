package org.example.models.enums.types;


import org.example.models.Item;

public enum AnimalProductType implements Item {


    EGG(50,"Egg"),
    LARGE_EGG(95,"Large Egg"),
    DUCK_EGG(95,"Duck Egg"),
    DUCK_FEATHER(250,"Duck Feather"),
    RABBIT_WOOL(340,"Rabbit wool"),
    RABBIT_LEG(565,"Rabbit leg"),
    DINOSAUR_EGG(350,"Dinosaur Egg"),
    COW_MILK(125,"Cow Milk"),
    LARGE_COW_MILK(190,"Large Cow Milk"),
    GOAT_MILK(225,"Goat Milk"),
    LARGE_GOAT_MILK(345,"Large Goat Milk"),
    WOOL(340,"Wool"),
    TRUFFLE(625,"Truffle");


    private final int price;
    private final String displayName;

    AnimalProductType(int price, String displayName) {
        this.price = price;
        this.displayName = displayName;
    }

    public int getPrice() {
        return price;
    }

    public String getDisplayName() {
        return displayName;
    }


    @Override
    public String getItemName() {
        return this.displayName;
    }


}
