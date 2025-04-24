package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum StoneType {

    QUARTZ(25),
    EARTH_CRYSTAL(50),
    FROZEN_TEAR(75),
    FIRE_QUARTZ(100),
    EMERALD(250),
    AQUAMARINE(180),
    RUBY(250),
    AMETHYST(100),
    TOPAZ(80),
    JADE(200),
    DIAMOND(750),
    PRISMATIC_SHARD(2000),
    COPPER(5),
    IRON(10),
    GOLD(25),
    IRIDIUM(100),
    COAL(15);

    private final int sellPrice;

    StoneType(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
