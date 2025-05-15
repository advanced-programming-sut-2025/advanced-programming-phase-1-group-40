package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;

public class Pickaxe extends Tool {

    public Pickaxe() {
        super(ToolTypes.PICKAXE, Skill.MINING); //pickaxe ~ mining
    }

    @Override
    public String getItemName() {//name + material
        return material == null ? "Pickaxe (Unupgraded)" : "Pickaxe (" + material.name() + ")";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Breaking rocks with pickaxe in direction: " + direction);
    }
}
