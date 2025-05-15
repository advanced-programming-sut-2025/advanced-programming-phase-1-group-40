package org.example.models.tools;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public class Shear extends Tool {
    public Shear() {
        super(ToolTypes.SHEARS);
    }
    @Override
    public String getItemName(){
        return "Shear";
    }
}


