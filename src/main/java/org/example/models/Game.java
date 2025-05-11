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
     * Move to the next player's turn
     * @return The player whose turn it is now
     */
    public Player nextTurn() {

        int currentIndex = players.indexOf(currentTurnPlayer);
        int nextIndex = (currentIndex + 1) % numberOfPlayers;
        

        if (nextIndex == 0) {

            if ( time.getHour() >= 22) {

                time.setHour(9);

                if ( time.getWeekday().getDayIndex() >= 6 ){
                    time.setWeekday(Weekday.MONDAY);
                }
                else{
                    time.setWeekday(Weekday.values()[time.getWeekday().getDayIndex()+1]);
                }

                if ( time.getDate() >= 28 ){

                    time.setDate(1);

                    if ( time.getMonth().getMonthIndex() >= 11 ){
                        time.setYear(time.getYear()+1);
                        time.setMonth(Month.JANUARY);
                    }
                    else{
                        time.setMonth(Month.values()[time.getMonth().getMonthIndex()+1]);
                    }


                }
                else{
                    time.setDate(time.getDate()+1);
                }



            }
            else{

                time.setHour( time.getHour() + 1 );

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
