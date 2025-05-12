package org.example.controller.Game;


import org.example.models.*;
import org.example.models.Animal.Animal;
import org.example.models.Map.SecondaryMapComponents.ForagingSeed;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.inventory.Backpack;
import org.example.models.persistence.DataManager;
import org.example.models.tools.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static org.example.models.App.*;

public class GameController {
    Player player = App.getCurrentPlayer();

    /**
     * Gets the current game from DataManager
     *
     * @return The current game
     */
    private Game getCurrentGame() {
        return DataManager.getInstance().getCurrentGame();
    }

    public Result showFriendshipLevels() {
        Game game = getCurrentGame();
        if (game == null) {
            return new Result(false, "You are not currently in a game.");
        }

        StringBuilder message = new StringBuilder("Friendship w other Players:\n");
        for (Player otherPlayer : game.getPlayers()) {
            if (!player.equals(otherPlayer)) {
                Friendship friendship = game.getFriendship(player, otherPlayer);
                message.append(otherPlayer.getUsername()).append(":\n")
                        .append("Friendship Level: ").append(friendship.getLevel()).append("\n")
                        .append("XP: ").append(friendship.getCurrentXP()).append("\n\n");
            }
        }

        return new Result(true, message.toString().trim());
    }

    public Result talk(String username, String message) {
        Game game = getCurrentGame();
        if (message == null || message.isEmpty()) {
            return new Result(false, "Message is empty.");
        }
        Player targetPlayer = game.getPlayerByUsername(username);
        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }
        if (isNear(player.getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            //all conditions passed for sending the message
            //game error

            return new Result(true, "You have successfully sent a message to: "
                    + targetPlayer.getUsername() + ". Your current friendship level with them is "
                    + game.getUserFriendship(player, targetPlayer));
        }
        return new Result(false, "You must stand next to " + targetPlayer.getUsername() + "to be able to talk to them.");
    }

