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
    protected String name;

    public Tool(ToolTypes type, Skill relatedSkill) {
        this.type = type;
        this.relatedSkill = relatedSkill;
        this.material = null;
    }

    public boolean canUpgrade(){

        return this.material.getToolMaterialLevel() < (ToolMaterial.values().length - 1);

    }

    public void upgrade() {

        if( canUpgrade() ){
            this.material = ToolMaterial.values()[material.getToolMaterialLevel()+1];
        }

    }


    public String getName(){
        return name;
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
        if (material == null) {
            return 5;
        }

        return switch (material) {
            case BASIC -> 5;
            case COPPER -> 4;
            case IRON -> 3;
            case GOLD -> 2;
            case IRIDIUM -> 1;
        };
    }

    public int getEnergyCost(int skillLevel) {
        return skillLevel >= 10
            ? Math.max(0, getBaseEnergyCost() - 1)
            : getBaseEnergyCost();
    }

    public void upgradeTool(ToolMaterial newMaterial) {
        this.material = newMaterial;
    }

    public void useTool(Direction direction) {

    }
}
