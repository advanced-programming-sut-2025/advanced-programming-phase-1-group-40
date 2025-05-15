package org.example.models.tools;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;
import org.example.models.enums.types.ToolTypes;
import org.example.models.enums.types.ToolMaterial;

public class Axe extends Tool{
    public Axe(){
        super(ToolTypes.AXE);
    }
    @Override
    public String getItemName(){
        return "Axe";
    }

}
