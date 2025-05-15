package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;
public class FishingRod extends Tool {

    public FishingRod() {
        super(ToolTypes.FISHING_ROD, Skill.FISHING); // fishing rod ~ fishing
    }

    @Override
    public String getItemName() {
        return material == null ? "Fishing Rod (Unupgraded)" : "Fishing Rod (" + material.name() + ")";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Casting fishing rod in direction: " + direction);
    }
}
