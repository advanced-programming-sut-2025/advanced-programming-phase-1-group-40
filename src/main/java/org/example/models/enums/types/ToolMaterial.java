package org.example.models.enums.types;


import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public enum ToolMaterial {

    BASIC(0),
    COPPER(1),
    IRON(2),
    GOLD(3),
    IRIDIUM(4);

    private final int toolMaterialLevel;

    ToolMaterial(int toolMaterialLevel) {
        this.toolMaterialLevel = toolMaterialLevel;
    }

    public int getToolMaterialLevel() {
        return toolMaterialLevel;
    }

}
