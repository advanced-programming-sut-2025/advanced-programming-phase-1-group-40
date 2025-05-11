package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum FruitType implements Edible{

    APRICOT("Apricot",59,38),
    CHERRY("Cherry",80,38),
    BANANA("Banana",150,75),
    MANGO("Mango",130,100),
    ORANGE("Orange",100,38),
    PEACH("Peach",140,38),
    APPLE("Apple",100,38),
    POMEGRANATE("Pomegranate",140,38),
    OAK_RESIN("Oak Resin",150,0),
    MAPLE_SYRUP("Maple Syrup",200,0),
    PINE_TAR("Pine Tar",100,0),
    SAP("Sap",2,-2),
    COMMON_MUSHROOM("Common Mushroom",40,38),
    MYSTIC_SYRUP("Mystic Syrup",1000,500);

    private String name;
    private int baseSellPrice;
    private int energy;

    FruitType(String name, int baseSellPrice, int energy) {
        this.name = name;
        this.baseSellPrice = baseSellPrice;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public int getEnergy() {
        return energy;
    }


}
