package models.enums.environment;
import java.util.*;

public enum Weather {
    SUNNY,
    RAINY,
    STORM,
    SNOW;

    private ArrayList<Season> seasonsAvailable;

    Weather(ArrayList<Season> seasonsAvailable) {
        this.seasonsAvailable = seasonsAvailable;
    }

    public ArrayList<Season> getSeasonsAvailable() {
        return seasonsAvailable;
    }


}
