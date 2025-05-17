package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class Fish implements Item {

    FishType type;
    int basePrice;
    Season season;
    boolean isLegendary;
    private final int fishQuality;

    public Fish(FishType type, int fishQuality) {
        this.type = type;
        this.basePrice = type.getBasePrice();
        this.season = type.getSeason();
        this.isLegendary = type.isLegendary();
        this.fishQuality = fishQuality;
    }

    public FishType getType() {
        return type;
    }

    public int getFishQuality() {
        return fishQuality;
    }

    public FishType getName() {
        return type;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Season getSeason() {
        return season;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setName(FishType type) {
        this.type = type;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }

    @Override
    public String getItemName() {
        return this.getType().getName();
    }
}
