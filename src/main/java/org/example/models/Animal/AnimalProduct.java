package org.example.models.Animal;

import org.example.models.Item;
import org.example.models.enums.types.*;

public class AnimalProduct implements Item {

    private AnimalProductType type;
    private AnimalProductQuality quality;
    private final Integer price;

    public AnimalProduct(AnimalProductType type, AnimalProductQuality quality) {
        this.type = type;
        this.quality = quality;
        this.price = (int) Math.floor(type.getPrice() * quality.getPriceCoEfficient());
    }

    public AnimalProductType getType() {
        return type;
    }

    public void setType(AnimalProductType type) {
        this.type = type;
    }

    public AnimalProductQuality getQuality() {
        return quality;
    }

    public void setQuality(AnimalProductQuality quality) {
        this.quality = quality;
    }

    @Override
    public String getItemName() {
        return this.type.getDisplayName();
    }
}
