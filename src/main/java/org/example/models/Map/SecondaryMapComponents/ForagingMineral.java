package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Map.MapComponents;
import org.example.models.Position;
import org.example.models.enums.types.ForagingCropType;
import org.example.models.enums.types.ForagingMineralType;

import java.util.Random;

public class ForagingMineral extends MapComponents implements Item {

    private final ForagingMineralType mineralType;

    public ForagingMineral(Position position) {

        super(position, 1, 1);
        this.mineralType = ForagingMineralType.values()[(new Random()).nextInt(ForagingMineralType.values().length)];

    }

    public ForagingMineralType getMineralType() {
        return mineralType;
    }

    @Override
    public void update() {

    }

}
