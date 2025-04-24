package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Arrays;
import java.util.List;

public enum AnimalType {
    CHICKEN(Arrays.asList(AnimalProductType.CHICKEN_EGG, AnimalProductType.LARGE_CHICKEN_EGG), true),
    DUCK(Arrays.asList(AnimalProductType.DUCK_EGG, AnimalProductType.DUCK_FEATHER), true),
    RABBIT(Arrays.asList(AnimalProductType.RABBIT_WOOL, AnimalProductType.RABBIT_FOOT), true),
    DINOSAUR(Arrays.asList(AnimalProductType.DINOSAUR_EGG), true),
    COW(Arrays.asList(AnimalProductType.COW_MILK, AnimalProductType.LARGE_COW_MILK), false),
    GOAT(Arrays.asList(AnimalProductType.GOAT_MILK, AnimalProductType.LARGE_GOAT_MILK), false),
    SHEEP(Arrays.asList(AnimalProductType.WOOL), false),
    PIG(Arrays.asList(AnimalProductType.TRUFFLE), false);

    private final List<AnimalProductType> animalProducts;
    private final boolean livesInCage;

    AnimalType(List<AnimalProductType> animalProducts, boolean livesInCage) {
        this.animalProducts = animalProducts;
        this.livesInCage = livesInCage;
    }

    public List<AnimalProductType> getAnimalProducts() {
        return animalProducts;
    }

    public boolean isLivesInCage() {
        return livesInCage;
    }
}
