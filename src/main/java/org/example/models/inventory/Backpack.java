package org.example.models.inventory;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;

public class Backpack extends Inventory {



    private final BackpackType type;

    public Backpack(BackpackType type) {
        super(type.getCapacity(), type.isUnlimited());
        this.type = type;
    }

    public BackpackType getType() {
        return this.type;
    }


}
