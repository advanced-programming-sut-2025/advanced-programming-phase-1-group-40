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

}
