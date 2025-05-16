package org.example.models.Animal;

import org.example.models.Item;
import org.example.models.enums.types.*;
import org.example.models.enums.*;

public class AnimalProduct  {

    private AnimalProducts type;
    private AnimalProductQuality quality;

    public AnimalProduct(AnimalProducts type, AnimalProductQuality quality) {
        this.type = type;
        this.quality = quality;
    }

    public AnimalProducts getType() {
        return type;
    }

    public void setType(AnimalProducts type) {
        this.type = type;
    }

    public AnimalProductQuality getQuality() {
        return quality;
    }

    public void setQuality(AnimalProductQuality quality) {
        this.quality = quality;
    }
}
