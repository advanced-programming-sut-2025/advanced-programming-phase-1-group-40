package org.example.models.enums.types;

import java.util.ArrayList;
import java.util.List;

public enum AnimalType {


    Chicken(new ArrayList<>(List.of(AnimalProducts.EGG,AnimalProducts.LARGE_EGG)), 800, 1,
            new ArrayList<>(List.of(FarmBuildingType.COOP, FarmBuildingType.BIG_COOP, FarmBuildingType.DELUXE_COOP)),1),


    Duck(new ArrayList<>(List.of(AnimalProducts.DUCK_EGG, AnimalProducts.DUCK_FEATHER)), 1200, 2,
            new ArrayList<>(List.of(FarmBuildingType.BIG_COOP, FarmBuildingType.DELUXE_COOP)),2),


    Rabbit(new ArrayList<>(List.of(AnimalProducts.WOOL, AnimalProducts.RABBIT_LEG)), 8000, 4,
            new ArrayList<>(List.of(FarmBuildingType.DELUXE_COOP)),4),


    Dinosaur(new ArrayList<>(List.of(AnimalProducts.DINOSAUR_EGG)), 14000, 7,
            new ArrayList<>(List.of(FarmBuildingType.BIG_COOP)),7),


    Cow(new ArrayList<>(List.of(AnimalProducts.COW_MILK, AnimalProducts.LARGE_COW_MILK)), 1500, 1,
            new ArrayList<>(List.of(FarmBuildingType.BARN, FarmBuildingType.BIG_BARN, FarmBuildingType.DELUXE_BARN)),1),


    Goat(new ArrayList<>(List.of(AnimalProducts.GOAT_MILK, AnimalProducts.LARGE_GOAT_MILK)), 4000, 2,
            new ArrayList<>(List.of(FarmBuildingType.BIG_BARN, FarmBuildingType.DELUXE_BARN)),2),


    Sheep(new ArrayList<>(List.of(AnimalProducts.WOOL)), 8000, 3,
            new ArrayList<>(List.of(FarmBuildingType.DELUXE_BARN)),3),


    Pig(new ArrayList<>(List.of(AnimalProducts.TRUFFLE)), 16000, null,
            new ArrayList<>(List.of(FarmBuildingType.DELUXE_BARN)),null);


    private final ArrayList<AnimalProducts> products;
    private final int price;
    private final Integer maxNumberInOnePlace;
    private final ArrayList<FarmBuildingType> properLivingSpace;
    private final Integer productCycle;

    AnimalType(ArrayList<AnimalProducts> products, int price, Integer maxNumberInOnePlace, ArrayList<FarmBuildingType> appropriateFarmType,Integer productsCycle) {
        this.products = products;
        this.price = price;
        this.maxNumberInOnePlace = maxNumberInOnePlace;
        this.properLivingSpace = appropriateFarmType;
        this.productCycle = productsCycle;
    }

    public ArrayList<AnimalProducts> getProducts() {
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
