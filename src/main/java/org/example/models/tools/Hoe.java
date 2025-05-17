package org.example.models.tools;
import org.example.models.*;
import org.example.models.Map.MapTile;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.Map.TileType;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;

public class Hoe extends Tool {

    public Hoe() {
        super(ToolTypes.HOE, Skill.FARMING);//hoe ~ farming
    }

    @Override
    public String getItemName() {//material ro ham mige
        return "Hoe";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Tilling soil with hoe in direction: " + direction);
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        Position now = player.getCurrentPosition();
        Position targetPosition = player.getCurrentPosition().getNeighbor(direction);
        MapTile[][] map = App.dataManager.getCurrentGame().getMap();
        int x = targetPosition.getX();
        int y = targetPosition.getY();
        MapTile targetTile = map[x][y];
        if (targetTile.getType() == TileType.GROUND) {
            targetTile.setType(TileType.TILLED_SOIL);
            System.out.println("You tilled the soil at position (" + x + "," + y + ")");
        } else {
            System.out.println("Cannot till this tile: " + targetTile.getType());
        }


    }
}
