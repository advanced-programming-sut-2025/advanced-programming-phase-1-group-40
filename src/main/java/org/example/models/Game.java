package org.example.models;

import org.example.models.Map.Farm;
import org.example.models.enums.enviroment.Month;
import org.example.models.enums.enviroment.Time;
import org.example.models.enums.enviroment.Weekday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a game session with multiple players
 */
public class Game {

    private final ArrayList<Player> players;
    private ArrayList<Farm> farms;
    private Player currentTurnPlayer;
    private final int numberOfPlayers;
    private boolean everyOnePlayed;
    private boolean active;
    private Map<String, Boolean> terminationVotes;
    private Player creator;
    private Time time;


    public Game(Player... players) {

        everyOnePlayed = false;

        this.players = new ArrayList<>();

        for (Player player : players) {
            this.players.add(player);
        }

        numberOfPlayers = players.length;


        time = new Time();

        this.farms = new ArrayList<>();
        this.active = true;
        this.terminationVotes = new HashMap<>();

    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public boolean isEveryOnePlayed() {
        return everyOnePlayed;
    }

    public Map<String, Boolean> getTerminationVotes() {
        return terminationVotes;
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
    

    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public Player getCreator() {
        return creator;
    }
    
    public void setCreator(Player creator) {
        this.creator = creator;
    }
    
    /**
     * Add a player to the game
     * @param player The player to add
     */
    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            
            // If this is the first player, set them as the creator and current turn player
            if (players.size() == 1) {
                creator = player;
                currentTurnPlayer = player;
            }
        }
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
            everyOnePlayed = true;
            time.advanceHour();
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
    }
    
    /**
     * Reset termination votes
     */
    public void resetTerminationVotes() {
        terminationVotes.clear();
    }
    
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

    public Friendship getFriendship(Player player, Player otherPlayer) {
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
