package org.example.models.enums.enviroment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Weather {

    SUNNY(1.5,1,new ArrayList<>(List.of(Season.SPRING,Season.SUMMER,Season.FALL,Season.WINTER))),
    RAINY(1.2,1.5,new ArrayList<>(List.of(Season.SPRING,Season.SUMMER,Season.FALL))),
    STORMY(0.5,1,new ArrayList<>(List.of(Season.SPRING,Season.SUMMER,Season.FALL))),
    SNOWY(0.5,2,new ArrayList<>(List.of(Season.WINTER)));

    private final double weatherCoEfficient;
    private final double toolEnergyCostMultiplier;
    private final ArrayList<Season> possibleSeasons;

    Weather(double weatherCoEfficient, double toolEnergyCostMultiplier, ArrayList<Season> possibleSeasons) {

        this.weatherCoEfficient = weatherCoEfficient;
        this.toolEnergyCostMultiplier = toolEnergyCostMultiplier;
        this.possibleSeasons = possibleSeasons;

    }

    public double getWeatherCoEfficient() {
        return weatherCoEfficient;
    }

    public double getToolEnergyCostMultiplier() {
        return toolEnergyCostMultiplier;
    }

    public ArrayList<Season> getPossibleSeasons() {
        return possibleSeasons;
    }


}
