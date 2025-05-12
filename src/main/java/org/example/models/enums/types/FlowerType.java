package org.example.models.enums.types;

import org.example.models.Item;


public enum FlowerType{

    FAIRY_ROSE(CropType.FAIRY_ROSE),
    POPPY(CropType.POPPY),
    SUMMER_SPANGLE(CropType.SUMMER_SPANGLE),
    SWEET_PEA(ForagingCropType.SWEET_PEA),
    SUNFLOWER(CropType.SUNFLOWER),
    TULIP(CropType.TULIP);

    private final Item item;

    FlowerType(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }



}
