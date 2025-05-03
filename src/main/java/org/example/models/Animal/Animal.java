package org.example.models.Animal;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.ArrayList;

public class Animal {

    private String name;
    private AnimalType animalType;

    private int friendship;

    private boolean petToday;
    private boolean sleptOutside;
    private boolean fedWithHayToday;

    private ArrayList<AnimalProducts> products;

    private FarmBuildingType animalLivingSpace;
    private Integer price;

    public Animal(String name, AnimalType animalType){

        this.name = name;
        this.animalType = animalType;

        this.petToday = false;
        this.sleptOutside = false;
        this.fedWithHayToday = false;

        this.products = new ArrayList<>();

        this.animalLivingSpace = animalType.getProperLivingSpace().get(0);          /// ino bayad fix koni!!!
        this.price = animalType.getPrice();


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }

    public void setPetToday(boolean petToday) {
        this.petToday = petToday;
    }

    public void setSleptOutside(boolean sleptOutside) {
        this.sleptOutside = sleptOutside;
    }

    public void setFedWithHayToday(boolean fedWithHayToday) {
        this.fedWithHayToday = fedWithHayToday;
    }

    public void setProducts(ArrayList<AnimalProducts> products) {
        this.products = products;
    }

    public void setAnimalLivingSpace(FarmBuildingType animalLivingSpace) {
        this.animalLivingSpace = animalLivingSpace;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public int getFriendship() {
        return friendship;
    }

    public boolean isPetToday() {
        return petToday;
    }

    public boolean isSleptOutside() {
        return sleptOutside;
    }

    public boolean isFedWithHayToday() {
        return fedWithHayToday;
    }

    public ArrayList<AnimalProducts> getProducts() {
        return products;
    }

    public FarmBuildingType getAnimalLivingSpace() {
        return animalLivingSpace;
    }

    public Integer getPrice() {
        return price;
    }
}


