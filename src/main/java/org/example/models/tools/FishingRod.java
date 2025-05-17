package org.example.models.tools;

import org.example.models.*;
import org.example.models.Map.MapTile;
import org.example.models.Map.TileType;
import org.example.models.enums.types.ToolTypes;
import org.example.models.enums.Skill;
import org.example.models.enums.enviroment.Direction;

public class FishingRod extends Tool {

    protected int energyCost;
    protected int requiredSkillLevel;

    public FishingRod(String name,int energyCost,int requiredSkillLevel ) {
        super(ToolTypes.FISHING_ROD, Skill.FISHING);// fishing rod ~ fishing
        this.energyCost = energyCost;
        this.requiredSkillLevel = requiredSkillLevel;
        this.name = name;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

    public int getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public void setRequiredSkillLevel(int requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    @Override
    public String getItemName() {
        return "Fishing Rod";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Casting fishing rod in direction: " + direction);
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        Position target = player.getCurrentPosition().getNeighbor(direction);
        MapTile[][] map = App.dataManager.getCurrentGame().getMap();
        int x = target.getX();
        int y = target.getY();
        MapTile targetTile = map[x][y];
        TileType type = targetTile.getType();
        if(type == TileType.WATER) {

        }
    }
}
