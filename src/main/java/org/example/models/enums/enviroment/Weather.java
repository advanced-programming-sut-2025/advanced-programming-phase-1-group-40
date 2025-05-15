package org.example.models.enums.enviroment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Weather {

    SUNNY("Sunny",1.5,1,new ArrayList<>(List.of(Season.SPRING,Season.SUMMER,Season.FALL,Season.WINTER))),
    RAINY("Rainy",1.2,1.5,new ArrayList<>(List.of(Season.SPRING,Season.SUMMER,Season.FALL))),
    STORMY("Stormy",0.5,1,new ArrayList<>(List.of(Season.SPRING,Season.SUMMER,Season.FALL))),
    SNOWY("Snowy",0.5,2,new ArrayList<>(List.of(Season.WINTER)));

    private final String weatherDisplayName;
    private final double weatherCoEfficient;
    private final double toolEnergyCostMultiplier;
    private final ArrayList<Season> possibleSeasons;

    Weather(String weatherDisplayName,double weatherCoEfficient, double toolEnergyCostMultiplier, ArrayList<Season> possibleSeasons) {

        this.weatherDisplayName = weatherDisplayName;
        this.weatherCoEfficient = weatherCoEfficient;
        this.toolEnergyCostMultiplier = toolEnergyCostMultiplier;
        this.possibleSeasons = possibleSeasons;

    }

    public String getWeatherDisplayName() {
        return weatherDisplayName;
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
