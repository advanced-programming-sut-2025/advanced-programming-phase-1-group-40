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

public class Axe extends Tool {

    public Axe() {
        super(ToolTypes.AXE, ToolMaterial.BASIC, Skill.FORAGING);
    }

    public Axe(ToolMaterial material) {
        super(ToolTypes.AXE, material, Skill.FORAGING);
    }

    @Override
    public String getItemName() {
        return "Axe (" + material.name() + ")";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Using axe in direction: " + direction);
    }
}

