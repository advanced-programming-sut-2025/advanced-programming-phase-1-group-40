package org.example.models.Animal;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.ArrayList;

public class AnimalLivingSpace extends FarmBuilding {
    private final Capacity capacity;
    private ArrayList<Animal> animals;
    private boolean isCage; // type = Stable if false

    public AnimalLivingSpace(FarmBuildingType farmBuildingType, Position positionOfUpperLeftCorner, Capacity capacity) {
        super(farmBuildingType, positionOfUpperLeftCorner);
        this.capacity = capacity;
    }

    void addAnimal(Animal animal) {
    }

    void removeAnimal(Animal animal) {
    }
}
