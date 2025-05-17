package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;
import org.example.models.Map.MapTile;
import org.example.models.Map.TileType;


public class WateringCan extends Tool {

    public WateringCan() {
        super(ToolTypes.WATERING_CAN, Skill.FARMING);
    }

    @Override
    public String getItemName() {
        return "Watering Can";
    }

    @Override
    public void useTool(Direction direction) {
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

      /*  if (!player.hasEnoughEnergy(getEnergyCost())) {
            System.out.println("Not enough energy to water.");
            return;
        }*/

        Position targetPosition = player.getCurrentPosition().getNeighbor(direction);
        MapTile[][] map = App.dataManager.getCurrentGame().getMap();

        int x = targetPosition.getX();
        int y = targetPosition.getY();

        MapTile targetTile = map[x][y];
        TileType type = targetTile.getType();

        if (type == TileType.TILLED_SOIL || type == TileType.PLANTED_SOIL) {
            targetTile.setType(TileType.WATERED_SOIL);
            //player.consumeEnergy(getEnergyCost();
            System.out.println("You watered the soil at position (" + x + ", " + y + ").");
        } else {
            System.out.println("Cannot water this tile: " + type);
        }
    }
}
