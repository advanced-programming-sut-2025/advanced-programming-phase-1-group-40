package org.example.models.tools;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;


public abstract class Tool implements Item {

    private int energyNeeded;
    private Skill relatedSkill;
    protected ToolTypes type;
   // protected ToolMaterial material;

    public Tool(int energyNeeded, Skill relatedSkill) {
        this.energyNeeded = energyNeeded;
        this.relatedSkill = relatedSkill;
    }

    public Tool() {

    }
    public Tool(ToolTypes type) {
        this.type = type;
       // this.material = material;
    }


    public int getEnergyNeeded() {
        return energyNeeded;
    }

    public Skill getRelatedSkill() {
        return relatedSkill;
    }

    public void equipTool() {

    }

    public void upgradeTool() {

    }

    public void useTool(Direction direction) {

    }


}
