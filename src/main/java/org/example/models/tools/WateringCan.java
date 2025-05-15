package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;

public class WateringCan extends Tool {

    public WateringCan() {
        super(ToolTypes.WATERING_CAN, Skill.FARMING); //watering can ~ farming
    }

    @Override
    public String getItemName() {
        return material == null ? "Watering Can (Unupgraded)" : "Watering Can (" + material.name() + ")";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Watering in direction: " + direction);
    }
}
