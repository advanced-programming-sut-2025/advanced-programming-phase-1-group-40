package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class AnimalProduct extends Item {
    private AnimalProductType type;
    private int basePrice;
    private Quality quality;
    private Animal producerAnimal;

    public void calculatePrice() {
        this.setPrice((int) (this.basePrice * ((double) this.producerAnimal.getFriendshipLevel() / 1000 + 0.3)));
    }

    public AnimalProduct(AnimalProductType type) {
        this.type = type;
    }

//    public AnimalProduct(models.enums.types.AnimalProductType type, Animal producerAnimal, int basePrice, Quality quality) {
//        this.type = type;
//        this.producerAnimal = producerAnimal;
//        this.basePrice = basePrice;
//        this.quality = quality;
//    }

    public AnimalProductType getType() {
        return this.type;
    }

    public Quality getQuality() {
        return this.quality;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public Animal getProducerAnimal() {
        return this.producerAnimal;
    }
}
