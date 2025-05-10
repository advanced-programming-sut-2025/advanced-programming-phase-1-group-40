package org.example.models.enums.types;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ArtisanType {

    HONEY(75,96,new ArrayList<ProcessedItemType>(),350);
    // CHEESE(100,3,,)

    private final Integer energy;
    private final Integer processingTimeInHours;
    private final ArrayList<ProcessedItemType> processedItemTypes;
    private final Integer sellPrice;

    ArtisanType(Integer energy, Integer processingTimeInHours, ArrayList<ProcessedItemType> processedItemTypes, Integer sellPrice) {
        this.energy = energy;
        this.processingTimeInHours = processingTimeInHours;
        this.processedItemTypes = processedItemTypes;
        this.sellPrice = sellPrice;
    }


}
