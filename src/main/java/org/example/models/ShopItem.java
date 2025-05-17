package org.example.models;

import org.example.models.enums.types.ShopItemTypes;

public class ShopItem implements Item{

    private ShopItemTypes type;
    private Integer price;

    public ShopItem(ShopItemTypes type) {
        this.type = type;
        this.price = type.getPrice();
    }

    public ShopItemTypes getType() {
        return type;
    }

    public void setType(ShopItemTypes type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String getItemName() {
        return this.type.getDisplayName();
    }
}
