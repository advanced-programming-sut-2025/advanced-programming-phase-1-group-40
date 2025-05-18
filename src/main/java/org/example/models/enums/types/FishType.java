package org.example.models.enums.types;


import org.example.models.Item;
import org.example.models.enums.enviroment.*;


public enum FishType implements Item {

    SALMON("Salmon", 75, Season.FALL, false),
    SARDINE ("Sardine", 40, Season.FALL, false),
    SHAD ("Shad", 60, Season.FALL, false),
    BLUE_DISCUS ("Blue Discus", 120, Season.FALL, false),
    MIDNIGHT_CARP ("Midnight Carp", 150, Season.WINTER, false),
    SQUID ("Squid", 80, Season.WINTER, false),
    TUNA ("Tuna", 100, Season.WINTER, false),
    PERCH ("Perch", 55, Season.WINTER, false),
    FLOUNDER ("Flounder", 100, Season.SPRING, false),
    LIONFISH ("Lionfish", 100, Season.SPRING, false),
    HERRING ("Herring", 30, Season.SPRING, false),
    GHOST_FISH("Ghost fish", 45, Season.SPRING, false),
    TILAPIA ("Tilapia", 75, Season.SUMMER, false),
    DORADO ("Dorado", 100, Season.SUMMER, false),
    SUNFISH ("Sunfish", 30, Season.SUMMER, false),
    RAINBOW_TROUT ("Rainbow Trout", 65, Season.SUMMER, false),
    LEGEND ("Legend", 5000, Season.SPRING, true),
    GLACIER_FISH ("Glacier fish", 1000, Season.WINTER, true),
    ANGLER ("Angler", 900, Season.FALL, true),
    CRIMSON_FISH("Crimson fish", 1500, Season.SUMMER, true);


    String name;
    int basePrice;
    Season season;
    boolean isLegendary;

    FishType(String name, int basePrice, Season season, boolean isLegendary) {
        this.name = name;
        this.basePrice = basePrice;
        this.season = season;
        this.isLegendary = isLegendary;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Season getSeason() {
        return season;
    }

    public boolean isLegendary() {
        return isLegendary;
    }


    @Override
    public String getItemName() {
        return name;
    }
}
