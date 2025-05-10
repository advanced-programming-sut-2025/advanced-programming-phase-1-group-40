package org.example.models;

import org.example.models.Map.Farm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a game session with multiple players
 */
public class Game {
    private static int nextGameId = 1;
    
    private int gameId;
    private List<Player> players;
    private List<Farm> farms;
    private Player currentTurnPlayer;
    private int currentDay;
    private int currentHour;
    private boolean active;
    private Map<String, Boolean> terminationVotes;
    private Player creator;
    
    public Game() {
        this.gameId = nextGameId++;
        this.players = new ArrayList<>();
        this.farms = new ArrayList<>();
        this.currentDay = 1;
        this.currentHour = 6; // Start at 6 AM
        this.active = true;
        this.terminationVotes = new HashMap<>();
    }
    
    public int getGameId() {
        return gameId;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public List<Farm> getFarms() {
        return farms;
    }
    
    public Player getCurrentTurnPlayer() {
        return currentTurnPlayer;
    }
    
    public void setCurrentTurnPlayer(Player player) {
        this.currentTurnPlayer = player;
    }
    
    public int getCurrentDay() {
        return currentDay;
    }
    
    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }
    
    public int getCurrentHour() {
        return currentHour;
    }
    
    public void setCurrentHour(int currentHour) {
        this.currentHour = currentHour;
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
     * Move to the next player's turn
     * @return The player whose turn it is now
     */
    public Player nextTurn() {
        int currentIndex = players.indexOf(currentTurnPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        
        // If we've gone through all players, increment the hour
        if (nextIndex == 0) {
            currentHour++;
            
            // If it's past midnight, increment the day and reset to 6 AM
            if (currentHour >= 24) {
                currentDay++;
                currentHour = 6;
            }
        }
        
        currentTurnPlayer = players.get(nextIndex);
        return currentTurnPlayer;
    }
    
    /**
     * Vote to terminate the game
     * @param player The player voting
     * @param vote True to vote for termination, false otherwise
     * @return True if all players have voted to terminate, false otherwise
     */
    public boolean voteForTermination(Player player, boolean vote) {
        terminationVotes.put(player.getUsername(), vote);
        
        // Check if all players have voted to terminate
        if (terminationVotes.size() == players.size()) {
            for (boolean playerVote : terminationVotes.values()) {
                if (!playerVote) {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
    
    /**
     * Reset termination votes
     */
    public void resetTerminationVotes() {
        terminationVotes.clear();
    }
    
    /**
     * Check if a player is in this game
     * @param username The username to check
     * @return True if the player is in the game, false otherwise
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
     * Get a player by username
     * @param username The username to search for
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
}
