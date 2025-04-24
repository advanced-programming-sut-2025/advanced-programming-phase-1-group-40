package org.example.models.enums.enviroment;

import java.util.*;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum Weather {
    SUNNY,
    RAINY,
    STORM,
    SNOW;

    private ArrayList<Season> seasonsAvailable;

    Weather(ArrayList<Season> seasonsAvailable) {
        this.seasonsAvailable = seasonsAvailable;
    }

    public ArrayList<Season> getSeasonsAvailable() {
        return seasonsAvailable;
    }


}
