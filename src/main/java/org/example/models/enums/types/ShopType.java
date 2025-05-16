package org.example.models.enums.types;

import java.time.LocalTime;


public enum ShopType {

    BLACKSMITH("Blacksmith", "Clint",LocalTime.of(9,0),LocalTime.of(16,0)),
    JOJAMART("Jojamart" , "Morris",LocalTime.of(9,0),LocalTime.of(23,0)),
    PIERRE_GENERAL_STORE("Pierre's General Store", "Pierre",LocalTime.of(9,0),LocalTime.of(17,0)),
    CARPENTER_SHOP("Carpenter's Shop","Robin",LocalTime.of(9,0),LocalTime.of(20,0)),
    FISH_SHOP("Fish Shop","Willy",LocalTime.of(9,0),LocalTime.of(17,0)),
    MARNIES_RANCH("Marnie's Ranch","Marnie",LocalTime.of(9,0),LocalTime.of(16,0)),
    THE_STARDROP_SALOON("The StarDrop Saloon","Gus",LocalTime.of(12,0),LocalTime.of(24,0));

    private final String name;
    private final String ownerName;
    private final LocalTime openingHour;
    private final LocalTime closingHour;

    ShopType(String name, String ownerName, LocalTime openingHour, LocalTime closingHour) {
        this.name = name;
        this.ownerName = ownerName;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }
}
