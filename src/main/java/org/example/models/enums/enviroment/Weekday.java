package org.example.models.enums.enviroment;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum Weekday {

    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    private final int dayIndex;

    Weekday(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public int getDayIndex() {
        return dayIndex;
    }


}
