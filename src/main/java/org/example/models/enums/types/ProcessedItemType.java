package org.example.models.enums.types;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


import java.util.HashMap;

public enum ProcessedItemType implements Item {
    IRON_BAR("Iron Bar"),
    COPPER_BAR("Copper Bar"),
    GOLD_BAR("Gold Bar");

    private final String name;

    ProcessedItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getItemName() {
        return this.name;
    }

}
