package org.example.models.enums.types;


public enum AnimalProducts {


    EGG(50),
    LARGE_EGG(95),
    DUCK_EGG(95),
    DUCK_FEATHER(250),
    RABBIT_WOOL(340),
    RABBIT_LEG(565),
    DINOSAUR_EGG(350),
    COW_MILK(125),
    LARGE_COW_MILK(190),
    GOAT_MILK(225),
    LARGE_GOAT_MILK(345),
    WOOL(340),
    TRUFFLE(625);


    private final int price;

    AnimalProducts(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
