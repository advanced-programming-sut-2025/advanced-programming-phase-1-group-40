package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.enviroment.Direction;
import org.example.models.enums.types.ToolTypes;
import org.example.models.enums.Skill;
import org.example.models.Map.MapTile;
import org.example.models.Map.TileType;

public class Scythe extends Tool {

    public Scythe() {
        super(ToolTypes.SCYTHE, Skill.FARMING); // Scythe uses Farming skill
    }

    @Override
    public String getItemName() {
        return material == null ? "Scythe (Unupgraded)" : "Scythe (" + material.name() + ")";
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Swinging scythe in direction: " + direction);
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        Position now = player.getCurrentPosition();
        Position targetPosition = now.getNeighbor(direction);

        MapTile[][] map = App.dataManager.getCurrentGame().getMap();

        int x = targetPosition.getX();
        int y = targetPosition.getY();

        MapTile targetTile = map[x][y];
        TileType tileType = targetTile.getType();

        if (tileType == TileType.GRASS || tileType == TileType.FORAGEABLE) {
            targetTile.setType(TileType.GROUND);  // after cutting, tile becomes ground
            System.out.println("You cut down " + tileType.name().toLowerCase() + " at (" + x + "," + y + ")");
        } else {
            System.out.println("You cannot cut this tile with the scythe: " + tileType);
        }
    }
}
