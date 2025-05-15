package org.example.models.tools;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
public class Shears extends Tool {

    public Shears() {
        super(ToolTypes.SHEARS, Skill.FARMING);
    }

    @Override
    public String getItemName() {
        return "Shears";
    }

    @Override
    public int getBaseEnergyCost() {
        return 4;
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Shearing sheep in direction: " + direction);
    }
}


