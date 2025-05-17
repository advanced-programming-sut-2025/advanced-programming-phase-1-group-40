package org.example.models.enums.types;

import java.util.ArrayList;
import java.util.List;

public enum AnimalType {


    Chicken("Chicken",new ArrayList<>(List.of(AnimalProductType.EGG, AnimalProductType.LARGE_EGG)), 800, 1,
            new ArrayList<>(List.of(FarmBuildingType.COOP, FarmBuildingType.BIG_COOP, FarmBuildingType.DELUXE_COOP)),1),


    Duck("Duck",new ArrayList<>(List.of(AnimalProductType.DUCK_EGG, AnimalProductType.DUCK_FEATHER)), 1200, 2,
            new ArrayList<>(List.of(FarmBuildingType.BIG_COOP, FarmBuildingType.DELUXE_COOP)),2),


    Rabbit("Rabbit",new ArrayList<>(List.of(AnimalProductType.WOOL, AnimalProductType.RABBIT_LEG)), 8000, 4,
            new ArrayList<>(List.of(FarmBuildingType.DELUXE_COOP)),4),


    Dinosaur("Dinosaur",new ArrayList<>(List.of(AnimalProductType.DINOSAUR_EGG)), 14000, 7,
            new ArrayList<>(List.of(FarmBuildingType.BIG_COOP)),7),


    Cow("Cow",new ArrayList<>(List.of(AnimalProductType.COW_MILK, AnimalProductType.LARGE_COW_MILK)), 1500, 1,
            new ArrayList<>(List.of(FarmBuildingType.BARN, FarmBuildingType.BIG_BARN, FarmBuildingType.DELUXE_BARN)),1),


    Goat("Goat",new ArrayList<>(List.of(AnimalProductType.GOAT_MILK, AnimalProductType.LARGE_GOAT_MILK)), 4000, 2,
            new ArrayList<>(List.of(FarmBuildingType.BIG_BARN, FarmBuildingType.DELUXE_BARN)),2),


    Sheep("Sheep",new ArrayList<>(List.of(AnimalProductType.WOOL)), 8000, 3,
            new ArrayList<>(List.of(FarmBuildingType.DELUXE_BARN)),3),


    Pig("Pig",new ArrayList<>(List.of(AnimalProductType.TRUFFLE)), 16000, null,
            new ArrayList<>(List.of(FarmBuildingType.DELUXE_BARN)),null);


    private final String name;
    private final ArrayList<AnimalProductType> products;
    private final int price;
    private final Integer maxNumberInOnePlace;
    private final ArrayList<FarmBuildingType> properLivingSpace;
    private final Integer productCycle;

    AnimalType(String name, ArrayList<AnimalProductType> products, int price, Integer maxNumberInOnePlace, ArrayList<FarmBuildingType> appropriateFarmType, Integer productsCycle) {
        this.name = name;
        this.products = products;
        this.price = price;
        this.maxNumberInOnePlace = maxNumberInOnePlace;
        this.properLivingSpace = appropriateFarmType;
        this.productCycle = productsCycle;
    }

    public String getName() {
        return name;
    }

    public ArrayList<AnimalProductType> getProducts() {
        return products;
    }

    public int getPrice() {
        return price;
    }

    public Integer getMaxNumberInOnePlace() {
        return maxNumberInOnePlace;
    }

    public ArrayList<FarmBuildingType> getProperLivingSpace() {
        return properLivingSpace;
    }

    public Integer getProductCycle() {
        return productCycle;
    }
}
