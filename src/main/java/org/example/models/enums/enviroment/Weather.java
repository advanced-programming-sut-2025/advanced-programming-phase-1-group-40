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
    SUNNY(1.5),
    RAINY(1.2),
    STORM(0.5),
    SNOW(0.5);

    private final double weatherCoEfficient;

    Weather(double weatherCoEfficient) {

        this.weatherCoEfficient = weatherCoEfficient;

    }

    public double getWeatherCoEfficient() {
        return weatherCoEfficient;
    }

}
