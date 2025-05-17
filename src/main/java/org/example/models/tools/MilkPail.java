package org.example.models.tools;
import org.example.models.*;
import org.example.models.Animal.Animal;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;
/*public class MilkPail extends Tool {

    public MilkPail() {
        super(ToolTypes.MILK_PAIL, Skill.FARMING);
    }

    @Override
    public String getItemName() {
        return "Milk Pail";
    }

    @Override
    public int getBaseEnergyCost() {
        return 4;
    }

    @Override
    public void useTool(Direction direction) {
        System.out.println("Milking in direction: " + direction);
    }
}
*/

public class MilkPail extends Tool {

    public MilkPail() {
        super(ToolTypes.MILK_PAIL, Skill.FARMING);
    }

    @Override
    public String getItemName() {
        return "Milk Pail";
    }

    @Override
    public void useTool(Direction direction) {
       /* Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

        Position targetPosition = player.getCurrentPosition().getNeighbor(direction);
        Animal targetAnimal = App.dataManager.getCurrentGame().getAnimalPosition(targetPosition);

        if (targetAnimal == null) {
            System.out.println("No animal to milk in that direction.");
            return;
        }

        if (!targetAnimal.canBeMilked()) {
            System.out.println("That animal cannot be milked right now.");
            return;
        }

        // Milk the animal
        boolean success = targetAnimal.milk();

        if (success) {
            //player.consumeEnergy(getEnergyCost());
            System.out.println("You milked the " + targetAnimal.getType() + " successfully.");
            // Add milk item to inventory, for example:
            player.getInventory().addItem(targetAnimal.getMilkItem());
        } else {
            System.out.println("The animal has no milk to give right now.");
        }
    }*/
}}
