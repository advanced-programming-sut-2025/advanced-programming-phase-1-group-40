package models.farming;

import models.farming.PlantSource;
import models.Position;
import models.enums.environment.Season;

import java.util.ArrayList;

public abstract class Harvestable {

    private String name;
    private models.farming.PlantSource source;
    private int numOfStages;
    private ArrayList<Integer> stages;
    private int totalHarvestTime;
    private int baseSellPrice;  
    private boolean isEdible;
    private int energy;
    private ArrayList<Season> seasons;
    private boolean canBecomeGiant;
    private boolean isEnormous;
    private Position position;

    private int xCoordinate,yCoordinate;

    public void showInfo() {

    }

    public String getName() {
        return name;
    }

    public PlantSource getSource() {
        return source;
    }

    public int getNumOfStages() {
        return numOfStages;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getEnergy() {
        return energy;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public boolean isCanBecomeGiant() {
        return canBecomeGiant;
    }

    public boolean isGiant() {
        return true;
    }

    public Position getPosition() {
        return position;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}
