package org.example.models;

import org.example.models.Map.Farm;
import org.example.models.Map.MapTile;
import org.example.models.enums.enviroment.Time;
import org.example.models.enums.enviroment.Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Game {

    private final Integer gameID;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Farm> farms;
    private HashMap<Player, Farm> playerFarms;
    private ArrayList<MapTile> map;
    private Player currentTurnPlayer;
    private Player creator;
    private Time time;
    private Weather weather;




    public Game(Player creator, ArrayList<Player> players) {


        this.gameID = App.dataManager.getGames().get( App.dataManager.getGames().size() -1 ).getGameID() + 1;
        this.players = players;
        this.time = new Time();
        this.map = new ArrayList<>();
        this.farms = new ArrayList<>();

        
    }


    public void assignFarmToPlayer(Player player, Farm farm) {
        if (playerFarms == null) {
            playerFarms = new HashMap<>();
        }
        playerFarms.put(player, farm);
    }


    public Integer getGameID() {
        return gameID;
    }

    public void setFarms(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    public HashMap<Player, Farm> getPlayerFarms() {
        return playerFarms;
    }

    public void setPlayerFarms(HashMap<Player, Farm> playerFarms) {
        this.playerFarms = playerFarms;
    }

    public ArrayList<MapTile> getMap() {
        return map;
    }

    public void setMap(ArrayList<MapTile> map) {
        this.map = map;
    }


    public void setTime(Time time) {
        this.time = time;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }


    public Time getTime() {
        return time;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public Player getCurrentTurnPlayer() {
        return currentTurnPlayer;
    }

    public void setCurrentTurnPlayer(Player player) {
        this.currentTurnPlayer = player;
    }


    public Player getCreator() {
        return creator;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    /**
     * Adds a farm to the game
     * @param farm The farm to add
     */
    public void addFarm(Farm farm) {
        if (farms == null) {
            farms = new ArrayList<>();
        }
        farms.add(farm);
    }

    /**
     * Gets the farm for a specific player
     * @param player The player to get the farm for
     * @return The player's farm, or null if not found
     */
    public Farm getFarmForPlayer(Player player) {
        if (farms == null) {
            return null;
        }

        for (Farm farm : farms) {
            if (farm.getOwner() != null && farm.getOwner().getUsername().equals(player.getUsername())) {
                return farm;
            }
        }

        return null;
    }

    /**
     * Initializes the game time
     */
    public void initializeTime() {
        if (time == null) {
            time = new Time();
        }
    }

    /**
     * Move to the next player's turn
     * @return The next player
     */
    public Player nextTurn() {
        int currentIndex = players.indexOf(currentTurnPlayer);
        int nextIndex = (currentIndex + 1) % players.size();

        // If we've gone through all players, advance the time
        if (nextIndex == 0) {
//            everyOnePlayed = true;
            // TODO
            //time.advanceHour();
        }

        currentTurnPlayer = players.get(nextIndex);
        return currentTurnPlayer;
    }

    /**
     * Registers a player's vote for termination
     * @param player The player voting
     * @param vote true for yes, false for no
     * @return true if all players have voted to terminate, false otherwise
     */
    public boolean voteForTermination(Player player, boolean vote) {
        if (terminationVotes == null) {
            terminationVotes = new HashMap<>();
        }

        terminationVotes.put(player.getUsername(), vote);

        // Check if all players have voted yes
        boolean allVotedYes = true;
        for (Player p : players) {
            Boolean playerVote = terminationVotes.get(p.getUsername());
            if (playerVote == null || !playerVote) {
                allVotedYes = false;
                break;
            }
        }

        return allVotedYes;
    }///////ayohanaas dont forget this part


    /**
     * Checks if a player is part of this game
     * @param username The username to check
     * @return true if the player is in this game, false otherwise
     */
    public boolean hasPlayer(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a player by username
     * @param username The username to look for
     * @return The player with the given username, or null if not found
     */
    public Player getPlayerByUsername(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                return player;
            }
        }
        return null;
    }

    public FriendshipWithNPC getFriendship(Player player, Player otherPlayer) {
        // TODO
        return null;
    }

    public String getUserFriendship(Player player, Player targetPlayer) {
        // TODO
        return null;
    }

    public HashMap<Player, HashMap<Player, HashMap<String, Boolean>>> getTalkHistory() {
        // TODO
        return null;
    }

}
