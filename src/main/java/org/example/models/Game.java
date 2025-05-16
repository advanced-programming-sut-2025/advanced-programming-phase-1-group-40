package org.example.models;

import org.example.controller.Game.GameController;
import org.example.models.Map.*;
import org.example.models.enums.FriendshipLevel;
import org.example.models.enums.Menu;
import org.example.models.enums.enviroment.Time;
import org.example.models.enums.enviroment.Weather;package org.example.models;

import org.example.controller.Game.GameController;
import org.example.models.Map.*;
import org.example.models.enums.FriendshipLevel;
import org.example.models.enums.Menu;
import org.example.models.enums.enviroment.Time;
import org.example.models.enums.enviroment.Weather;
import org.example.models.enums.types.NPCType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;


public class Game {

    private final Integer gameID;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Farm> farms;
    private HashMap<Player, Farm> playerFarms;
    private MapTile[][] map;
    private User gameLoader;
    private Player currentTurnPlayer;
    private Player creator;
    private Time time;
    private Weather weather;
    private Weather futureWeather;
    private HashMap<String, Boolean> terminationVotes;
    private ArrayList<NPC> npcs;



    public Game(Player creator, ArrayList<Player> players) {



        this.gameID = App.dataManager.getGames().size() + 1;
        this.players = players;
        this.time = new Time();
        this.map = new MapTile[110][];
        this.farms = new ArrayList<>();
        this.currentTurnPlayer = creator;
        this.creator = creator;


        this.npcs = new ArrayList<>();
        HashMap<Human, FriendshipWithNPC> friendships = new HashMap<>();
        for (Player player : players) {
            friendships.put(player, new FriendshipWithNPC(0, FriendshipLevel.STRANGER));
        }
        for (NPCType npcType : NPCType.values()) {
            NPC npc = new NPC(friendships, npcType);
            npcs.add(npc);
        }
        
    }

    public NPC getNPCByName(String name) {
        for (NPC npc : npcs) {
            if (npc.getName().equals(name)) {
                return npc;
            }
        }
        return null;
    }

    public Weather getFutureWeather() {
        return futureWeather;
    }

    public void setFutureWeather(Weather futureWeather) {
        this.futureWeather = futureWeather;
    }

    public void createFullMap() {
    // Determine offsets by the number of farms
    int farmCount = farms.size();
    ArrayList<int[]> offsets = new ArrayList<>();

    if (farmCount == 2) {
        this.map = new MapTile[110][60];
        for(int x=0; x<110; x++){
            for(int y=0; y<60; y++){
                map[x][y] = new MapTile(new Position(x,y), TileType.GROUND);
            }
        }
        
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
    } else if (farmCount == 3) {
        this.map = new MapTile[110][110];
        for(int x=0; x<110; x++){
            for(int y=0; y<110; y++){
                map[x][y] = new MapTile(new Position(x,y), TileType.GROUND);
            }
        }
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
        offsets.add(new int[]{0, 60});
    } else if (farmCount == 4) {
        this.map = new MapTile[110][110];
        for(int x=0; x<110; x++){
            for(int y=0; y<110; y++){
                map[x][y] = new MapTile(new Position(x,y), TileType.GROUND);
            }
        }
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
        offsets.add(new int[]{0, 60});
        offsets.add(new int[]{60, 60});
    }

    // Copy each farm's map into the main map
    for (int i = 0; i < farms.size() && i < offsets.size(); i++) {
        Farm farm = farms.get(i);
        // Assuming each Farm has a method getMap() returning a 50x50 MapTile[][]
        MapTile[][] farmMap = farm.getTiles();
        int offsetX = offsets.get(i)[0];
        int offsetY = offsets.get(i)[1];

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                // Overwrite the full map's tile with the farm's corresponding tile
                map[offsetX + x][offsetY + y] = farmMap[x][y];
            }
        }

        addShops();
    }
}

public void addShops(){
    for(int x = 53; x < 59; x++){
        for(int y = 2; y < 8; y++){
            map[x][y].setType(TileType.BLACKSMITH);
        }
    }

    for(int x = 53; x < 59; x++){
        for(int y = 12; y < 17; y++){
            map[x][y].setType(TileType.JOJAMART);
        }
    }

    for(int x = 53; x < 59; x++){
        for(int y = 30; y < 36; y++){
            map[x][y].setType(TileType.PIERRE_GENERAL_STORE);
        }
    }

    for(int x = 5; x < 11; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.CARPENTER_SHOP);
        }
    }

    for(int x = 30; x < 35; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.FISH_SHOP);
        }
    }

    for(int x = 70; x < 76; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.MARNIES_RANCH);
        }
    }

    for(int x = 90; x < 95; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.THE_STARDROP_SALOON);
        }
    }
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

    public MapTile[][] getMap() {
        return map;
    }

    public void setMap(MapTile[][] map) {
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


    public Player nextTurn() {
        // TODO
        return null;
    }
}

