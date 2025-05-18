package org.example.models.enums.types;

import org.example.models.Item;

public enum ToolTypes implements Item {
    HOE,
    PICKAXE,
    AXE,
    WATERING_CAN,
    FISHING_ROD,
    SCYTHE,
    MILK_PAIL,
    SHEARS,
    BACKPACK,
    TRASH_CAN;

    @Override
    public String getItemName() {
        return this.toString().toLowerCase();
    }
}

