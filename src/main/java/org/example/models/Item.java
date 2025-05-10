package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class Item{
    private int price;
    private boolean isItemSellable;
    private boolean isItemPurchaseable;
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isItemSellable() {
        return this.isItemSellable;
    }
    public void setItemSellable(boolean itemSellable) {
        isItemSellable = itemSellable;
    }
    public boolean isItemPurchaseable() {
        return this.isItemPurchaseable;
    }
    public void setItemPurchaseable(boolean itemPurchaseable) {
        isItemPurchaseable = itemPurchaseable;
    }

}


