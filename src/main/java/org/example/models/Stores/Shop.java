package org.example.models.Stores;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;



import java.util.HashMap;

public class Shop {

    String name;
    ShopType type;
    HashMap<Item, Integer> shopInventory;
    int balance;
    NPC owner;

    public Shop(ShopType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public HashMap<Item, Integer> getShopInventory() {
        return shopInventory;
    }

    public int getBalance() {
        return balance;
    }

    public NPC getOwner() {
        return owner;
    }

    void addProduct(Item item, int count) {

    }

    void removeProduct(Item item, int count) {

    }

    void sellProduct(Item item, int count) {

    }

    void showAvailableProducts() {

    }
}
