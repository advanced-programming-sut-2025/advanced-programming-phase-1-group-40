package org.example.models.enums.types;

import java.time.LocalTime;


public enum ShopType {

    BLACKSMITH("Clint",LocalTime.of(9,0),LocalTime.of(16,0)),
    JOJAMART("Morris",LocalTime.of(9,0),LocalTime.of(23,0)),
    PIERRE_GENERAL_STORE("Pierre",LocalTime.of(9,0),LocalTime.of(17,0)),
    CARPENTER_SHOP("Robin",LocalTime.of(9,0),LocalTime.of(20,0)),
    FISH_SHOP("Willy",LocalTime.of(9,0),LocalTime.of(17,0)),
    MARNIES_RANCH("Marnie",LocalTime.of(9,0),LocalTime.of(16,0)),
    THE_STARDROP_SALOON("Gus",LocalTime.of(12,0),LocalTime.of(24,0));

    private final String ownerName;
    private final LocalTime openingHour;
    private final LocalTime closingHour;

    ShopType(String ownerName, LocalTime openingHour, LocalTime closingHour) {
        this.ownerName = ownerName;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

}
