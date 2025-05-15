package org.example.models.enums.enviroment;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum Weekday {

    MONDAY("Monday",0),
    TUESDAY("Monday",1),
    WEDNESDAY("Monday",2),
    THURSDAY("Monday",3),
    FRIDAY("Monday",4),
    SATURDAY("Monday",5),
    SUNDAY("Monday",6);

    private final String dayName;
    private final int dayIndex;

    Weekday(String dayName, int dayIndex) {
        this.dayName = dayName;
        this.dayIndex = dayIndex;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public String getDayName() {
        return dayName;
    }

}
