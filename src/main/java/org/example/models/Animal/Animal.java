package org.example.models.Animal;

import org.example.models.*;
import org.example.models.enums.types.*;

import java.util.ArrayList;

public class Animal {

    private String name;
    private AnimalType animalType;
    private Player owner;
    private Integer friendshipWithOwner;
    private Position position;
    private boolean petToday;
    private boolean sleptOutside;
    private boolean fedWithHayToday;

    private ArrayList<AnimalProducts> products;

    private FarmBuildingType animalLivingSpace;
    private Integer price;

    public Animal(String name, AnimalType animalType){

        this.name = name;
        this.animalType = animalType;
        this.owner = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        this.friendshipWithOwner = 0;
        this.petToday = false;
        this.sleptOutside = false;
        this.fedWithHayToday = false;

        this.products = new ArrayList<>();

        this.animalLivingSpace = animalType.getProperLivingSpace().get(0);          /// ino bayad fix koni!!!
        this.price = animalType.getPrice();


    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Integer getFriendshipWithOwner() {
        return friendshipWithOwner;
    }

    public void setFriendshipWithOwner(Integer friendshipWithOwner) {
        this.friendshipWithOwner = friendshipWithOwner;
    }

    public boolean isPetToday() {
        return petToday;
    }

    public void setPetToday(boolean petToday) {
        this.petToday = petToday;
    }

    public boolean isSleptOutside() {
        return sleptOutside;
    }

    public void setSleptOutside(boolean sleptOutside) {
        this.sleptOutside = sleptOutside;
    }

    public boolean isFedWithHayToday() {
        return fedWithHayToday;
    }

    public void setFedWithHayToday(boolean fedWithHayToday) {
        this.fedWithHayToday = fedWithHayToday;
    }

    public ArrayList<AnimalProducts> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<AnimalProducts> products) {
        this.products = products;
    }

    public FarmBuildingType getAnimalLivingSpace() {
        return animalLivingSpace;
    }

    public void setAnimalLivingSpace(FarmBuildingType animalLivingSpace) {
        this.animalLivingSpace = animalLivingSpace;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}


