package org.example.models.enums.types;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum FarmBuildingType {


    BARN(   "Houses 4 barn-dwelling animals.",7, 4, 350,150, 6000,1),
    BIG_BARN("Houses 8 barn-dwelling animals. Unlocks goats.",7, 4, 450, 200, 12000,1),
    DELUXE_BARN("Houses 12 barn-dwelling animals. Unlocks sheep and pigs.",7, 4, 550, 300, 25000,1),
    COOP("Houses 4 coop-dwelling animals.",6, 3, 300, 100, 4000,1),
    BIG_COOP("Houses 8 coop-dwelling animals. Unlocks ducks.",6, 3, 400, 150, 10000,1),
    DELUXE_COOP("Houses 12 coop-dwelling animals. Unlocks rabbits.",6, 3, 500, 200, 20000,1),
    WELL("Provides a place for you to refill your watering can.",3, 3, 0, 75, 1000,1),
    SHIPPING_BIN("Items placed in it will be included in the nightly shipment.",1, 1, 150, 0, 250,Integer.MAX_VALUE);

    private String description;

    private final int width;
    private final int length;


    private final int woodCount;
    private final int stoneCount;

    private final int cost;

    private final int dailyLimit;

    FarmBuildingType(String description,int width, int length, int woodCost, int stoneCost, int cost,int dailyLimit) {
        this.description = description;
        this.width = width;
        this.length = length;
        this.woodCount = woodCost;
        this.stoneCount = stoneCost;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
    }

    public String getDescription() {
        return description;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getWoodCount() {
        return woodCount;
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public int getCost() {
        return cost;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }


}
