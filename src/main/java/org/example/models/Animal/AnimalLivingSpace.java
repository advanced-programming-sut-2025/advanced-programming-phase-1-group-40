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


    private ArrayList<Animal> animals;


    public AnimalLivingSpace(FarmBuildingType farmBuildingType, Position positionOfUpperLeftCorner) {
        super(farmBuildingType, positionOfUpperLeftCorner);
        this.animals = new ArrayList<>();

    }

    public void addAnimal(Animal animal) {

        this.animals.add(animal);

    }

    public void removeAnimal(Animal animal) {

        this.animals.remove(animal);

    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }



}
