package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum FishingRodType {

    TRAINING_ROD(0.1,"Training Rod"),
    BAMBOO_POLE(0.5,"Bamboo Pole"),
    FIBERGLASS_ROD(0.9,"Fiberglass Rod"),
    IRIDIUM(1.2,"Iridium Rod");

    private final double poleCoefficient;
    private final String poleName;

    FishingRodType(double poleCoefficient, String poleName) {

        this.poleCoefficient = poleCoefficient;
        this.poleName = poleName;

    }

    public double getPoleCoefficient() {
        return poleCoefficient;
    }

    public String getPoleName() {
        return poleName;
    }

}

