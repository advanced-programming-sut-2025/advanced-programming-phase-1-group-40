package org.example.models.enums.enviroment;

public enum Weather {
    SUNNY(1.5),
    RAINY(1.2),
    STORMY(0.5),
    SNOWY(0.5);

    private final double weatherCoEfficient;

    Weather(double weatherCoEfficient) {

        this.weatherCoEfficient = weatherCoEfficient;

    }

    public double getWeatherCoEfficient() {
        return weatherCoEfficient;
    }

}
