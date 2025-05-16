package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum IngredientType {
    //FOR COOKING


    EGG("Egg"),
    SARDINE("Sardine"),
    SALMON("Salmon"),
    WHEAT("Wheat"),
    LEEK("Leek"),
    DANDELION("Dandelion"),
    MILK("Milk"),
    PUMPKIN("Pumpkin"),
    WHEAT_FLOUR("Wheat Flour"),
    SUGAR("Sugar"),
    TOMATO("Tomato"),
    CHEESE("Cheese"),
    CORN("Corn"),
    OIL("Oil"),
    OMELET("Omelet"),
    BREAD("Bread"),
    HASH_BROWNS("Hash browns"),
    ANY_FISH("Any Fish"),
    RICE("Rice"),
    FIBER("Fiber"),
    COFFEE("Coffee"),
    POTATO("Potato"),
    BLUEBERRY("Blueberry"),
    MELON("Melon"),
    APRICOT("Apricot"),
    RED_CABBAGE("Red Cabbage"),
    RADISH("Radish"),
    AMARANTH("Amaranth"),
    KALE("Kale"),
    BEET("Beet"),
    PARSNIP("Parsnip"),
    CARROT("Carrot"),
    EGGPLANT("Eggplant"),
    FLOUNDER("Flounder"),
    MIDNIGHT_CARP("Midnight Carp"),

    //FOR CRAFTING


    COPPER_ORE("Copper Ore"),
    GOLD_ORE("Gold Ore"),
    COAL("Coal"),
    IRON_ORE("Iron Ore"),
    WOOD("Wood"),
    STONE("Stone"),
    COPPER_BAR("Copper Bar"),
    IRON_BAR("Iron Bar"),
    GOLD_BAR("Gold Bar"),
    IRIDIUM_BAR("Iridium Bar"),
    IRIDIUM_ORE("Iridium Ore"),
    ACORN("Acorn"),
    MAPLE_SEED("Maple Seed"),
    PINE_CONE("Pine Cone"),
    MAHOGANY_SEED("Mahogany Seed");


    private final String name;

    IngredientType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
