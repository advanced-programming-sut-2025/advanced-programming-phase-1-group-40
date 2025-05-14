package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Map.MapComponents;
import org.example.models.Position;
import org.example.models.enums.types.CropType;
import org.example.models.enums.types.ForagingMineralType;

import java.io.Serializable;
import java.util.Random;

public class Crop extends MapComponents implements Item{

    private final CropType cropType;

    public Crop(Position position) {

        super(position, 1, 1);
        this.cropType = CropType.values()[(new Random()).nextInt(ForagingMineralType.values().length)];

    }

    public CropType getCropType() {
        return cropType;
    }

    @Override
    public void update() {

    }


    public boolean isReadyToHarvest() {
        // TODO
        return true;
    }

    @Override
    public String getItemName() {
        return "Crop";
    }

}
