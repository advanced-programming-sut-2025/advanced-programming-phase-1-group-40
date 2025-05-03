package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum BackpackType {
    INITIAL(12, false),
    LARGE(24, false),
    DELUXE(null, true);

    private final Integer capacity;
    private final boolean isUnlimited;

    BackpackType(Integer capacity, boolean isUnlimited) {
        this.capacity = capacity;
        this.isUnlimited = isUnlimited;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public boolean isUnlimited() {
        return isUnlimited;
    }
}