    public Result showTalkHistoryWithUser(String username) {
        Game game = getCurrentGame();
        if (game == null) {
            return new Result(false, "You are not currently in a game.");
        }

        User targetPlayer = game.getPlayerByUsername(username);
        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }
        StringBuilder historyMessage = new StringBuilder("Your talk history with " + username + ": ");
        HashMap<String, Boolean> sentMessages = game.getTalkHistory().get(player).get(targetPlayer);
        historyMessage.append("You: ").append(sentMessages).append("\n");
        HashMap<String, Boolean> receivedMessages = game.getTalkHistory().get(player).get(targetPlayer);
        historyMessage.append(username).append(": \n").append(receivedMessages).append("\n");
        return new Result(true, historyMessage.toString().trim());
    }

    public Result giveGift(String username, String itemName, int amount) {
        Game game = getCurrentGame();
        if (game == null) {
            return new Result(false, "You are not currently in a game.");
        }

        Player targetPlayer = game.getPlayerByUsername(username);
        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }
        if (!isNear(player.getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            return new Result(false, "You must get near to " + username + " to be able to give them a gift.");
        }
        Item item = player.getBackpack().getItemFromInventoryByName(itemName);
        //get item from backpack
        if (item == null) {
            return new Result(false, "Item not found.");
        }

        return new Result(true, "You give " + itemName + " from " + username + ".");
    }

    public Result giftList() {
        Game game = getCurrentGame();
        if (game == null) {
            return new Result(false, "You are not currently in a game.");
        }

        StringBuilder giftListMessage = new StringBuilder("Gift List: \n");
        for (Gift gift : player.getGift()) {
            giftListMessage.append(gift.getId()).append('\n').append(gift.getItem()).append(" (x").append(gift.getAmount()).append(") given by").append(gift.getSender().getUsername()).append("\n");
            if (gift.getRating() == 0) {
                giftListMessage.append("You have not rated this gift yet!");
            } else {
                giftListMessage.append("the rate you have given to this gift is: ").append(gift.getRating()).append("\n");
            }

        }
        return new Result(true, giftListMessage.toString());
    }

    public Result giftRate(int giftNumber, int rate) {
        Game game = getCurrentGame();
        return new Result(true, "");
    }

    public Result hug(String username) {
        Game game = getCurrentGame();
        return new Result(true, "");
    }

    public FlowerType getFlowerTypeByName(String flowerName) {

        for ( FlowerType flowerType : FlowerType.values() ) {

            if ( flowerType.getItem().getItemName().equalsIgnoreCase(flowerName) ) {
                return flowerType;
            }



        }



    }

    public Result giveFlowerToUser(String username, String flowerName) {

        Game game = getCurrentGame();
        Player targetPlayer = game.getPlayerByUsername(username);

        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }

        FlowerType flowerType = getFlowerTypeByName(flowerName);

        if (flowerType == null) {
            return new Result(false, "Flower not found.");
        }
        if (!isNear(player.getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            return new Result(false, "You must get near to " + username + " to be able to give them a flower.\n");
        }
        return new Result(true, "");

    }

    public Result askMarriage(String username, Object ring) {
        Game game = getCurrentGame();
        Player targetPlayer = game.getPlayerByUsername(username);

        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }

        if (!isNear(player.getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            return new Result(false, "You must get near to " + username + " to propose to them.\n");
        }
        if (player.getGender().equals(targetPlayer.getGender())) {
            return new Result(false, "You are not allowed to marry a person of the same gender.");
        }
        boolean hasRing = false;
        //check if the person proposing has a ring or not
        if (!hasRing) {
            return new Result(false, "You do not have a ring to propose with:(");
        }
        return new Result(true, ""); // TODO
        //after passing all of the conditions, now is the time to actually propose.
    }

    public Result marriageResponse(String response, String username) {
        Game game = getCurrentGame();

        User Proposer = game.getPlayerByUsername(username);
        if (Proposer == null) {
            return new Result(false, "User not found.");
        }
        return null;
    }

    public Result showTradeList(String targetUsername, String type, String itemName, int amount, int price) {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result tradeResponse(int id) {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result showTradeHistory() {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result meetNPC(String npcName) {
        Game game = getCurrentGame();


        return null;
    }

    public Result giftNPC(String NCPName, String itemName) {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result showFriendshipNPCList() {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result showQuestsList() {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result finishQuest(int index) {
        Game game = getCurrentGame();


        return new Result(true, "");
    }

    public Result showPlayerEnergy() {
        int playerEnergy = player.getEnergy();
        return new Result(true, "Your energy is: " + playerEnergy);
    }

    public Result crowAttack() {

        return null;

    }

    public int howMuchWater() {

        return 0;

    }

    public Result setPlayerEnergy(int energyAmount) {
        player.setEnergy(energyAmount);
        return new Result(true, "Energy set to " + energyAmount);
    }

    public Result setUnlimitedEnergy() {
        player.setEnergyUnlimited(true);
        return new Result(true, "Unlimited Energy activated!");
    }

    public Result faint() {
        player.faint();
        // Skip to next day logic would go here
        // For now, we'll just set energy to 150 as specified
        return new Result(true, "You fainted and woke up the next day with 150 energy.");
    }

    public Result showCurrentTool() {
        Tool playerCurrentTool = player.getCurrentTool();
        return new Result(true, "Your tool is: " + playerCurrentTool.toString());
    }

    public Result showAvailableTools() {

        return null;

    }

    public Result showLearntCookingRecipes() {
        String learntRecipes = player.getStringLearntCookingRecipes();
        return new Result(true, learntRecipes);
    }

    public Result learnNewRecipe() {

        return null;
    }

    public Result showLearntCraftRecipes() {
        String learntRecipes = player.getStringLearntCraftRecipes();
        return new Result(true, learntRecipes);
    }


    public Result inventoryShow() {
        // Get the player's inventory contents
        Backpack playerBackpack = player.getBackpack();

        if (playerBackpack == null) {
            return new Result(false, "You don't have a backpack yet!");
        }

        String inventoryContents = playerBackpack.getInventoryContents();

        if (inventoryContents.isEmpty()) {
            return new Result(true, "Your inventory is empty.");
        }

        StringBuilder response = new StringBuilder();
        response.append("=== YOUR INVENTORY ===\n");
        response.append(inventoryContents);
        response.append("Backpack type: ").append(playerBackpack.getType()).append("\n");
        response.append("Used slots: ").append(playerBackpack.getUsedCapacity());

        if (!(playerBackpack.getType().getCapacity() == Integer.MAX_VALUE)) {
            response.append("/").append(playerBackpack.getType().getCapacity());
        }

        return new Result(true, response.toString());
    }

    public Result throwItemToTrash(Item item, int number) {
        // command: inventory trash ...
        if (item == null) {
            return new Result(false, "Invalid item specified.");
        }

        Backpack playerBackpack = player.getBackpack();

        if (!playerBackpack.hasItem(item)) {
            return new Result(false, "You don't have any " + item.toString() + " in your inventory.");
        }

        int availableQuantity = playerBackpack.getItemCount(item);

        if (number <= 0) {
            number = availableQuantity;
        }

        if (availableQuantity < number) {
            return new Result(false, "You only have " + availableQuantity + " " + item.toString() + " in your inventory.");
        }

        playerBackpack.removeFromInventory(item, number);

        return new Result(true, "Successfully trashed " + number + " " + item.toString() + ".");
    }

    public Result cheatAddItem(Item item, int count) {
        if (item == null) {
            return new Result(false, "Invalid item specified.");
        }

        if (count <= 0) {
            return new Result(false, "Count must be a positive number.");
        }

        Backpack playerBackpack = player.getBackpack();
        playerBackpack.CheatAddToInventory(item, count);

        return new Result(true, "Added " + count + " " + item.toString() + " to your inventory.");
    }

    public Result upgradeBackpack(String backpackTypeName) {
        // Try to parse the backpack type from the input string
        InventoryType newType;
        try {
            newType = InventoryType.valueOf(backpackTypeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return new Result(false, "Invalid backpack type. Available types: INITIAL, LARGE, DELUXE");
        }

        Backpack currentBackpack = player.getBackpack();
        InventoryType currentType = currentBackpack.getType();

        // Check if this would be a downgrade
        if (currentType == InventoryType.DELUXE ||
                (currentType == InventoryType.LARGE && newType == InventoryType.INITIAL)) {
            return new Result(false, "You cannot downgrade your backpack.");
        }

        // Check if it's the same type (no change)
        if (currentType == newType) {
            return new Result(false, "You already have this backpack type.");
        }

        // Upgrade the backpack
        player.upgradeBackpack(newType);

        return new Result(true, "Your backpack has been upgraded to " + newType + "!");
    }

    public Result showBackpackInfo() {
        Backpack playerBackpack = player.getBackpack();

        if (playerBackpack == null) {
            return new Result(false, "You don't have a backpack yet!");
        }

        InventoryType type = playerBackpack.getType();
        StringBuilder info = new StringBuilder();
        info.append("Backpack Type: ").append(type).append("\n");

        if (type.getCapacity() == Integer.MAX_VALUE) {
            info.append("Capacity: Unlimited\n");
        } else {
            info.append("Capacity: ").append(type.getCapacity()).append("\n");
        }

        info.append("Used Slots: ").append(playerBackpack.getUsedCapacity()).append("\n");
        info.append("Available Slots: ");

        if (type.getCapacity() == Integer.MAX_VALUE) {
            info.append("Unlimited");
        } else {
            info.append(playerBackpack.getRemainingCapacity());
        }

        return new Result(true, info.toString());
    }


    public Result equipTool(String toolName) {
        return new Result(true, "");
    }

    public Result useTool(String directionString) {
        Direction direction = Direction.getDirectionByDisplayName(directionString);
        Position position = neighborTile(direction);
        Tool tool = player.getCurrentTool();
        if (canToolBeUsedHere(position, tool)) {

            return new Result(true, "");
        }
        return new Result(false, "You can't use that tool in that direction");
    }

    public Result placeItem(Item item, Direction direction) {
        Position position = neighborTile(direction);
        if (canItemBePlacedHere(position, item)) {
            return new Result(true, item + " placed at " + position.toString());
        }
        return new Result(false, "you can't place that item at " + position.toString());

    }

    public Result craft(Item item) {
        if (!canCraft(item)) {
            return new Result(false, "Not possible to craft that item!");
        }
        return new Result(true, "Item crafted and added to inventory.");
    }

    public Result showCraftInfo(String craftName) {
        return new Result(true, "");
    }

    // or name it cook() ?
    public Result prepareCook(Food food) {
        if (!canCook(food)) {
            return new Result(false, "You cannot cook this right now.");
        }
        return new Result(true, "Yummy! Your meal is ready.");
    }

    public Result eat(Food food) {
        player.eat(food.getName());
        return new Result(true, "");
    }

    private boolean canCraft(Item item) {
        return false;
    }

    private boolean canCook(Food food) {
        return false;
    }

    private boolean canToolBeUsedHere(Position position, Tool tool) {
        return false;
    }

    private boolean canItemBePlacedHere(Position position, Item item) {
        return false;
    }

    private Position neighborTile(Direction direction) {
        return null;
    }

    private Tile getTileByPosition(Position position) {
        return null;
    }


    public Result walk(Path path, boolean playerConfirmed) {
        if (!playerConfirmed) {
            return new Result(false, "You denied the walk.");
        }
        Position destination = path.getPathTiles().getLast();
        player.changePosition(destination);
        return new Result(true, "Walking...");
    }

    public Result respondForWalkRequest(Position origin, Position destination) {
        Path path = findValidPath(origin, destination);
        if (path == null) {
            return new Result(false, "No valid path found!");
        }
        return new Result(true, "Do you confirm the walk?");

    }

    private Path findValidPath(Position origin, Position destination) {
        if (!isDestinationAllowed(destination)) {
            return null;
        }
        return new Path();
    }

    private boolean isDestinationAllowed(Position destination) {
        return false;
    }

    public Result printMap() {
        return new Result(true, "");
    }

    public Result printColoredMap() {
        return new Result(true, "");
    }

    public Result showHelpReadingMap() {
        return new Result(true, "");
    }


    public Result cheatAdvanceDate(int howManyDays) {
        return new Result(true, "");
    }

    public Result cheatThor(Position position) {
        return new Result(true, "");
    }

    public Result showWeather() {
        return new Result(true, "");
    }

    public Result showWeatherForecast() {
        return new Result(true, "");
    }

    public Result cheatWeatherSet(Weather newWeather) {
        return new Result(true, "");
    }

    public Result buildGreenhouse() {
        if (!canBuildGreenhouse()) {
            return new Result(false, "You can't build greenhouse!");
        }
        return new Result(true, "Building greenhouse...");
    }

    private boolean canBuildGreenhouse() {
        return false;
    }


    public Result plant(Direction direction, ForagingSeed seed) {
        return new Result(true, "");
    }

    public Result showPlant(Position position) {
        Tile tile = getTileByPosition(position);
        return new Result(true, "");
    }

    public Result fertilize(FertilizerType fertilizer, Direction direction) {
        return new Result(true, "");
    }

    public Result build(FarmBuildingType farmBuildingType, Position position) {
        return new Result(true, "");
    }

    public Result buyAnimal(AnimalType animalType, String name) {
        Animal animal = new Animal(name, animalType);
        return new Result(true, "");
    }

    public Result pet(String animalName) {
        Animal animal = getAnimalByName(animalName);
        return new Result(true, "");
    }

    public Result cheatSetFriendship(String animalName, int amount) {
        Animal animal = getAnimalByName(animalName);
        return new Result(true, "");
    }

    public Result showMyAnimalsInfo() {
        return new Result(true, "");
    }

    public Result shepherdAnimal(String animalName, Position position) {
        return new Result(true, "");
    }

    public Result milkAnimal(Animal animal) {
        return null;
    }

    public Result feedOutside(Animal animal) {

        return null;

    }

    public Result feedHayToAnimal(String animalName) {
        Animal animal = getAnimalByName(animalName);
        return new Result(true, "");
    }

    public Result showProducedProducts() {
        return new Result(true, "");
    }

    public Result collectProducts(String animalName) {
        Animal animal = getAnimalByName(animalName);
        return new Result(true, "");
    }

    public Result sellAnimal(String animalName) {
        Animal animal = getAnimalByName(animalName);
        return new Result(true, "");
    }

    private Animal getAnimalByName(String name) {
        return null;
    }

    public Result fishing(String fishingPoleName) {

        FishingRodType fishingRod = getFishingPoleByName(fishingPoleName);

        if (true) {

            int numberOfFishes = numberOfCaughtFish() + 1;
            FishType fishType = FishType.values()[(new Random()).nextInt(FishType.values().length)];
            for (int i = 0; i < numberOfFishes; i++) {
                ///  add fishtype to arraylist
            }


        }

        return new Result(true, "");
    }

    public boolean closeToSea(Position position) {

        return true;

    }

    public int calculateFishQuality(FishingRodType fishingRod) {

        return (int) ((new Random().nextInt(2)) * (App.currentPlayer.getSkillLevels().get(Skill.FISHING).getLevel() + 2) * fishingRod.getPoleCoefficient() / (7 - App.currentWeather.getWeatherCoEfficient()));

    }

    public int numberOfCaughtFish() {

        return (int) ((new Random().nextInt(2)) * App.currentWeather.getWeatherCoEfficient() * (App.currentPlayer.getSkillLevels().get(Skill.FISHING).getLevel() + 2));

    }

    private FishingRodType getFishingPoleByName(String name) {

        if (FishingRodType.TRAINING_ROD.getPoleName().equals(name)) {
            return FishingRodType.TRAINING_ROD;
        } else if (FishingRodType.BAMBOO_POLE.getPoleName().equals(name)) {
            return FishingRodType.BAMBOO_POLE;
        } else if (FishingRodType.FIBERGLASS_ROD.getPoleName().equals(name)) {
            return FishingRodType.FIBERGLASS_ROD;
        }
        return FishingRodType.IRIDIUM;

    }


    public Result artisanUse(String artisanName, ArrayList<String> itemsNames) { // gets ingredients
        ArrayList<Item> ingredientItems = new ArrayList<>();
        for (String itemName : itemsNames) {
            ingredientItems.add(getItemByItemName(itemName));
        }
        Artisan artisan = getArtisanByArtisanName(artisanName);
        return new Result(true, "");
    }

    public Result artisanGet(String artisanName) { // gives product
        return new Result(true, "");
    }

    private Artisan getArtisanByArtisanName(String artisanName) {
        return null;
    }

    private Item getItemByItemName(String itemName) {
        return null;
    }


    public Result showAllProducts() {
        return new Result(true, "");
    }

    public Result showAvailableProducts() {
        return new Result(true, "");
    }

    public Result purchase(String productName, Integer count) {
        if (count == null) {
            count = 1;
        }
        Item product = getItemByItemName(productName);
        return new Result(true, "");
    }

    public Result cheatAddDollars(int amount) {
        return new Result(true, "");
    }

    public Result sell(String productName, Integer count) {
        if (count == null) {
        }
        return new Result(true, "");
    }

    //  from here
    public Boolean isNear(Position positionOne, Position positionTwo) {
        int x1 = positionOne.getX();
        int y1 = positionOne.getY();
        int x2 = positionTwo.getX();
        int y2 = positionTwo.getY();
        return Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1;
    }

    public void handleSkillXPGain(Skill skill) {
        boolean leveledUp = false;

        switch (skill) {
            case FARMING:
                leveledUp = player.addSkillXP(Skill.FARMING, 5);
                break;
            case MINING:
                leveledUp = player.addSkillXP(Skill.MINING, 10);
                break;
            case FORAGING:
                leveledUp = player.addSkillXP(Skill.FORAGING, 10);
                break;
            case FISHING:
                leveledUp = player.addSkillXP(Skill.FISHING, 5);
                break;
        }

        // If player leveled up, we could notify them or apply effects
        if (leveledUp) {
            // Could send a notification or apply immediate effects
        }
    }
}
