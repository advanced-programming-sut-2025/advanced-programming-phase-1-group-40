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
    private boolean isOutside;
    private boolean ateGrass;
    private boolean fedWithHayToday;
    private ArrayList<AnimalProduct> products;
    private FarmBuildingType animalLivingSpace;
    private Integer price;
    private Integer lastProductMade;



    public Animal(String name, AnimalType animalType){

        this.name = name;
        this.animalType = animalType;
        this.owner = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        this.friendshipWithOwner = 0;
        this.petToday = false;
        this.isOutside = false;
        this.fedWithHayToday = false;
        this.ateGrass = false;
        this.products = new ArrayList<>();
        this.lastProductMade = 0;


        this.animalLivingSpace = animalType.getProperLivingSpace().get(0);          /// ino bayad fix koni!!!
        this.price = animalType.getPrice();



    }

    public Integer getLastProductMade() {
        return lastProductMade;
    }

    public void setLastProductMade(Integer lastProductMade) {
        this.lastProductMade = lastProductMade;
    }

    public boolean isAteGrass() {
        return ateGrass;
    }

    public void setAteGrass(boolean ateGrass) {
        this.ateGrass = ateGrass;
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
        this.friendshipWithOwner = Math.min(1000,friendshipWithOwner);
    }

    public boolean isPetToday() {
        return petToday;
    }

    public void setPetToday(boolean petToday) {
        this.petToday = petToday;
    }

    public boolean isOutside() {
        return isOutside;
    }

    public void setOutside(boolean outside) {
        this.isOutside = outside;
    }

    public boolean isFedWithHayToday() {
        return fedWithHayToday;
    }

    public void setFedWithHayToday(boolean fedWithHayToday) {
        this.fedWithHayToday = fedWithHayToday;
    }

    public ArrayList<AnimalProduct> getProducts() {
        return products;
    }

    public void addProduct(AnimalProduct product) {
        this.products.add(product);
    }

    public void removeProduct(AnimalProduct product) {
        this.products.remove(product);
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


