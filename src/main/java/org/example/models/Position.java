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

    Position(int x, int y) {

        this.x = x;
        this.y = y;

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
