package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum FishingRodType implements Item{

    TRAINING_ROD(0.1,"Training Rod",25,0,
            new ArrayList<FishType>(List.of(FishType.SARDINE,FishType.PERCH,FishType.HERRING,FishType.SUNFISH)),8),
    BAMBOO_POLE(0.5,"Bamboo Pole",500,0,new ArrayList<>(Arrays.asList(FishType.values())),8),
    FIBERGLASS_ROD(0.9,"Fiberglass Rod",1800,1,new ArrayList<>(Arrays.asList(FishType.values())),6),
    IRIDIUM(1.2,"Iridium Rod",7500,3,new ArrayList<>(Arrays.asList(FishType.values())),4);

    private final double poleCoefficient;
    private final String poleName;
    private final int price;
    private final Integer minimumSkillLevel;
    private final ArrayList<FishType> fishTypes;
    private final Integer energyCost;

    FishingRodType(double poleCoefficient, String poleName, int price, Integer minimumSkillLevel, ArrayList<FishType> fishTypes, Integer energyCost) {

        this.poleCoefficient = poleCoefficient;
        this.poleName = poleName;
        this.price = price;
        this.minimumSkillLevel = minimumSkillLevel;
        this.fishTypes = fishTypes;
        this.energyCost = energyCost;

    }

    public double getPoleCoefficient() {
        return poleCoefficient;
    }

    public String getPoleName() {
        return poleName;
    }

    public int getPrice() {
        return price;
    }

    public Integer getMinimumSkillLevel() {
        return minimumSkillLevel;
    }

    public ArrayList<FishType> getFishTypes() {
        return fishTypes;
    }

    public Integer getEnergyCost() {
        return energyCost;
    }


    @Override
    public String getItemName() {
        return "";
    }


}

