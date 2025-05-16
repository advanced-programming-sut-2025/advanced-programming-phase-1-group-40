package org.example.models.Animal;

public enum AnimalProductQuality {

    NORMAL("Normal",0.0,0.5,1.0),
    SILVER("Normal",0.5,0.7,1.25),
    GOLD("Normal",0.7,0.9,1.5),
    IRIDIUM("Normal",0.9,1.0,2.0);

    private final String qualityName;
    private final Double minQuality;
    private final Double maxQuality;
    private final Double priceCoEfficient;

    AnimalProductQuality(String qualityName, Double minQuality, Double maxQuality, Double priceCoEfficient) {
        this.qualityName = qualityName;
        this.priceCoEfficient = priceCoEfficient;
        this.minQuality = minQuality;
        this.maxQuality = maxQuality;
    }

    public String getQualityName() {
        return qualityName;
    }

    public Double getMinQuality() {
        return minQuality;
    }

    public Double getMaxQuality() {
        return maxQuality;
    }

    public Double getPriceCoEfficient() {
        return priceCoEfficient;
    }
}
