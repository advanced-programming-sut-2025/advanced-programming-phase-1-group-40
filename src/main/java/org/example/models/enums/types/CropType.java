package org.example.models.enums.types;

import org.example.models.Item;
import org.example.models.enums.enviroment.Season;

import java.util.ArrayList;
import java.util.List;

public enum CropType implements Item {

    BLUE_JAZZ(ForagingSeedType.JAZZ_SEEDS, new ArrayList<>(List.of(1, 2, 2, 2)), 7, true, null, 50, true, 45, new ArrayList<>(List.of(Season.SPRING)), false),
            CARROT(ForagingSeedType.CARROT_SEEDS, new ArrayList<>(List.of(1, 1, 1)), 3, true, null, 35, true, 75, new ArrayList<>(List.of(Season.SPRING)), false),
            CAULIFLOWER(ForagingSeedType.CAULIFLOWER_SEEDS, new ArrayList<>(List.of(1, 2, 4, 4, 1)), 12, true, null, 175, true, 75, new ArrayList<>(List.of(Season.SPRING)), true),
            COFFEE_BEAN(ForagingSeedType.COFFEE_BEAN, new ArrayList<>(List.of(1, 2, 2, 3, 2)), 10, false, 2, 15, false, null, new ArrayList<>(List.of(Season.SPRING,Season.SUMMER)), false),
            GARLIC(ForagingSeedType.GARLIC_SEEDS, new ArrayList<>(List.of(1, 1, 1, 1)), 4, true, null, 60, true, 20, new ArrayList<>(List.of(Season.SPRING)), false),
            GREEN_BEAN(ForagingSeedType.BEAN_STARTER, new ArrayList<>(List.of(1, 1, 1, 3, 4)), 10, false, 3, 40, true, 25, new ArrayList<>(List.of(Season.SPRING)), false),
            KALE(ForagingSeedType.KALE_SEEDS, new ArrayList<>(List.of(1, 2, 2, 1)), 6, true, null, 110, true, 50, new ArrayList<>(List.of(Season.SPRING)), false),
            PARSNIP(ForagingSeedType.PARSNIP_SEEDS, new ArrayList<>(List.of(1, 1, 1, 1)), 4, true, null, 35, true, 25, new ArrayList<>(List.of(Season.SPRING)), false),
            POTATO(ForagingSeedType.POTATO_SEEDS, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6, true, null, 80, true, 25, new ArrayList<>(List.of(Season.SPRING)), false),
            RHUBARB(ForagingSeedType.RHUBARB_SEEDS, new ArrayList<>(List.of(2, 2, 2, 3, 4)), 13, true, null, 220, false, null, new ArrayList<>(List.of(Season.SPRING)), false),
            STRAWBERRY(ForagingSeedType.STRAWBERRY_SEEDS, new ArrayList<>(List.of(1, 1, 2, 2, 2)), 8, false, 4, 120, true, 50, new ArrayList<>(List.of(Season.SPRING)), false),
            TULIP(ForagingSeedType.TULIP_BULB, new ArrayList<>(List.of(1, 1, 2, 2)), 6, true, null, 30, true, 45, new ArrayList<>(List.of(Season.SPRING)), false),
            UNMILLED_RICE(ForagingSeedType.RICE_SHOOT, new ArrayList<>(List.of(1, 2, 2, 3)), 8, true, null, 30, true, 3, new ArrayList<>(List.of(Season.SPRING)), false),
            BLUEBERRY(ForagingSeedType.BLUEBERRY_SEEDS, new ArrayList<>(List.of(1, 3, 3, 4, 2)), 13, false, 4, 50, true, 25, new ArrayList<>(List.of(Season.SUMMER)), false),
            CORN(ForagingSeedType.CORN_SEEDS, new ArrayList<>(List.of(2, 3, 3, 3, 3)), 14, false, 4, 50, true, 25, new ArrayList<>(List.of(Season.SUMMER,Season.FALL)), false),
            HOPS(ForagingSeedType.HOPS_STARTER, new ArrayList<>(List.of(1, 1, 2, 3, 4)), 11, false, 1, 25, true, 45, new ArrayList<>(List.of(Season.SUMMER)), false),
            HOT_PEPPER(ForagingSeedType.PEPPER_SEEDS, new ArrayList<>(List.of(1, 1, 1, 1, 1)), 5, false, 3, 40, true, 13, new ArrayList<>(List.of(Season.SUMMER)), false),
            MELON(ForagingSeedType.MELON_SEEDS, new ArrayList<>(List.of(1, 2, 3, 3, 3)), 12, true, null, 250, true, 113, new ArrayList<>(List.of(Season.SUMMER)), true),
            POPPY(ForagingSeedType.POPPY_SEEDS, new ArrayList<>(List.of(1, 2, 2, 2)), 7, true, null, 140, true, 45, new ArrayList<>(List.of(Season.SUMMER)), false),
            RADISH(ForagingSeedType.RADISH_SEEDS, new ArrayList<>(List.of(2, 1, 2, 1)), 6, true, null, 90, true, 45, new ArrayList<>(List.of(Season.SUMMER)), false),
            RED_CABBAGE(ForagingSeedType.RED_CABBAGE_SEEDS, new ArrayList<>(List.of(2, 1, 2, 2, 2)), 9, true, null, 260, true, 75, new ArrayList<>(List.of(Season.SUMMER)), false),
            STARFRUIT(ForagingSeedType.STARFRUIT_SEEDS, new ArrayList<>(List.of(2, 3, 2, 3, 3)), 13, true, null, 750, true, 125, new ArrayList<>(List.of(Season.SUMMER)), false),
            SUMMER_SPANGLE(ForagingSeedType.SPANGLE_SEEDS, new ArrayList<>(List.of(1, 2, 3, 1)), 8, true, null, 90, true, 45, new ArrayList<>(List.of(Season.SUMMER)), false),
            SUMMER_SQUASH(ForagingSeedType.SUMMER_SQUASH_SEEDS, new ArrayList<>(List.of(1, 1, 1, 2, 1)), 6, false, 3, 45, true, 63, new ArrayList<>(List.of(Season.SUMMER)), false),
            SUNFLOWER(ForagingSeedType.SUNFLOWER_SEEDS, new ArrayList<>(List.of(1, 2, 3, 2)), 8, true, null, 80, true, 45, new ArrayList<>(List.of(Season.SUMMER,Season.FALL)), false),
            TOMATO(ForagingSeedType.TOMATO_SEEDS, new ArrayList<>(List.of(2, 2, 2, 2, 3)), 11, false, 4, 60, true, 20, new ArrayList<>(List.of(Season.SUMMER)), false),
            WHEAT(ForagingSeedType.WHEAT_SEEDS, new ArrayList<>(List.of(1, 1, 1, 1)), 4, true, null, 25, false, null, new ArrayList<>(List.of(Season.SUMMER,Season.FALL)), false),
            AMARANTH(ForagingSeedType.AMARANTH_SEEDS, new ArrayList<>(List.of(1, 2, 2, 2)), 7, true, null, 150, true, 50, new ArrayList<>(List.of(Season.FALL)), false),
            ARTICHOKE(ForagingSeedType.ARTICHOKE_SEEDS, new ArrayList<>(List.of(2, 2, 1, 2, 1)), 8, true, null, 160, true, 30, new ArrayList<>(List.of(Season.FALL)), false),
            BEET(ForagingSeedType.BEET_SEEDS, new ArrayList<>(List.of(1, 1, 2, 2)), 6, true, null, 100, true, 30, new ArrayList<>(List.of(Season.FALL)), false),
            BOK_CHOY(ForagingSeedType.BOK_CHOY_SEEDS, new ArrayList<>(List.of(1, 1, 1, 1)), 4, true, null, 80, true, 25, new ArrayList<>(List.of(Season.FALL)), false),
            BROCCOLI(ForagingSeedType.BROCCOLI_SEEDS, new ArrayList<>(List.of(2, 2, 2, 2)), 8, false, 4, 70, true, 63, new ArrayList<>(List.of(Season.FALL)), false),
            CRANBERRIES(ForagingSeedType.CRANBERRY_SEEDS, new ArrayList<>(List.of(1, 2, 1, 1, 2)), 7, false, 5, 75, true, 38, new ArrayList<>(List.of(Season.FALL)), false),
            EGGPLANT(ForagingSeedType.EGGPLANT_SEEDS, new ArrayList<>(List.of(1, 1, 1, 1)), 5, false, 5, 60, true, 20, new ArrayList<>(List.of(Season.FALL)), false),
            FAIRY_ROSE(ForagingSeedType.FAIRY_SEEDS, new ArrayList<>(List.of(1, 4, 4, 3)), 12, true, null, 290, true, 45, new ArrayList<>(List.of(Season.FALL)), false),
            GRAPE(ForagingSeedType.GRAPE_STARTER, new ArrayList<>(List.of(1, 1, 2, 3, 3)), 10, false, 3, 80, true, 38, new ArrayList<>(List.of(Season.FALL)), false),
            PUMPKIN(ForagingSeedType.PUMPKIN_SEEDS, new ArrayList<>(List.of(1, 2, 3, 4, 3)), 13, true, null, 320, false, null, new ArrayList<>(List.of(Season.FALL)), true),
            YAM(ForagingSeedType.YAM_SEEDS, new ArrayList<>(List.of(1, 3, 3, 3)), 10, true, null, 160, true, 45, new ArrayList<>(List.of(Season.FALL)), false),
            SWEET_GEM_BERRY(ForagingSeedType.RARE_SEED, new ArrayList<>(List.of(2, 4, 6, 6, 6)), 24, true, null, 3000, false, null, new ArrayList<>(List.of(Season.FALL)), false),
            POWDERMELON(ForagingSeedType.POWDERMELON_SEEDS, new ArrayList<>(List.of(1, 2, 1, 2, 1)), 7, true, null, 60, true, 63, new ArrayList<>(List.of(Season.WINTER)), true),
            ANCIENT_FRUIT(ForagingSeedType.ANCIENT_SEEDS, new ArrayList<>(List.of(2, 7, 7, 7, 5)), 28, false, 7, 550, false, null, new ArrayList<>(List.of(Season.FALL,Season.SUMMER,Season.SPRING)), false);

