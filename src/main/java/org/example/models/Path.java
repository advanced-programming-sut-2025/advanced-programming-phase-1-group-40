package org.example.models;

import java.util.ArrayList;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;




public class Path {
    ArrayList<Position> pathTiles; // contains origin and destination
    int distanceInTiles;
    int numOfTurns;
    int energyNeeded;

    public ArrayList<Position> getPathTiles() {
        return pathTiles;
    }

    public int getEnergyNeeded() {
        return energyNeeded;
    }

    public int getNumOfTurns() {
        return numOfTurns;
    }

    public int getDistanceInTiles() {
        return distanceInTiles;
    }
}
