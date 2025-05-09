package org.example.models;
import java.util.ArrayList;

public class    Game {

    private ArrayList<Farm> farms;
    private ArrayList<org.example.models.Shop> shops;
    private ArrayList<Player> players; // The 3 players
    private int cropGrowthRate;
    private boolean automaticIrrigation;
    private int energyUsageRate;
    private boolean possibilityOfThor;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.farms = new ArrayList<>();
        this.shops = new ArrayList<>();
    }
    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public ArrayList<org.example.models.Shop> getShops() {
        return shops;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getCropGrowthRate() {
        return cropGrowthRate;
    }

    public boolean isAutomaticIrrigation() {
        return automaticIrrigation;
    }

    public int getEnergyUsageRate() {
        return energyUsageRate;
    }

    public boolean isPossibilityOfThor() {
        return possibilityOfThor;
    }
}
