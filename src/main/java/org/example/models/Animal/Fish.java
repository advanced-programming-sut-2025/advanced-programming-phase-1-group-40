package org.example.models.Animal;

import org.example.models.enums.types.FishType;
import org.example.models.enums.types.FishingRodType;

public class Fish {


    private final FishType fish;
    private final FishingRodType fishingRod;

    private final double fishQuality;

    public Fish(FishType fish, FishingRodType fishingRod) {
        this.fish = fish;
        this.fishingRod = fishingRod;
        // TODO
        this.fishQuality = 1.0;
    }

    public FishType getFish() {
        return fish;
    }

    public FishingRodType getFishingRod() {
        return fishingRod;
    }

    public double getFishQuality() {
        return fishQuality;
    }

    
    
}
