package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;




public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {

        this.x = x;
        this.y = y;

    }
    public Position getNeighbor(Direction direction) {
        switch (direction) {
            case UP:return new Position(x - 1, y);
            case DOWN:return new Position(x + 1, y);
            case LEFT:return new Position(x, y - 1);
            case RIGHT:return new Position(x, y + 1);
            default:return new Position(x, y);
        }
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
