package org.example.models.tools;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;


public class Tool extends Item {
    private int energyNeeded;
    private Skill relatedSkill;

    public Tool(int energyNeeded, Skill relatedSkill) {
        this.energyNeeded = energyNeeded;
        this.relatedSkill = relatedSkill;
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
