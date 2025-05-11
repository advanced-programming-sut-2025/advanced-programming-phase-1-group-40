package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public class FarmBuilding implements Item{
    private FarmBuildingType farmBuildingType;
    private Position positionOfUpperLeftCorner;
    private int width;
    private int length;
    private String description;
    private int woodCount;
    private int stoneCount;
    private int cost;

    public FarmBuilding(FarmBuildingType farmBuildingType, Position positionOfUpperLeftCorner) {
        this.farmBuildingType = farmBuildingType;
        this.positionOfUpperLeftCorner = positionOfUpperLeftCorner;
        this.width = farmBuildingType.getWidth();
        this.length = farmBuildingType.getLength();
        //this.description = farmBuildingType.getDescription();
    }

}
