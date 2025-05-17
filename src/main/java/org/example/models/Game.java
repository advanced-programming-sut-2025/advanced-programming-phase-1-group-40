package org.example.models;

import org.example.controller.Game.GameController;
import org.example.models.Map.*;
import org.example.models.enums.FriendshipLevel;
import org.example.models.enums.Menu;
import org.example.models.enums.enviroment.Time;
import org.example.models.enums.enviroment.Weather;


import org.example.controller.Game.GameController;
import org.example.models.Map.*;
import org.example.models.enums.FriendshipLevel;
import org.example.models.enums.Menu;
import org.example.models.enums.enviroment.Time;
import org.example.models.enums.enviroment.Weather;
import org.example.models.enums.types.NPCType;

import java.util.*;

import static java.util.Arrays.asList;


public class Game {

    private final Integer gameID;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Farm> farms;
    private HashMap<Player, Farm> playerFarms;
    private MapTile[][] map;
    private User gameLoader;
    private Player currentTurnPlayer;
    private Farm currentFarm;
    private Position playerMapPosition;
    private Player creator;
    private Time time;
    private Weather weather;
    private Weather futureWeather;
    private HashMap<String, Boolean> terminationVotes;
    private ArrayList<NPC> npcs;
    private ArrayList<Trade> trades;


    public Game(Player creator, ArrayList<Player> players) {


        this.trades = new ArrayList<>();
        this.gameID = App.dataManager.getGames().size() + 1;
        this.players = players;
        this.time = new Time();
        this.map = new MapTile[110][];
        this.farms = new ArrayList<>();
        this.currentTurnPlayer = creator;
        this.creator = creator;
        this.playerMapPosition = new Position(0, 0);
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (i == 0) player.setCurrentPosition(0, 0);
            else if (i == 1) player.setCurrentPosition(60, 0);
            else if (i == 2) player.setCurrentPosition(0, 60);
            else if (i == 3) player.setCurrentPosition(60, 60);
        }


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


    public Farm getCurrentFarm() {
        return currentFarm;
    }

    public Position getPlayerMapPosition() {
        return playerMapPosition;
    }

