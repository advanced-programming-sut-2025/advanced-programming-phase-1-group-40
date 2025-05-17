package org.example.models;

import org.example.models.*;
import org.example.models.Map.MapComponents;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public class FarmBuilding extends MapComponents implements Item{

    private final FarmBuildingType farmBuildingType;
    private final String description;

    private final int woodCount;
    private final int stoneCount;
    private final int cost;

    public FarmBuilding(FarmBuildingType farmBuildingType, Position positionOfUpperLeftCorner) {

        super(positionOfUpperLeftCorner,farmBuildingType.getWidth(),farmBuildingType.getLength());
        this.farmBuildingType = farmBuildingType;
        this.description = farmBuildingType.getDescription();

        this.woodCount = farmBuildingType.getWoodCount();
        this.stoneCount = farmBuildingType.getStoneCount();
        this.cost = farmBuildingType.getCost();

    }


    public FarmBuildingType getFarmBuildingType() {
        return farmBuildingType;
    }

    public String getDescription() {
        return description;
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

    @Override
    public String getItemName() {
        return "Farm Building";
    }


    @Override
    public void update() {

    }

}
