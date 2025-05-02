package org.example.models;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.Map.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.ArrayList;

public class Farm {
    private ArrayList<Tile> mapTiles;
    private ArrayList<Cabin> cabin;
    private ArrayList<Greenhouse> greenhouse;
    private ArrayList<Quarry> quarry;
    private ArrayList<Lake> lakes;
    private ArrayList<Crop> plantedCrops;
    private ArrayList<Tree> trees;

    public Result putTree(Tree tree) {

        return null;
    }

    public Result putStone(Stone stone) {

        return null;
    }

    ///     Inja foraging haro put mikone

    // public result putForaging()



//    public Result placeScarecrow(Position position) {
//
//        // check if it can be placed here or not
//
//    }
//
//    public void plant(models.PlantSource seed, Position position) {
//
//    }
//
//    public void showPlant(Position position) {
//
//    }
//
//    public void fertilize(Fertilizer fertilizer, Position position) {
//
//    }
//
//    public void harvest(Harvestable harvestable) {
//
//    }

    public ArrayList<Tile> getMapTiles() {
        return this.mapTiles;
    }

    public ArrayList<Cabin> getCabin() {
        return this.cabin;
    }

    public ArrayList<Greenhouse> getGreenhouse() {
        return this.greenhouse;
    }

    public Quarry getQuarry() {
        return this.quarry.get(0);
    }

    public ArrayList<Lake> getLakes() {
        return this.lakes;
    }

    public ArrayList<Crop> getPlantedCrops() {
        return this.plantedCrops;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

}