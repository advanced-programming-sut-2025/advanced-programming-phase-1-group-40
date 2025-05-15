package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
public class Scythe extends Tool {
    public Scythe(){
        super(ToolTypes.SCYTHE);
    }
    @Override
    public String getItemName(){
        return "Scythe";
    }
}
