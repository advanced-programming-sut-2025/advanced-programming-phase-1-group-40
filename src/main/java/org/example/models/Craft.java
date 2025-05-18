package org.example.models;

import org.example.models.enums.types.CraftTypes;

public class Craft implements Item{

    private final CraftTypes type;

    public Craft(CraftTypes type) {
        this.type = type;
    }

    public CraftTypes getType() {
        return type;
    }


    @Override
    public String getItemName() {
        return type.getName();
    }


}
