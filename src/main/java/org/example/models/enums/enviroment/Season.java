package org.example.models.enums.enviroment;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum Season {

    SPRING("Spring"),
    SUMMER("Summer"),
    FALL("Fall"),
    WINTER("Winter"),
    SPECIAL("Special");

    private final String name;
    Season(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
