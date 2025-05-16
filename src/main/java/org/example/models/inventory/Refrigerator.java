package org.example.models.inventory;

import org.example.models.enums.types.InventoryType;

public class Refrigerator extends Inventory {


    private final InventoryType type;

    public Refrigerator(InventoryType type) {
        super(type.getCapacity());
        this.type = type;
    }

    public InventoryType getType() {
        return this.type;
    }



}