    public HashMap<String, Boolean> getTerminationVotes() {
        return terminationVotes;
    }

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }

    public ArrayList<Trade> getTrades() {
        return trades;
    }

    public void addTrade(Trade trade) {
        this.trades.add(trade);
    }

    public void removeTrade(Trade trade) {
        this.trades.remove(trade);
    }

    public NPC getNPCByName(String name) {
        for (NPC npc : npcs) {
            if (npc.getName().equals(name)) {
                return npc;
            }
        }
        return null;
    }

    public void setCurrentFarm(Player currentPlayer){
        if(playerFarms != null){
        this.currentFarm = playerFarms.get(currentPlayer);
        }
    }

    public void handleWalk(String input, Scanner scanner){
        String[] parts = input.split("\\s+");
        int x = Integer.parseInt(parts[2]);
        int y = Integer.parseInt(parts[3]);
        WalkResult walkResult = findShortestPath(map, 
        currentTurnPlayer.getCurrentPosition().getX(), 
        currentTurnPlayer.getCurrentPosition().getY(), x, y, map.length, map[0].length);
        if(walkResult.getDistance() == -1){
            System.out.println("Cannot reach this position.");
        }
        else{
            //we have to ask and handle the energy part here,,,
            //
            //
            //
            //
            int energyNeeded = (walkResult.getDistance() + 10*walkResult.getTurns())/20;
            System.out.println("Energy needed to go to your destination is" + energyNeeded);
            System.out.println("Do you want to go there? (yes/no)");
            String answer = scanner.nextLine();
            if(answer.equals("yes")){
                currentTurnPlayer.consumeEnergy(energyNeeded);
        if(players.indexOf(currentTurnPlayer) == 0 && x<50 && y<50){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x, y));
        }
        else if(players.indexOf(currentTurnPlayer) == 1 && x<110 && x >= 60 && y<50){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x-60, y));
        }
        else if(players.indexOf(currentTurnPlayer) == 2 && y<110 && y >= 60 && x<50){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x, y-60));
        }
        else if(players.indexOf(currentTurnPlayer) == 3 && y<110 && y >= 60 && x<110 && x >= 60){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x-60, y-60));
        }
        else if(y>=110 || x>=110){
            System.out.println("The position you entered is out of bounds.");
        }
        else{
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
        }
        System.out.println("Done");
    }
    else{
        System.out.println("OK");
        return;
    }
        

    }

    }


    public void teleport(String input){
        String[] parts = input.split("\\s+");
        int x = Integer.parseInt(parts[2]);
        int y = Integer.parseInt(parts[3]);
            if(players.indexOf(currentTurnPlayer) == 0 && x<50 && y<50){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x, y));
        }
        else if(players.indexOf(currentTurnPlayer) == 1 && x<110 && x >= 60 && y<50){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x-60, y));
        }
        else if(players.indexOf(currentTurnPlayer) == 2 && y<110 && y >= 60 && x<50){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x, y-60));
        }
        else if(players.indexOf(currentTurnPlayer) == 3 && y<110 && y >= 60 && x<110 && x >= 60){
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
            currentTurnPlayer.setFarmPosition(new Position(x-60, y-60));
        }
        else if(y>=110 || x>=110){
            System.out.println("The position you entered is out of bounds.");
        }
        else{
            currentTurnPlayer.setCurrentPosition(new Position(x, y));
        }
        System.out.println("Done");
    }

    public void helpReadingMap(){
        final String RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String BG_BLUE = "\u001B[44m";
        final String BG_GREEN = "\u001B[42m";

        StringBuilder sb = new StringBuilder();
        sb.append("Ground is shown by: ").append(".").append("\n");
        sb.append("Tilled soil is shown by: ").append(YELLOW).append(".").append(RESET).append("\n");
        sb.append("Watered soil is shown by: ").append(BLUE).append(".").append(RESET).append("\n");
        sb.append("Planted and watered soil is shown by: ").append(GREEN).append("w").append(RESET).append("\n");
        sb.append("Planted but not watered soil is shown by: ").append(RED).append("p").append(RESET).append("\n");
        sb.append("Water is shown by: ").append(BG_BLUE).append("W").append(RESET).append("\n");
        sb.append("Cabin is shown by: ").append("C").append("\n");
        sb.append("Greenhouse is shown by: ").append("G").append("\n");
        sb.append("Barn is shown by: ").append(YELLOW).append("B").append(RESET).append("\n");
        sb.append("Quarry is shown by: ").append("Q").append("\n");
        sb.append("Tree is shown by: ").append(GREEN).append("T").append(RESET).append("\n");
        sb.append("Stone is shown by: ").append(YELLOW).append("S").append(RESET).append("\n");
        sb.append("Foragable is shown by: ").append(GREEN).append("F").append(RESET).append("\n");
        sb.append("Path is shown by: ").append("#").append("\n");
        sb.append("Unknown component is shown by: ").append("?").append("\n");
        System.out.println(sb);

    }

    public void setPlayerMapPosition(Position playerMapPosition) {
        this.playerMapPosition = playerMapPosition;
    }

    public void handleUpdateMap(){

        ArrayList<int[]> offsets = new ArrayList<>();
        offsets.add(new int[]{0, 0});
        offsets.add(new int[]{60, 0});
        offsets.add(new int[]{0, 60});
        offsets.add(new int[]{60, 60});

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

    } 
    }

    public void showMapPartly(String input){
        String[] parts = input.split("\\s+");
        int x = Integer.parseInt(parts[3]);
        int y = Integer.parseInt(parts[4]);
        int size = Integer.parseInt(parts[6]);
        StringBuilder sb = new StringBuilder();

        final String RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String BG_BLUE = "\u001B[44m";
        final String BG_GREEN = "\u001B[42m";

        for (int j = y; j < y + size; j++) {
            for (int i = x; i < x + size; i++) {
                MapTile tile = map[i][j];
                switch (tile.getType()) {
                    case GROUND:
                        sb.append(".");
                        break;
                    case TILLED_SOIL:
                        sb.append(YELLOW).append(".").append(RESET);
                        break;
                    case WATERED_SOIL:
                        sb.append(BLUE).append(".").append(RESET);
                        break;
                    case PLANTED_SOIL:
                        if (tile.isWatered()) {
                            sb.append(GREEN).append("w").append(RESET);
                        } else {
                            sb.append(RED).append("p").append(RESET);
                        }
                        break;
                    case WATER:
                        sb.append(BG_BLUE).append("W").append(RESET);//////////////////////////////
                        break;
                    case CABIN:
                        sb.append("C");
                        break;
                    case GREENHOUSE:
                        sb.append("G");
                        break;
                    case BARN: // TODO
                        sb.append(YELLOW).append("B").append(RESET);
                        break;
                    case QUARRY:
                        sb.append("Q");
                        break;
                    case TREE:
                        sb.append(GREEN).append("T").append(RESET);
                        break;
                    case STONE:
                        sb.append(YELLOW).append("S").append(RESET);
                        break;
                    case FORAGEABLE:
                        sb.append(GREEN).append("F").append(RESET);
                        break;
                    case PATH:
                        sb.append("#");
                        break;
                    default:
                        sb.append("?");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
}




    public static WalkResult findShortestPath(MapTile[][] map, int startX,
    int startY, int endX, int endY, int height, int width) {

        int[] dx = {0, 0, -1, 1};    // UP, DOWN, LEFT, RIGHT
        int[] dy = {-1, 1, 0, 0};

        int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;


        boolean[][][] visited = new boolean[width][height][4]; // visited[x][y][direction]

        Queue<WalkPoint> queue = new LinkedList<>();

        // Try all 4 initial directions
        for (int d = 0; d < 4; d++) {
            queue.offer(new WalkPoint(startX, startY, d, 0, 0));
        }

        while (!queue.isEmpty()) {
            WalkPoint p = queue.poll();

            if (p.x == endX && p.y == endY) {
                return new WalkResult(p.dist, p.turns);
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if (visited[nx][ny][d]) continue;

                if (!map[nx][ny].getType().isWalkable()) continue;

                visited[nx][ny][d] = true;
                int newTurns = (p.dir == d) ? p.turns : p.turns + 1;
                queue.offer(new WalkPoint(nx, ny, d, newTurns, p.dist + 1));
            }
        }

        return new WalkResult(-1, -1); // no path
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

    public void updateShowMap(){
        
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

        public void showCurrentMenu() {
        System.out.println("You are now in: " + App.dataManager.getCurrentMenu().getDisplayName());
    }

        public String handleShowMap() {
        Game currentGame = App.dataManager.getCurrentGame();

        StringBuilder sb = new StringBuilder();
        int height;
        int width;
        MapTile[][] map = currentGame.getMap();
        if (currentGame.getFarms().size() == 2) {
            height = 60;
            width = 110;
        } else {
            height = 110;
            width = 110;
        }

        final String RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String BG_BLUE = "\u001B[44m";
        final String BG_GREEN = "\u001B[42m";

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                MapTile tile = map[x][y];
                switch (tile.getType()) {
                    case GROUND:
                        sb.append(".");
                        break;
                    case TILLED_SOIL:
                        sb.append(YELLOW).append(".").append(RESET);
                        break;
                    case WATERED_SOIL:
                        sb.append(BLUE).append(".").append(RESET);
                        break;
                    case PLANTED_SOIL:
                        if (tile.isWatered()) {
                            sb.append(GREEN).append("w").append(RESET);
                        } else {
                            sb.append(RED).append("p").append(RESET);
                        }
                        break;
                    case WATER:
                        sb.append(BG_BLUE).append("W").append(RESET);//////////////////////////////
                        break;
                    case CABIN:
                        sb.append("C");
                        break;
                    case GREENHOUSE:
                        sb.append("G");
                        break;
                    case BARN: // TODO
                        sb.append(YELLOW).append("B").append(RESET);
                        break;
                    case QUARRY:
                        sb.append("Q");
                        break;
                    case TREE:
                        sb.append(GREEN).append("T").append(RESET);
                        break;
                    case STONE:
                        sb.append(YELLOW).append("S").append(RESET);
                        break;
                    case FORAGEABLE:
                        sb.append(GREEN).append("F").append(RESET);
                        break;
                    case PATH:
                        sb.append("#");
                        break;
                    default:
                        sb.append("?");
                }
            }
            sb.append("\n");
        }

        return sb.toString();


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
//        boolean found = false;
//        for (Player player1: getPlayers()) {
//            if (player1.equals(player)) {
//                found = true;
//            }
//        }
//        if (!found) {
//            throw new IllegalArgumentException("Player not found.");
//        }

        this.currentTurnPlayer = player;
        setCurrentFarm(player);//this is new
    }


    public Player getCreator() {
        return creator;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    
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
