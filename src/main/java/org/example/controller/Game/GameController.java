package org.example.controller.Game;


import org.example.models.*;
import org.example.models.Animal.Animal;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.tools.*;

import java.util.ArrayList;

public class GameController {
    User player = App.getCurrentUser();

    public void skillUp(SkillUpTypes skillUpType) {

    }


    // === PLAYER'S STATUS === //

    public Result showPlayerEnergy() {
        int playerEnergy = player.getEnergy();
        return new Result(true, "Your energy is: " + playerEnergy);
    }

    public Result crowAttack(){



        return null;

    }

    public int howMuchWater(){

        return 0;

    }

    public Result setPlayerEnergy(int energyAmount) {
        player.setEnergy(energyAmount);
        return new Result(true, "Energy set to " + energyAmount);
    }

    public Result cheatSetPlayerEnergy(int energyAmount) {
        player.setEnergy(energyAmount);
        return new Result(true, "Energy set to " + energyAmount);
    }

    public Result setUnlimitedEnergy() {
        player.setEnergyUnlimited(true);
        return new Result(true, "Unlimited Energy activated!");
    }

    public Result faint() {
        player.faint();
        return new Result(true, "");
    }

    public Result showCurrentTool() {
        Tool playerCurrentTool = player.getCurrentTool();
        return new Result(true, "Your tool is: " + playerCurrentTool.toString());
    }

    public Result showAvailableTools() {

        ///  SHOWS AVAIBLE TOOLS

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

    // === INVENTORY === //
    public Result inventoryShow() {
        return new Result(true, "");
    }

    public Result throwItemToTrash(Item item, int number) {
        // command: inventory trash ...
        return new Result(true, "");
    }

    // === TOOLS, FOODS, ITEMS, AND CRAFTS === //

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

    public Result cheatAddItem(Item item, int count) {
        return new Result(true, "Item added to inventory.");
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


    // === WALK === //
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
        // [we can also show the path and then ask for confirmation]

        /*
        In View: after calling this method, we expect the player to confirm/deny
        Then, we call the walk() method.
        */
    }

    private Path findValidPath(Position origin, Position destination) {
        // give FarmsMap as argument?
        if (!isDestinationAllowed(destination)) {
            return null;
        }
        return new Path();
    }

    private boolean isDestinationAllowed(Position destination) {
        return false;
    }

    // === PRINT MAP === //

    public Result printMap() {
        return new Result(true, "");
    }

    public Result printColoredMap() {
        return new Result(true, "");
    }

    public Result showHelpReadingMap() {
        return new Result(true, "");
    }


    // === GAME STATUS === //

    // public Result cheatAdvanceTime(int howManyHours) {
    //     return new Result(true, "");
    // }

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


    // === PLANTS === //

    public Result plant(Direction direction, Seed seed) {
        return new Result(true, "");
    }

    public Result showPlant(Position position) {
        Tile tile = getTileByPosition(position);
        return new Result(true, "");
    }

    public Result fertilize(FertilizerType fertilizer, Direction direction) {
        return new Result(true, "");
    }

    // === FARM BUILDINGS & ANIMALS === //

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

    public Result milkAnimal(Animal animal){


        return null;

    }

    public Result feedOutside(Animal animal){

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

    // === FISHING === //

    public Result fishing(String fishingPoleName) {
        Tool fishingPole = getFishingPoleByName(fishingPoleName);
        return new Result(true, "");
    }

    public int numberOfCaughtFish() {
        return 0;
    }

    public int qualityOfCaughtFish() {
        return 0;
    }

    private Tool getFishingPoleByName(String name) {
        return null;
    }

    // === ARTISAN === //

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

    // === SHOPS === //

    public Result showAllProducts() {
        return new Result(true, "");
    }

    public Result showAvailableProducts() {
        return new Result(true, "");
    }

    public Result purchase(String productName, Integer count) {
        // count is optional and might be null. In that case:
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
        // count is optional and might be null. In that case we sell the entire available in inventory
        if (count == null) {
            // Set default count
        }
        return new Result(true, "");
    }

    // === FRIENDSHIPS === //

    public Result showFriendshipLevels() {
        return new Result(true, "");
    }

    public Result talk(String username, String message) {
        return new Result(true, "");
    }

    public Result showTalkHistoryWithUser(String username) {
        return new Result(true, "");
    }

    public Result giveGift(String username, String itemName, int amount) {
        return new Result(true, "");
    }

    public Result giftList() {
        return new Result(true, "");
    }

    public Result giftRate(int giftNumber, int rate) {
        return new Result(true, "");
    }

    public Result hug(String username) {
        return new Result(true, "");
    }

    public Result giveFlowerToUser(String username) {
        return new Result(true, "");
    }

    public Result askMarriage(String username, Object ring) {
        return new Result(true, "");
    }

    public Result respondToMarriageRequest(boolean accepted, String username) {
        return new Result(true, "");
    }

    // === TRADE === //

//    public Result tradeWithMoney(String targetUsername, String type, String itemName, int amount, int price) { // type?
//        return new Result(true, "");
//    }
//
//    public Result tradeWithItem(String targetUsername, String type, String itemName, int amount, String targetItemName, int targetAmount) { // type?
//        return new Result(true, "");
//    }

    public Result showTradeList(String targetUsername, String type, String itemName, int amount, int price) { // type?
        return new Result(true, "");
    }

    public Result tradeResponse(int id) { // type?
        return new Result(true, "");
    }

    public Result showTradeHistory() { // type?
        return new Result(true, "");
    }

    // === NPC === //

    public Result meetNPC(String NCPName) {
        return new Result(true, "");
    }

    public Result giftNPC(String NCPName, String itemName) {
        return new Result(true, "");
    }

    public Result showFriendshipNPCList() {
        return new Result(true, "");
    }

    public Result showQuestsList() {
        return new Result(true, "");
    }

    public Result finishQuest(int index) {
        return new Result(true, "");
    }

    private NPC geNPCByName(String NPCName) {
        return null;
    }
}
