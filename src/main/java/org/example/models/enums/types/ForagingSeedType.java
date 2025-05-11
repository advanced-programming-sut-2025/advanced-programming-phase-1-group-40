package org.example.models.enums.types;

import org.example.models.enums.enviroment.Season;

public enum ForagingSeedType {

    JAZZ_SEEDS("Jazz Seeds", Season.SPRING),
    CARROT_SEEDS("Carrot Seeds",Season.SPRING),
    CAULIFLOWER_SEEDS("Cauliflower Seeds",Season.SPRING),
    COFFEE_BEAN("Coffee Bean",Season.SPRING),
    GARLIC_SEEDS("Garlic Seeds",Season.SPRING),
    BEAN_STARTER("Bean Starter",Season.SPRING),
    KALE_SEEDS("Kale Seeds",Season.SPRING),
    PARSNIP_SEEDS("Parsnip Seeds",Season.SPRING),
    POTATO_SEEDS("Potato Seeds",Season.SPRING),
    RHUBARB_SEEDS("Rhubarb Seeds",Season.SPRING),
    STRAWBERRY_SEEDS("Strawberry Seeds",Season.SPRING),
    TULIP_BULB("Tulip Bulb",Season.SPRING),
    RICE_SHOOT("Rice Shoot",Season.SPRING),
    BLUEBERRY_SEEDS("Blueberry Seeds",Season.SPRING),
    CORN_SEEDS("Corn Seeds",Season.SPRING),
    HOPS_STARTER("Hops Starter",Season.SPRING),
    PEPPER_SEEDS("Pepper Seeds",Season.SPRING),
    MELON_SEEDS("Melon Seeds",Season.SPRING),
    POPPY_SEEDS("Poppy Seeds",Season.SPRING),
    RADISH_SEEDS("Radish Seeds",Season.SPRING),
    RED_CABBAGE_SEEDS("Red Cabbage Seeds",Season.SPRING),
    STARFRUIT_SEEDS("Starfruit Seeds",Season.SPRING),
    SPANGLE_SEEDS("Spangle Seeds",Season.SPRING),
    SUMMER_SQUASH_SEEDS("Summer Squash Seeds",Season.SPRING),
    SUNFLOWER_SEEDS("Sunflower Seeds",Season.SPRING),
    TOMATO_SEEDS("Tomato Seeds",Season.SPRING),
    WHEAT_SEEDS("Wheat Seeds",Season.SPRING),
    AMARANTH_SEEDS("Amaranth Seeds",Season.SPRING),
    ARTICHOKE_SEEDS("Artichoke Seeds",Season.SPRING),
    BEET_SEEDS("Beet Seeds",Season.SPRING),
    BOK_CHOY_SEEDS("Bok Choy Seeds",Season.SPRING),
    BROCCOLI_SEEDS("Broccoli Seeds",Season.SPRING),
    CRANBERRY_SEEDS("Cranberry Seeds",Season.SPRING),
    EGGPLANT_SEEDS("Eggplant Seeds",Season.SPRING),
    FAIRY_SEEDS("Fairy Seeds",Season.SPRING),
    GRAPE_STARTER("Grape Starter",Season.SPRING),
    PUMPKIN_SEEDS("Pumpkin Seeds",Season.SPRING),
    YAM_SEEDS("Yam Seeds",Season.SPRING),
    RARE_SEED("Rare Seed",Season.SPRING),
    POWDERMELON_SEEDS("Powdermelon Seeds",Season.SPRING),
    ANCIENT_SEEDS("Ancient Seeds",Season.SPECIAL),
    MIXED_SEEDS("Mixed Seeds",Season.SPECIAL);

    private final String name;
    private final Season availableSeason;

    ForagingSeedType(String name, Season availableSeason) {
        this.name = name;
        this.availableSeason = availableSeason;
    }

}
