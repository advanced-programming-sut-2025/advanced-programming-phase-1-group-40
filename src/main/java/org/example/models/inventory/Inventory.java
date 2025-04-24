package org.example.models.inventory;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public abstract class Inventory {
    protected int capacity;
    protected boolean isCapacityUnlimited;

    public Inventory(int capacity, boolean isCapacityUnlimited) {
        this.capacity = capacity;
        this.isCapacityUnlimited = isCapacityUnlimited;
    }

    public void addToInventory(Item item, int n) {
        
    }

    public void CheatAddToInventory(Item item, int n) {
        
    }

    public void removeFromInventory(Item item, int n) {
        
    }

}
