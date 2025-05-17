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


public enum ArtisanType {

    HONEY(75, 96, List.of(
        List.of()
    ), 350),

    CLOTH(-1, 4, List.of(
        List.of("Wool")
    ), 470),

    CHEESE(100, 3, List.of(
        List.of("Milk"),
        List.of("Large Milk")
    ), 230),

    GOAT_CHEESE(100, 3, List.of(
        List.of("Goat Milk"),
        List.of("Large Goat Milk")
    ), 400),

    MAYONNAISE(50, 3, List.of(
        List.of("Egg"),
        List.of("Large Egg")
    ), 190),

    DUCK_MAYONNAISE(75, 3, List.of(
        List.of("Duck Egg")
    ), 37),

    DINOSAUR_MAYONNAISE(125, 3, List.of(
        List.of("Dinosaur Egg")
    ), 800),

    BEER(50, 24, List.of(
        List.of("Wheat")
    ), 200),

    VINEGAR(13, 10, List.of(
        List.of("Rice")
    ), 100),

    TRUFFLE_OIL(38, 6, List.of(
        List.of("Truffle")
    ), 1065),

    COFFEE(75, 2, List.of(
        List.of("Coffee Bean")
    ), 150),

    OIL(13, 6, List.of(
        List.of("Corn"),
        List.of("Sunflower Seeds"),
        List.of("Sunflower")
    ), 100),

    JUICE(-1, 96, List.of(
        List.of("Any Vegetable")
    ), -1),

    MEAD(100, 10, List.of(
        List.of("Honey")
    ), 300),

    PALE_ALE(50, 72, List.of(
        List.of("Hops")
    ), 300),

    WINE(-1, 168, List.of(
        List.of("Any Fruit")
    ), -1),

    PICKLES(-1, 6, List.of(
        List.of("Any Vegetable")
    ), -1),

    JELLY(-1, 72, List.of(
        List.of("Any Fruit")
    ), -1),

    DRIED_MUSHROOMS(50, 12, List.of(
        List.of("Any Mushroom")
    ), -1),

    DRIED_FRUIT(75, 12, List.of(
        List.of("Any Fruit")
    ), -1),

    RAISINS(125, 12, List.of(
        List.of("Grapes")
    ), 600),

    SMOKED_FISH(-1, 1, List.of(
        List.of("Any Fish", "Coal")
    ), -1),

    COAL(-1, 1, List.of(
        List.of("Wood")
    ), 50),

    METAL_BAR(-1, 4, List.of(
        List.of("Any Ore", "Coal")
    ), -1);

    private final Integer energy;
    private final Integer processingTimeInHours;
    private final List<List<String>> ingredientSets;
    private final Integer sellPrice;

    ArtisanType(Integer energy, Integer processingTimeInHours, List<List<String>> ingredientSets, Integer sellPrice) {
        this.energy = energy;
        this.processingTimeInHours = processingTimeInHours;
        this.ingredientSets = ingredientSets;
        this.sellPrice = sellPrice;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Integer getProcessingTimeInHours() {
        return processingTimeInHours;
    }

    public List<List<String>> getIngredientSets() {
        return ingredientSets;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }
}

