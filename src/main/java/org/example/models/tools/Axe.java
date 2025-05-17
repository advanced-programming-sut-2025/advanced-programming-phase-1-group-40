package org.example.models.tools;

import org.example.models.*;
import org.example.models.Map.MapTile;
import org.example.models.Map.TileType;
import org.example.models.enums.types.ToolTypes;
import org.example.models.enums.Skill;
import org.example.models.enums.enviroment.Direction;

public class Axe extends Tool {

    public Axe() {
        super(ToolTypes.AXE, Skill.FARMING); // axe ~ farming
    }

    @Override
    public String getItemName() {
        return "Axe";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Chopping with axe in direction: " + direction);

        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        Position now = player.getCurrentPosition();
        Position targetPosition = now.getNeighbor(direction);

        MapTile[][] map = App.dataManager.getCurrentGame().getMap();
        int x = targetPosition.getX();
        int y = targetPosition.getY();

        MapTile targetTile = map[x][y];
        TileType type = targetTile.getType();

        if (type == TileType.TREE) {
            targetTile.setType(TileType.GROUND);
            System.out.println("You chopped down the tree at (" + x + "," + y + ")");
        } else {
            System.out.println("Cannot chop this tile: " + type);
        }
    }



}
