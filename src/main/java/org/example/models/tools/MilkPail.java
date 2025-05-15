package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;
public class MilkPail extends Tool {

    public MilkPail() {
        super(ToolTypes.MILK_PAIL, Skill.FARMING);
    }

    @Override
    public String getItemName() {
        return "Milk Pail";
    }

    @Override
    public int getBaseEnergyCost() {
        return 4;
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Milking in direction: " + direction);
    }
}