import org.example.models.enums.types.NPCType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;


public class Game {

    private final Integer gameID;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Farm> farms;
    private HashMap<Player, Farm> playerFarms;
    private MapTile[][] map;
    private User gameLoader;
    private Player currentTurnPlayer;
    private Player creator;
    private Time time;
    private Weather weather;
    private Weather futureWeather;
    private HashMap<String, Boolean> terminationVotes;
    private ArrayList<NPC> npcs;



    public Game(Player creator, ArrayList<Player> players) {



        this.gameID = App.dataManager.getGames().size() + 1;
        this.players = players;
        this.time = new Time();
        this.map = new MapTile[110][];
        this.farms = new ArrayList<>();
        this.currentTurnPlayer = creator;
        this.creator = creator;


//        this.npcs = new ArrayList<>();
//        HashMap<Human, FriendshipWithNPC> friendships = new HashMap<>();
//        for (Player player : players) {
//            friendships.put(player, new FriendshipWithNPC(0, FriendshipLevel.STRANGER));
//        }
//        for (NPCType npcType : NPCType.values()) {
//            NPC npc = new NPC(friendships, npcType);
//            npcs.add(npc);
//        }
        
    }

    public NPC getNPCByName(String name) {
        for (NPC npc : npcs) {
            if (npc.getName().equals(name)) {
                return npc;
            }
        }
        return null;
    }

    public User getGameLoader() {
        return gameLoader;
    }

    public void setGameLoader(User gameLoader) {
        this.gameLoader = gameLoader;
    }

    public Weather getFutureWeather() {
        return futureWeather;
    }

    public void setFutureWeather(Weather futureWeather) {
        this.futureWeather = futureWeather;
    }

    public void createFullMap() {
    // Determine offsets by the number of farms
    int farmCount = farms.size();
    ArrayList<int[]> offsets = new ArrayList<>();

    if (farmCount == 2) {
        this.map = new MapTile[110][60];
        for(int x=0; x<110; x++){
            for(int y=0; y<60; y++){
                map[x][y] = new MapTile(new Position(x,y), TileType.GROUND);
            }
        }
        
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
    } else if (farmCount == 3) {
        this.map = new MapTile[110][110];
        for(int x=0; x<110; x++){
            for(int y=0; y<110; y++){
                map[x][y] = new MapTile(new Position(x,y), TileType.GROUND);
            }
        }
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
        offsets.add(new int[]{0, 60});
    } else if (farmCount == 4) {
        this.map = new MapTile[110][110];
        for(int x=0; x<110; x++){
            for(int y=0; y<110; y++){
                map[x][y] = new MapTile(new Position(x,y), TileType.GROUND);
            }
        }
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
        offsets.add(new int[]{0, 60});
        offsets.add(new int[]{60, 60});
    }

    // Copy each farm's map into the main map
    for (int i = 0; i < farms.size() && i < offsets.size(); i++) {
        Farm farm = farms.get(i);
        // Assuming each Farm has a method getMap() returning a 50x50 MapTile[][]
        MapTile[][] farmMap = farm.getTiles();
        int offsetX = offsets.get(i)[0];
        int offsetY = offsets.get(i)[1];

        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                // Overwrite the full map's tile with the farm's corresponding tile
                map[offsetX + x][offsetY + y] = farmMap[x][y];
            }
        }

        addShops();
    }
}

public void addShops(){
    for(int x = 53; x < 59; x++){
        for(int y = 2; y < 8; y++){
            map[x][y].setType(TileType.BLACKSMITH);
        }
    }

    for(int x = 53; x < 59; x++){
        for(int y = 12; y < 17; y++){
            map[x][y].setType(TileType.JOJAMART);
        }
    }

    for(int x = 53; x < 59; x++){
        for(int y = 30; y < 36; y++){
            map[x][y].setType(TileType.PIERRE_GENERAL_STORE);
        }
    }

    for(int x = 5; x < 11; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.CARPENTER_SHOP);
        }
    }

    for(int x = 30; x < 35; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.FISH_SHOP);
        }
    }

    for(int x = 70; x < 76; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.MARNIES_RANCH);
        }
    }

    for(int x = 90; x < 95; x++){
        for(int y = 53; y < 59; y++){
            map[x][y].setType(TileType.THE_STARDROP_SALOON);
        }
    }
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

    public MapTile[][] getMap() {
        return map;
    }

    public void setMap(MapTile[][] map) {
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


    public Player nextTurn() {
        // TODO
        return null;
    }
}
