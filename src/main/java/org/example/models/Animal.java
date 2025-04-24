package org.example.Models;

import models.enums.environment.Time;
import models.enums.types.AnimalType;
import 

import java.util.ArrayList;

public class Animal {
    private String name;
    private AnimalType animalType;
    private int purchaseCost;
    private int friendshipLevel;
    private Time LastFeedingTime;
    private Time LastpettingTime;
    private Time lastProductTime;
    private boolean isFedToday;
    private ArrayList<models.AnimalProduct> producedProducts;
    private models.AnimalLivingSpace animalLivingSpace;
    private boolean stayedInSide;
    private boolean isFedHay;

    public Animal(String name, AnimalType animalType) {
        this.name = name;
        this.animalType = animalType;
        this.friendshipLevel = 0;
    }

    public void feedHay() {
    }

    public void collectProduce() {
    }

    private void updateFriendship() {
    }

    public String getName() {
        return this.name;
    }

    public AnimalLivingSpace getLivingSpace() {
        return this.animalLivingSpace;
    }

    public ArrayList<AnimalProduct> getProducedProducts() {
        return this.producedProducts;
    }

    public Time getLastProductTime() {
        return this.lastProductTime;
    }

    public Time getLastpettingTime() {
        return this.LastpettingTime;
    }

    public Time getLastFeedingTime() {
        return this.LastFeedingTime;
    }

    public int getFriendshipLevel() {
        return this.friendshipLevel;
    }

    public AnimalType getAnimalType() {
        return this.animalType;
    }

    public AnimalLivingSpace getAnimalLivingSpace() {
        return this.animalLivingSpace;
    }

    public int getPurchaseCost() {
        return this.purchaseCost;
    }

    public boolean isFedToday() {
        return isFedToday;
    }

    public boolean isStayedInSide() {
        return stayedInSide;
    }

    public void setStayedInSide(boolean stayedInSide) {
        this.stayedInSide = stayedInSide;
    }

    public void setFedToday(boolean fedToday) {
        isFedToday = fedToday;
    }


}