    private final ForagingSeedType foragingSeedType;
    private final ArrayList<Integer> stages;
    private final Integer totalHarvestTime;
    private final boolean oneTime;
    private final Integer regrowthTime;
    private final Integer sellPrice;
    private final boolean isEdible;
    private final Integer energy;
    private final ArrayList<Season> availableSeason;
    private final boolean canBecomeGiant;


    CropType(ForagingSeedType foragingSeedType, ArrayList<Integer> stages, Integer totalHarvestTime, boolean oneTime, Integer regrowthTime, Integer sellPrice, boolean isEdible, Integer energy, ArrayList<Season> season, boolean canBecomeGiant) {
        this.foragingSeedType = foragingSeedType;
        this.stages = stages;
        this.totalHarvestTime = totalHarvestTime;
        this.oneTime = oneTime;
        this.regrowthTime = regrowthTime;
        this.sellPrice = sellPrice;
        this.isEdible = isEdible;
        this.energy = energy;
        this.availableSeason = season;
        this.canBecomeGiant = canBecomeGiant;
    }

    public ForagingSeedType getForagingSeedType() {
        return foragingSeedType;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }

    public Integer getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public boolean isOneTime() {
        return oneTime;
    }

    public Integer getRegrowthTime() {
        return regrowthTime;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public Integer getEnergy() {
        return energy;
    }

    public ArrayList<Season> getAvailableSeason() {
        return availableSeason;
    }

    public boolean isCanBecomeGiant() {
        return canBecomeGiant;
    }
}
