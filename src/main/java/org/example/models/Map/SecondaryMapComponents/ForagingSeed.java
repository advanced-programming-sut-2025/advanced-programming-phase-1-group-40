package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Map.MapComponents;
import org.example.models.Position;
import org.example.models.enums.types.ForagingSeedType;

import java.util.Random;

public class ForagingSeed extends MapComponents implements Item {

    private final ForagingSeedType seedType;

    public ForagingSeed(Position position) {

        super(position, 1,1);
        this.seedType = ForagingSeedType.values()[(new Random()).nextInt(ForagingSeedType.values().length)];

    }

    // public ForagingSeed(Position position, ForagingSeedType seedType) {
    //     super(position, 1, 1);
    //     this.seedType = seedType;
    // }

    public ForagingSeedType getSeedType() {
        return seedType;
    }

    @Override
    public void update() {

    }

    @Override
    public String getItemName() {
        return "Foraging Seed";
    }


}
