package org.example.models.enums.types;


import org.example.models.Item;
import org.example.models.enums.enviroment.Season;

public enum ForagingCropType implements Item {



    COMMON_MUSHROOM("Common Mushroom",Season.SPECIAL, 40, 38),
    DAFFODIL("Daffodil",Season.SPRING, 30, 0),
    DANDELION("Dandelion",Season.SPRING, 40, 25),
    LEEK("Leek",Season.SPRING, 60, 40),
    MOREL("Morel",Season.SPRING, 150, 20),
    SALMONBERRY("Salmonberry",Season.SPRING, 5, 25),
    SPRING_ONION("Spring Onion",Season.SPRING, 8, 13),
    WILD_HORSERADISH("Wild Horseradish",Season.SPRING, 50, 13),
    FIDDLEHEAD_FERN("Fiddlehead Fern",Season.SUMMER, 90, 25),
    GRAPE("Grape",Season.SUMMER, 80, 38),
    RED_MUSHROOM("Red Mushroom",Season.SUMMER, 75, -50),
    SPICE_BERRY("Spice Berry",Season.SUMMER, 80, 25),
    SWEET_PEA("Sweet Pea",Season.SUMMER, 50, 0),
    BLACKBERRY("Blackberry",Season.FALL, 25, 25),
    CHANTERELLE("Chanterelle",Season.FALL, 160, 75),
    HAZELNUT("Hazelnut",Season.FALL, 40, 38),
    PURPLE_MUSHROOM("Purple Mushroom",Season.FALL, 90, 30),
    WILD_PLUM("Wild Plum",Season.FALL, 80, 25),
    CROCUS("Crocus",Season.WINTER, 60, 0),
    CRYSTAL_FRUIT("Crystal Fruit",Season.WINTER, 150, 63),
    HOLLY("Holly",Season.WINTER, 80, -37),
    SNOW_YAM("Snow Yam",Season.WINTER, 100, 30),
    WINTER_ROOT("Winter Root",Season.WINTER, 70, 25);

    private final String name;
    private final Season availabeSeason;
    private final int price;
    private final int energy;

    ForagingCropType(String name,Season availabeSeason, int price, int energy) {
        this.name = name;
        this.availabeSeason = availabeSeason;
        this.price = price;
        this.energy = energy;
    }

    public Season getAvailabeSeason() {
        return availabeSeason;
    }

    public int getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }


    public String getName() {
        return name;
    }


}

