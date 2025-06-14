package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Map.MapComponents;
import org.example.models.Position;
import org.example.models.enums.types.ForagingCropType;

import java.util.Random;

public class ForagingCrop extends MapComponents implements Item {

    private ForagingCropType type;

    public ForagingCrop(Position position) {

        super(position, 1, 1);

        this.type = ForagingCropType.values()[(new Random()).nextInt(ForagingCropType.values().length)];

    }
    public ForagingCrop(Position position, ForagingCropType foragingCropType){
        super(position, 1, 1);
        this.type = foragingCropType;
    }

    public void setType(ForagingCropType type) {
        this.type = type;
    }

    public ForagingCropType getType() {
        return type;
    }

    @Override
    public void update() {

    }


    @Override
    public String getItemName() {
        return "Foraging Crop";
    }

}
