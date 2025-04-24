package org.example.models.enums.types;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum CropType {
    BLUE_JAZZ(false),
    CARROT(false),
    CAULIFLOWER(false),
    COFFEE_BEAN(false),
    GARLIC(false),
    GREEN_BEAN(false),
    KALE(false),
    PARSNIP(false),
    POTATO(false),
    RHUBARB(false),
    STRAWBERRY(false),
    TULIP(false),
    UNMILLED_RICE(false),
    BLUEBERRY(false),
    CORN(false),
    HOPS(false),
    HOT_PEPPER(false),
    MELON(false),
    POPPY(false),
    RADISH(false),
    RED_CABBAGE(false),
    STARFRUIT(false),
    SUMMER_SPANGLE(false),
    SUMMER_SQUASH(false),
    SUNFLOWER(false),
    TOMATO(false),
    WHEAT(false),
    AMARANTH(false),
    ARTICHOKE(false),
    BEET(false),
    BOK_CHOY(false),
    BROCCOLI(false),
    CRANBERRIES(false),
    EGGPLANT(false),
    FAIRY_ROSE(false),
    PUMPKIN(false),
    YAM(false),
    SWEET_GEM_BERRY(false),
    POWDERMELON(false),
    ANCIENT_FRUIT(false),
    COMMON_MUSHROOM(true),
    DAFFODIL(true),
    DANDELION(true),
    LEEK(true),
    MOREL(true),
    SALMONBERRY(true),
    SPRING_ONION(true),
    WILD_HORSERADISH(true),
    FIDDLEHEAD_FERN(true),
    GRAPE(null),
    RED_MUSHROOM(true),
    SPICE_BERRY(true),
    SWEET_PEA(true),
    BLACKBERRY(true),
    CHANTERELLE(true),
    HAZELNUT(true),
    PURPLE_MUSHROOM(true),
    WILD_PLUM(true),
    CROCUS(true),
    CRYSTAL_FRUIT(true),
    HOLLY(true),
    SNOW_YAM(true),
    WINTER_ROOT(true);


    private final boolean isForaging;

    CropType(Boolean isForaging) {
        this.isForaging = isForaging;

    }
}

