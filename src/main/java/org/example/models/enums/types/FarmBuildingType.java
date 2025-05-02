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


    BARN(   7, 4, 350,150, 6000,1),
    BIG_BARN(7, 4, 450, 200, 12000,1),
    DELUXE_BARN(7, 4, 550, 300, 25000,1),
    COOP(6, 3, 300, 100, 4000,1),
    BIG_COOP(6, 3, 400, 150, 10000,1),
    DELUXE_COOP(6, 3, 500, 200, 20000,1),
    WELL(3, 3, 0, 75, 1000,1),
    SHIPPING_BIN(1, 1, 150, 0, 250,Integer.MAX_VALUE);

    private final int width;
    private final int length;


    private final int woodCount;
    private final int stoneCount;

    private final int cost;

    private final int dailyLimit;

    FarmBuildingType(int width, int length, int woodCost, int stoneCost, int cost,int dailyLimit) {
        this.width = width;
        this.length = length;
        this.woodCount = woodCost;
        this.stoneCount = stoneCost;
        this.cost = cost;
        this.dailyLimit = dailyLimit;
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
