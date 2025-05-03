package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum FishingRodType {

    TRAINING_ROD(0.1),
    BAMBOO_POLE(0.5),
    FIBERGLASS_ROD(0.9),
    IRIDIUM(1.2);

    private final double poleCoefficient;

    FishingRodType(double poleCoefficient) {

        this.poleCoefficient = poleCoefficient;

    }

    public double getPoleCoefficient() {
        return poleCoefficient;
    }

}

