package org.example.models.tools;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.SkillLevel;
import org.example.models.enums.Skill;
import org.example.models.enums.enviroment.Direction;
import org.example.models.Player;

public class IridiumRod extends FishingRod{
    public IridiumRod() {
        super("Iridium Rod",4,4);

    }
    @Override
    public void useTool(Direction direction) {
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();

        if (!player.hasEnoughEnergy(getEnergyCost())) {
            System.out.println("Not enough energy to fish.");
            return;
        }

        player.consumeEnergy(getEnergyCost());
        System.out.println("You used the Iridium Rod and caught a fish!");
    }


}

