package org.example.models.tools;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.enums.*;
import org.example.models.enums.types.*;

public abstract class Tool implements Item {

    protected ToolTypes type;
    protected ToolMaterial material;
    protected Skill relatedSkill;

    public Tool(ToolTypes type, ToolMaterial material, Skill relatedSkill) {
        this.type = type;
        this.material = material;
        this.relatedSkill = relatedSkill;
    }

    public ToolTypes getType() {
        return type;
    }

    public ToolMaterial getMaterial() {
        return material;
    }

    public Skill getRelatedSkill() {
        return relatedSkill;
    }

    public abstract String getItemName();

    public int getBaseEnergyCost() {
        return switch (material) {
            case BASIC -> 5;
            case COPPER -> 4;
            case IRON -> 3;
            case GOLD -> 2;
            case IRIDIUM -> 1;
        };
    }

    public int getEnergyCost(int skillLevel) {
        return skillLevel >= 10 ? Math.max(0, getBaseEnergyCost() - 1) : getBaseEnergyCost();
    }

    public void equipTool() {
    }

    public void upgradeTool(ToolMaterial newMaterial) {
        this.material = newMaterial;
    }

    public void useTool(Direction direction) {
    }
}
