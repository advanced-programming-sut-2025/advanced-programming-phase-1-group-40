package org.example.models.Map;

import org.example.models.Position;

import java.util.ArrayList;

public abstract class MapComponents {

    private Position position;

    private ArrayList<Position> tiles;

    public Position getPosition() {
        return position;
    }

    public ArrayList<Position> getTiles() {
        return tiles;
    }

}
