package org.example.models;

import org.example.models.enums.enviroment.Season;
import org.example.models.enums.enviroment.Weather;

public class Situation {
    private final int hour;
    private final Season season;
    private final Weather weather;

    public Situation(int hour, Season season, Weather weather) {
        this.hour = hour;
        this.season = season;
        this.weather = weather;
    }

    public int getHour() {
        return hour;
    }

    public Season getSeason() {
        return season;
    }

    public Weather getWeather() {
        return weather;
    }
}
