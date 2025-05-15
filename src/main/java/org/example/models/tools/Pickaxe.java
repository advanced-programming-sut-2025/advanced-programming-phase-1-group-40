package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.Map.MapTile;
import org.example.models.Map.TileType;


public class Pickaxe extends Tool {

    public Pickaxe() {
        super(ToolTypes.PICKAXE, Skill.MINING);
    }

    @Override
    public String getItemName() {
        return material == null ? "Pickaxe (Unupgraded)" : "Pickaxe (" + material.name() + ")";
    }

    @Override
    public void useTool(Direction direction) {
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

      /*  if (!player.hasEnoughEnergy(getEnergyCost())) {
            System.out.println("Not enough energy to use Pickaxe.");
            return;
        }
*/
        Position targetPosition = player.getCurrentPosition().getNeighbor(direction);
        MapTile[][] map = App.dataManager.getCurrentGame().getMap();
        int x = targetPosition.getX();
        int y = targetPosition.getY();


        MapTile targetTile = map[x][y];
        TileType tileType = targetTile.getType();

        if (tileType == TileType.STONE || tileType == TileType.ORE) {
            targetTile.setType(TileType.GROUND);
           // player.consumeEnergy(getEnergyCost());
            System.out.println("You used the pickaxe and broke the " + tileType + " at (" + x + "," + y + ").");
        } else {
            System.out.println("Cannot use pickaxe on " + tileType);
        }
    }
}
