package org.example.models.inventory;

import org.example.models.Item;
import org.example.models.enums.types.*;

public class Backpack extends Inventory {



    private final InventoryType type;

    public Backpack(InventoryType type) {
        super(type.getCapacity());
        this.type = type;
    }

    public InventoryType getType() {
        return this.type;
    }


    public Item getItemFromInventoryByName(String itemName) {
        return null;
    }
}
