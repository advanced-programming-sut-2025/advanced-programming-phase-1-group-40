package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Map.MapComponents;
import org.example.models.Position;
import org.example.models.enums.types.ForagingCropType;

import java.util.Random;

public class ForagingCrop extends MapComponents implements Item {

    private final ForagingCropType type;

    public ForagingCrop(Position position) {

        super(position, 1, 1);

        this.type = ForagingCropType.values()[(new Random()).nextInt(ForagingCropType.values().length)];

    }

    public ForagingCropType getType() {
        return type;
    }

    @Override
    public void update() {

    }
}
