package org.example.models.enums;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum Quality {
    NORMAL(1),
    SILVER(1.25),
    GOLD(1.5),
    IRIDIUM(2);

    private final double priceCoefficient;

    Quality(double priceCoefficient) {
        this.priceCoefficient = priceCoefficient;
    }

    public double getPriceCoefficient() {
        return priceCoefficient;
    }
}
