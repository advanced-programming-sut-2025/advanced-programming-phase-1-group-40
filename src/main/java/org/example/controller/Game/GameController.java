package org.example.controller.Game;


import org.example.models.*;
import org.example.models.Animal.Animal;
import org.example.models.Animal.AnimalLivingSpace;
import org.example.models.Animal.AnimalProduct;
import org.example.models.Animal.AnimalProductQuality;
import org.example.models.Map.SecondaryMapComponents.ForagingSeed;
import org.example.models.Map.TileType;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.inventory.Backpack;
import org.example.models.inventory.Inventory;
import org.example.models.tools.*;

import java.util.*;
import java.util.regex.Matcher;

public class GameController {

    ///  GENERAL COMMANDS

    public Result exitGame(){

        if ( ! App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername().equals(App.dataManager.getCurrentGame().getGameLoader().getUsername()) ){
            return new Result(false,"Only the game loader can exit the game");
        }

        App.dataManager.setCurrentGame(null);
        App.dataManager.setCurrentMenu(Menu.PRE_GAME_MENU);

        return new Result(true,"You have successfully exited the game.You are now in Pregame Menu.");

    }


    ///  TURN AND UPDATING GAME


    private void nextHourUpdate(){


    }

    private void nextDayUpdate(){

        updateWeather();
        animalProductUpdate();

        updateFriendshipWithAnimal();
        updatePlayersFriendship();

        //foraging generation



    }

    public void updateWeather(){

        App.dataManager.getCurrentGame().setWeather(App.dataManager.getCurrentGame().getFutureWeather());
        App.dataManager.getCurrentGame().setFutureWeather(randomWeatherBasedOnSeason());

    }

    public void animalProductUpdate(){

        for ( Player player : App.dataManager.getCurrentGame().getPlayers() ) {

            for ( Animal animal : App.dataManager.getCurrentGame().getPlayerFarms().get(player).getAnimals() ){

                if ( (animal.getLastProductMade() + 1) == animal.getAnimalType().getProductCycle() ) {

                    animal.setLastProductMade(0);

                    if ( animal.isPetToday() || animal.isFedWithHayToday() ) {
                        animal.addProduct(new AnimalProduct(getRandomAnimalProductType(animal),getRandomAnimalProductQuality(animal)));

                    }


                }
                else{
                    animal.setLastProductMade(animal.getLastProductMade()+1);
                }

            }

        }

    }

    public AnimalProducts getRandomAnimalProductType(Animal animal){

        if ( (animal.getAnimalType().getProducts().size() == 1) || (animal.getFriendshipWithOwner() <= 100) ) {
            return animal.getAnimalType().getProducts().get(0);
        }

        double secondProductChance = (animal.getFriendshipWithOwner() + ( 150 * (0.5 + Math.random()) )) / 1500;

        if ( Math.random() <= secondProductChance ) {
            return animal.getAnimalType().getProducts().get(1);
        }
        return animal.getAnimalType().getProducts().get(0);

    }

    public AnimalProductQuality getRandomAnimalProductQuality(Animal animal){


        Double quality = ( animal.getFriendshipWithOwner() / 1000 ) * ( 0.5 + Math.random()* 0.5 );

        for ( AnimalProductQuality animalProductQuality : AnimalProductQuality.values() ) {

            if ( animalProductQuality.getMinQuality() < quality  && animalProductQuality.getMaxQuality() >= quality ) {
                return animalProductQuality;
            }

        }

        return null;

    }

    public void updateFriendshipWithAnimal(){

        for ( Player player : App.dataManager.getCurrentGame().getPlayers() ) {

            for ( AnimalLivingSpace animalLivingSpace : App.dataManager.getCurrentGame().getPlayerFarms().get(player).getAnimalLivingSpaces() ){

                for ( Animal animal : animalLivingSpace.getAnimals() ) {

                    if ( animal.isOutside() ){
                        animal.setFriendshipWithOwner(animal.getFriendshipWithOwner()-20);
                    }


                    if ( ! animal.isPetToday() ){
                        animal.setFriendshipWithOwner(animal.getFriendshipWithOwner()- (10-(animal.getFriendshipWithOwner()/200)) );
                    }

                    if ( ! ( animal.isAteGrass() || animal.isFedWithHayToday())  ){
                        animal.setFriendshipWithOwner(animal.getFriendshipWithOwner()-20);
                    }

                }

            }

        }

    }

    public void updatePlayersFriendship(){

        for ( Player player : App.dataManager.getCurrentGame().getPlayers() ) {

            for ( FriendshipWithPlayers friendshipWithPlayers : player.getFriendships() ){

                if ( ! friendshipWithPlayers.hadInteraction() ){

                    if ( friendshipWithPlayers.getFriendshipXP() < 10 ){

                        if ( friendshipWithPlayers.getFriendshipLevel().equals(FriendshipLevel.STRANGER) ){
                            friendshipWithPlayers.setFriendshipXP(0);
                        }
                        else{


                            friendshipWithPlayers.setFriendshipLevel(FriendshipLevel.values()[friendshipWithPlayers.getFriendshipLevel().getLevel()-1]);
                            friendshipWithPlayers.setFriendshipXP((friendshipWithPlayers.getFriendshipLevel().getLevel()+1)*100 + friendshipWithPlayers.getFriendshipXP() - 10 );

                        }

                    }
                    else{
                        friendshipWithPlayers.setFriendshipXP(friendshipWithPlayers.getFriendshipXP() - 10 );
                    }

                }

                friendshipWithPlayers.setInteraction(false);

            }

        }


    }

    public Player nextTurn() {

        Game currentGame = App.dataManager.getCurrentGame();
        Time currentTime = currentGame.getTime();

        int currentIndex = currentGame.getPlayers().indexOf(currentGame.getCurrentTurnPlayer());
        int nextIndex = (currentIndex + 1) % currentGame.getPlayers().size();


        if (nextIndex == 0) {

            ///  NEXT HOUR UPDATE
            nextHourUpdate();



            if ( currentTime.getHour() >= 22 ){

                ///  NEXT DAY UPDATE
                nextDayUpdate();


                currentTime.setHour(9);

                if ( currentTime.getWeekday() == Weekday.SUNDAY){
                    currentTime.setWeekday(Weekday.MONDAY);
                }
                else{
                    currentTime.setWeekday(Weekday.values()[currentTime.getWeekday().getDayIndex()+1]);
                }

                if ( currentTime.getDate() >= 28){

                    currentTime.setDate(1);

                    if ( currentTime.getMonth() == Month.DECEMBER ){
                        currentTime.setMonth(Month.JANUARY);
                        currentTime.setYear(currentTime.getYear() + 1);
                    }
                    else{
                        currentTime.setMonth(Month.values()[currentTime.getMonth().getMonthIndex()+1]);
                    }

                }
                else{
                    currentTime.setDate(currentTime.getDate()+1);
                }

                currentTime.setDaysPassed(currentTime.getDaysPassed()+1);

            }
            else{

                currentTime.setHour(currentTime.getHour() + 1);

            }

        }

        currentGame.setCurrentTurnPlayer(currentGame.getPlayers().get(nextIndex));
        return currentGame.getPlayers().get(nextIndex);

    }


    ///     ----------------->  TOOLS

    private boolean isInBlacksmith(){           ///  TODO

        return true;

    }

    public Tool getToolByName(String name) {

        for (Tool tool : App.dataManager.getCurrentGame().getCurrentTurnPlayer().getTools()) {
            if (tool.getName().equalsIgnoreCase(name)) {
                return tool;
            }
        }

        return null;

    }

    public Result showCurrentTool() {

        Tool playerCurrentTool = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentTool();

        if (playerCurrentTool == null) {

            return new Result(false, "You haven't equipped any tool yet.");
        }

        return new Result(true, "Your current tool is: " + playerCurrentTool.getItemName());

    }

    public Result showAvailableTools() {

        ArrayList<Tool> tools = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getTools();

        if ( tools.isEmpty() ) {

            return new Result(false, "You don't have any tools.");

        }

        StringBuilder sb = new StringBuilder("Available tools are :\n");

        for (Tool tool : tools) {

            sb.append("- ").append(tool.getName()).append("\n");

        }

        return new Result(true, sb.toString().trim());

    }

    public Result equipTool(String toolName) {

        Tool newTool = getToolByName(toolName);

        if (newTool == null) {
            return new Result(false, "You don't have this tool");
        }

        App.dataManager.getCurrentGame().getCurrentTurnPlayer().setCurrentTool(newTool);
        return new Result(false, "You are now equipped with : " + newTool.getName());

    }

    private Position neighborTile(Direction direction) {
        return null;
    }

    private boolean canToolBeUsedHere(Position position, Tool tool) {
        return false;
    }

    public Result useTool(String directionString) {

        Direction direction = Direction.getDirectionByDisplayName(directionString);

        if (direction == null) {
            return new Result(false, "Invalid direction: " + directionString);
        }

        Position position = neighborTile(direction);

        Tool tool = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentTool();

        if (tool == null) {
            return new Result(false, "You have no tool equipped.");
        }

        if (canToolBeUsedHere(position, tool)) {

            tool.useTool(direction);
            return new Result(true, "Used " + tool.getItemName() + " in direction " + directionString);

        }

        return new Result(false, "You can't use that tool in that direction.");


    }

    public Result upgradeTool(String toolName) {

        if ( !isInBlacksmith() ) {      ///  TODO: FUNC BLACK SMITH OK SHE

            return new Result(false, "You should be inside the Blacksmith to upgrade tools.");

        }

        Tool toolToUpgrade = getToolByName(toolName);

        if ( toolToUpgrade == null ) {

            return new Result(false, "You don't have the tool '" + toolName + "' to upgrade.");

        }

        if ( !toolToUpgrade.canUpgrade() ) {

            return new Result(false, "The tool '" + toolName + "' cannot be upgraded any further.");

        }

        //we should actually upgrade the tool here

        toolToUpgrade.upgrade();
        //other things should be checked
        return new Result(true, "You successfully upgraded "+toolName);

    }


    ///     ----------------->  COOKING

    public String handleRefrigerator(Matcher matcher) {
        return " ";
    }

    public String showCookingRecipes() {
        StringBuilder sb = new StringBuilder("Available cooking recipes:\n");

        for (Food food : Food.values()) {
            sb.append("- ").append(food.getName()).append(" | Ingredients: ");
            boolean first = true;

            for (Map.Entry<IngredientType, Integer> entry : food.getIngredients().entrySet()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.getValue()).append(" ").append(entry.getKey().getName());
                first = false;
                //dige avali nist
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String prepareRecipe(Matcher matcher) {
        if (matcher == null || !matcher.matches()) {
            return "Invalid recipe command format.";
        }

        String foodName = matcher.group("foodName");
        Result result = cook(foodName);
        return result.message();
    }

    public Result cook(String foodName) {
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        Food recipe = null;
        for (Food food : Food.values()) {
            if (food.getName().equals(foodName)) {
                recipe = food;
                break;
            }
        }
        if (recipe == null) {
            return new Result(false, "Recipe not found.");
        }
        return new Result(true,"You have successfully cooked " + foodName+".");
        //actually implement the logic for cooking

    }

    public String eatFood(Matcher matcher) {
       Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        String foodName = matcher.group("foodName");
        Food foodToEat = null;
        for(Food food : Food.values()){
            if ( foodName.equals(food.getName()) ) {
                foodToEat = food;
                break;
            }
        }
        if ( foodToEat == null ) {
            return "You don't have a food called " + foodName+ " to eat.";
        }
        Item foodItem = new FoodItem(foodToEat);
        boolean removed  = false;
        if (player.getInventory().getItemCount(foodItem) > 0) {
            player.getInventory().removeFromInventory(foodItem, 1);
            removed = true;
        }
        if ( !removed ) {
            return "You don't have any " + foodName+ "to eat.";
        }
        //here energy of the player should be increased based on the food energy
        player.increaseEnergy(foodToEat.getEnergy());
        return "You have eaten "+foodToEat.getName();
    }


    ///     ----------------->  Crafting

    public String showCraftingRecipes() {
        StringBuilder sb = new StringBuilder("Available crafting recipes:\n");

        for (Craft craft : Craft.values()) {
            sb.append("- ").append(craft.getName()).append(" | Ingredients: ");
            boolean first = true;

            for (Map.Entry<IngredientType, Integer> entry : craft.getIngredients().entrySet()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.getValue()).append(" ").append(entry.getKey().getName());
                first = false;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    public String cheatAddItem(Matcher matcher) {
        Player player = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
        Inventory inventory = player.getInventory();

        String itemName = matcher.group("itemName").trim();
        int count = Integer.parseInt(matcher.group("count"));

        Craft craft = Craft.getByName(itemName);
        if (craft == null) {
            return "You don't have an item called '" + itemName + "' to add.";
        }

        if (inventory.getRemainingCapacity() < count) {
            return "Not enough space in inventory.";
        }

            inventory.CheatAddToInventory(craft, count);

        return "Successfully added " + count + " x " + itemName + " to your inventory.";
    }





    ///      ---------------------> TIME & DATE

    public String showTime(){

        return ("Time is: " + App.dataManager.getCurrentGame().getTime().getHour());

    }

    public String showDate(){

        return ("Date is: " + App.dataManager.getCurrentGame().getTime().getYear() + "." +
                (App.dataManager.getCurrentGame().getTime().getMonth().getMonthIndex()+1) + "." +
                App.dataManager.getCurrentGame().getTime().getDate());

    }

    public String showDateTime(){

        return (showDate() + " And " + showTime());

    }

    public String showDayOfTheWeek(){

        return ("Today is: " + App.dataManager.getCurrentGame().getTime().getWeekday().getDayName());

    }

    public String showSeason(){

        return ("Current Season is: " + App.dataManager.getCurrentGame().getTime().getSeason().getName());

    }

    public Result cheatAdvanceTime(String input){

        int hour;

        try{
            hour = Integer.parseInt(input);
        }
        catch (Exception e){
            return new Result(false, "Invalid time format");
        }

        for ( int i = 0; i < (hour * App.dataManager.getCurrentGame().getPlayers().size()); i++ ){
            nextTurn();
        }

        return new Result(true, "New " + showDateTime());
    }

    public Result cheatAdvanceDate(String input){

        int days;

        try{
            days = Integer.parseInt(input);
        }
        catch (Exception e){
            return new Result(false, "Invalid date format");
        }

        for ( int i = 0; i < days; i++ ){
            cheatAdvanceTime("14");
        }

        return new Result(true, "New " + showDateTime());

    }


    ///      ---------------------> WEATHER


    public Weather randomWeatherBasedOnSeason(){

        ArrayList<Weather> candidateWeathers = new ArrayList<>();
        for ( Weather weather : Weather.values() ){

            if ( weather.getPossibleSeasons().contains(App.dataManager.getCurrentGame().getTime().getSeason()) ){
                candidateWeathers.add(weather);
            }

        }

        return Weather.values()[(int)(Math.random()*candidateWeathers.size())];


    }

    public void randomThor(){

        if ( App.dataManager.getCurrentGame().getWeather().equals(Weather.STORMY) ){

            ///     TODO: Choose random tiles in each farm and then use function called thor(Position)

        }

    }

    public Result cheatThor(Matcher input) {

        Integer xCoordinate,yCoordinate;
        try{
            xCoordinate = Integer.parseInt(input.group("x"));
            yCoordinate = Integer.parseInt(input.group("y"));
        }
        catch (Exception e){
            return new Result(false,"Invalid coordinate");
        }

        thor(new Position(xCoordinate,yCoordinate));
        return new Result(true,"Thor cheat successfully applied");


    }

    public void thor(Position position){

        ///  TODO

    }

    public String showWeather(){
        return ("Current Weather is: " + App.dataManager.getCurrentGame().getWeather().getWeatherDisplayName());
    }

    public String showWeatherForecast(){
        return ("Future Weather is: " + App.dataManager.getCurrentGame().getFutureWeather().getWeatherDisplayName());
    }

    public Result cheatSetWeather(Matcher input){

        Weather futureWeather = getWeatherByName(input.group("weatherType"));
        if ( futureWeather == null ){
            return new Result(false, "Invalid weather type");
        }

        App.dataManager.getCurrentGame().setFutureWeather(futureWeather);
        return new Result(true, "Future Weather cheat successfully applied. Tomorrow is going to be: " + futureWeather.getWeatherDisplayName());

    }

    private Weather getWeatherByName(String input){

        for( Weather weather : Weather.values() ){

            if ( weather.getWeatherDisplayName().toLowerCase().equals(input.toLowerCase().trim()) ){
                return weather;
            }

        }

        return null;

    }

    ///      ---------------------> DAMDARI


    public Result buyAnimal(Matcher input) {                            ///  TODO: CHECK IF PLAYER IS IN MARNIE SHOP

        if ( App.dataManager.getCurrentGame().getMap()
                [App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition().getX()]
                [App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition().getY()].getType()
                != TileType.MARNIES_RANCH)
        {

            return new Result(false,"You can only buy animals if you are in Marnie's Ranch");

        }

        AnimalType animalType = parseAnimalType(input.group("animalType").trim());

        if ( animalType == null ){
            return new Result(false,"Invalid animal type");
        }

        String animalName = input.group("animalName").trim();

        if ( App.dataManager.getCurrentGame().getCurrentTurnPlayer().getGold() < animalType.getPrice() ){
            return new Result(false,"You don't have enough money ):");
        }

        AnimalLivingSpace targetLivingSpace = playerHasAnimalCapacity(App.dataManager.getCurrentGame().getCurrentTurnPlayer(),animalType);

        if ( targetLivingSpace == null ){

            return new Result(false,"You dont have capacity to buy this animal");

        }

        Animal newAnimal = new Animal(animalName, animalType);
        newAnimal.setPosition(new Position(targetLivingSpace.getPosition().getX(), targetLivingSpace.getPosition().getY()));
        targetLivingSpace.addAnimal(newAnimal);

        return new Result(true,"You just bought a " + animalName + " which is a " + animalType);


    }

    private AnimalType parseAnimalType(String animalType) {

        for ( AnimalType type : AnimalType.values() ){

            if ( type.getName().toLowerCase().equals(animalType.toLowerCase()) ){
                return type;
            }

        }

        return null;

    }

    private AnimalLivingSpace playerHasAnimalCapacity(Player player, AnimalType animalType) {

        for ( AnimalLivingSpace animalLivingSpace : App.dataManager.getCurrentGame().getPlayerFarms().get(player).getAnimalLivingSpaces() ){

            if ( numberOfAnimalInABuilding(animalLivingSpace, animalType) < animalType.getMaxNumberInOnePlace() ){

                return animalLivingSpace;

            }

        }

        return null;

    }

    private int numberOfAnimalInABuilding(AnimalLivingSpace animalLivingSpace, AnimalType animalType) {

        int count = 0;

        for ( Animal animal : animalLivingSpace.getAnimals()){

            if ( animal.getAnimalType() == animalType ){
                count ++;
            }

        }

        return count;
    }

    public Result petAnimal(Matcher input){

        Animal animal = findAnimalByName(input.group("name"));

        if ( animal == null ){

            return new Result(false,"Animal not found");

        }

        if ( ! closeTo(animal.getPosition(), App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition())  ){

            return new Result(false,"You are out too far away");

        }

        animal.setFriendshipWithOwner(animal.getFriendshipWithOwner()+15);
        animal.setPetToday(true);

        return new Result(true,"Pet successfully. FriendShip +15 (:");


    }

    private boolean closeTo(Position position1, Position position2){

        return (Math.abs(position1.getX() - position2.getX()) <= 1

                &&

                Math.abs(position1.getY() - position2.getY()) <= 1

        );

    }

    private Animal findAnimalByName(String name){

        for ( Animal animal : App.dataManager.getCurrentGame().getPlayerFarms().get(App.dataManager.getCurrentGame().getCurrentTurnPlayer()).getAnimals()  ){

            if ( animal.getName().equals(name) ){

                return animal;

            }

        }

        return null;

    }

    public Result cheatSetFriendship(Matcher input){

        Animal animal = findAnimalByName(input.group("animalName"));
        Integer amount = Integer.parseInt(input.group("amount").trim());

        if ( animal == null ){

            return new Result(false,"Animal not found");

        }

        animal.setFriendshipWithOwner(animal.getFriendshipWithOwner()+amount);

        return new Result(true,"Cheat Set successfully");



    }

    public void showAnimalInfo(Matcher input){

        int count = 1;

        for ( Animal animal : App.dataManager.getCurrentGame().getPlayerFarms().get(App.dataManager.getCurrentGame().getCurrentTurnPlayer()).getAnimals()  ){

            System.out.println(count + ". Your friendship with: " +animal.getName() + "(" + animal.getAnimalType() + ") is:" + animal.getFriendshipWithOwner());
            count ++;

        }

    }

    public Result shepherd(Matcher input){

        Animal animal = findAnimalByName(input.group("animalName"));
        Position targetPosition;

        if ( animal == null ){
            return new Result(false,"Animal not found");
        }



        try{
            targetPosition = new Position(Integer.parseInt(input.group("x")), Integer.parseInt(input.group("y")));
        }
        catch ( NumberFormatException e ){
            return new Result(false,"Invalid x or y position");
        }

        if ( App.dataManager.getCurrentGame().getWeather() != Weather.SUNNY ){
            return new Result(false,"Animals can only go outside in a sunny weather condition");
        }


        if ( ! App.dataManager.getCurrentGame().getMap()[targetPosition.getX()][targetPosition.getY()].isEmpty() ){
            return new Result(false,"Animal can not be moved to target position");
        }

        animal.setPosition(targetPosition);
        animal.setOutside(true);
        animal.setAteGrass(true);

        return new Result(true,"Shepherd successfully");



    }

    public Result feedWithHay(Matcher input){

        Animal animal = findAnimalByName(input.group("animalName"));

        if ( animal == null ){
            return new Result(false,"Animal not found");
        }

        if (animal.isFedWithHayToday()){
            return new Result(false,"Animal is already fed with hay!");
        }

        animal.setFedWithHayToday(true);
        return new Result(true,"Feed with hay successfully");


    }

    public Result sellAnimal(Matcher input){

        String animalName = input.group("animal");

        Animal animal = findAnimalByName(animalName);

        if ( animal == null ){
            return new Result(false,"Animal not found");
        }

        App.dataManager.getCurrentGame().getPlayerFarms().get(App.dataManager.getCurrentGame().getCurrentTurnPlayer()).removeAnimal(animal);
        App.dataManager.getCurrentGame().getCurrentTurnPlayer().setGold(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getGold()+calculateAnimalPrice(animal));
        return new Result(true,"You sold " + animalName);

    }

    private int calculateAnimalPrice(Animal animal){

        return (int)(animal.getAnimalType().getPrice() * ( (animal.getFriendshipWithOwner()/1000) + 0.3 ));

    }

    public void showUncollectedProducts(){

        System.out.println("Uncollected Products: ");

        for ( AnimalLivingSpace animalLivingSpace : App.dataManager.getCurrentGame().getPlayerFarms().get(App.dataManager.getCurrentGame().getCurrentTurnPlayer()).getAnimalLivingSpaces() ){

            for ( Animal animal : animalLivingSpace.getAnimals() ){

                System.out.println("    " + animal.getName() + "(" + animal.getAnimalType() + ")");

                for ( AnimalProduct animalProduct : animal.getProducts() ){

                    System.out.println("        " + animalProduct.getType().getDisplayName());

                }

            }

        }

    }

    public Result collectProducts(Matcher input){

        Animal animal = findAnimalByName(input.group("name"));

        if ( animal == null ){
            return new Result(false,"Animal not found");
        }

        if (    animal.getAnimalType().equals(AnimalType.Cow) ||
                animal.getAnimalType().equals(AnimalType.Goat) ||
                animal.getAnimalType().equals(AnimalType.Sheep)
        ){

            if ( ! checkIfPlayerHasRequiredTool() ){
                return new Result(false,"You don't have required tool to collect " + animal.getAnimalType().getName() + "'s products!");
            }

        }

        if ( animal.getProducts().isEmpty() ){
            return new Result(false,"There is no product to collect");
        }

        for ( AnimalProduct animalProduct : animal.getProducts() ){

            App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack().addToInventory(animalProduct,1);
            System.out.println(animalProduct.getType().getDisplayName()+ " collected and added to Inventory.");

        }

        return new Result(true,"Collected " + animal.getProducts().size() + " products");

    }

    private boolean checkIfPlayerHasRequiredTool(){             ///  TODO
        return true;
    }

    ///   -----------------------> FISH


    public Result fishing(Matcher input) {

        String fishingPoleName = input.group("fishingPole");

        FishingRodType fishingRod = getFishingPoleByName(fishingPoleName);

        if ( ! App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack().hasItem(fishingRod) ){
            return new Result(false,"You dont have this fishing rod");
        }

        if ( closeToSea(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition()) ) {

            int numberOfFishes = numberOfCaughtFish();

            FishType fishType = randomTypeForCaughtFish(fishingRod);
            Fish caughtFish = new Fish(fishType, calculateFishQuality(fishingRod));


            App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack().addToInventory(
                    caughtFish,
                            Math.min(
                            numberOfFishes,
                            App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack().getRemainingCapacity())
                    );

            App.dataManager.getCurrentGame().getCurrentTurnPlayer().addSkillXP(Skill.FISHING,5);        /// BA HAR BAR MAHI GIRI
                                                                                                                 ///  FISHING SKILL +5

            App.dataManager.getCurrentGame().getCurrentTurnPlayer().setEnergy(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getEnergy() - fishingRod.getEnergyCost());

            return new Result(true,numberOfFishes + " " + fishType.getName() + " got caught.");

        }

        return new Result(false, "Get Closer to Sea");
    }

    private FishType randomTypeForCaughtFish(FishingRodType fishingRod){

        ArrayList<FishType> candidateFishTypes = new ArrayList<>();

        for ( FishType fishType : FishType.values() ){

            if ( App.dataManager.getCurrentGame().getTime().getSeason() == fishType.getSeason() ){

                if ( fishType.isLegendary() ){

                    if ( App.dataManager.getCurrentGame().getCurrentTurnPlayer().getSkillLevels().get(Skill.FISHING).getLevel() == SkillLevels.LEVEL_THREE ){

                        if ( fishingRod.getFishTypes().contains(fishType) ){
                            candidateFishTypes.add(fishType);
                        }

                    }

                }
                else{
                    if ( fishingRod.getFishTypes().contains(fishType) ){
                        candidateFishTypes.add(fishType);
                    }
                }

            }

        }

        return candidateFishTypes.get(new Random().nextInt(candidateFishTypes.size()));

    }

    private boolean closeToSea(Position position) {                      ///  TODO

        return true;

    }

    private int calculateFishQuality(FishingRodType fishingRod) {

        return (int) ((new Random().nextInt(2)) * (App.dataManager.getCurrentGame().getCurrentTurnPlayer().getSkillLevels().get(Skill.FISHING).getLevel().getIntLevel() + 2) * fishingRod.getPoleCoefficient() / (7 - App.dataManager.getCurrentGame().getWeather().getWeatherCoEfficient()));

    }

    private int numberOfCaughtFish() {

        return Math.min(6,(int) ((new Random().nextInt(2)) * App.dataManager.getCurrentGame().getWeather().getWeatherCoEfficient() * (App.dataManager.getCurrentGame().getCurrentTurnPlayer().getSkillLevels().get(Skill.FISHING).getLevel().getIntLevel() + 2)));

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


    ///        ----------------------->  Taamolat ba Other Players

    public void showFriendships(){
//        System.err.println("SHOW FRIENDSHIP: PLAYERs OBJECT IS: "  + App.dataManager.getCurrentGame().getPlayers());
//        System.out.println(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername() + "'s friends are:");
        System.out.println();
        for ( FriendshipWithPlayers friendship : App.dataManager.getCurrentGame().getCurrentTurnPlayer().getFriendships() ){

            System.out.println("    " + friendship.getTargetPlayer().getUsername() + "(" + friendship.getFriendshipLevel().getDisplayName() + " with: " + friendship.getFriendshipXP() + " xp)");

        }

    }

    public Result talk(Matcher input){

        Player targetPlayer = getPlayerByUsername(input.group("username"));
        String message = input.group("message");

        if ( targetPlayer == null ){
            return new Result(false, "Target player not found");
        }

        if ( targetPlayer.equals(App.dataManager.getCurrentGame().getCurrentTurnPlayer()) ){
            return new Result(false, "You can't talk to yourself (:");
        }

        showMessage(App.dataManager.getCurrentGame().getCurrentTurnPlayer(), targetPlayer, message);

        FriendshipWithPlayers friendship1 = getFriendshipWithPlayers(App.dataManager.getCurrentGame().getCurrentTurnPlayer(), targetPlayer);
        FriendshipWithPlayers friendship2 = getFriendshipWithPlayers(targetPlayer ,App.dataManager.getCurrentGame().getCurrentTurnPlayer());

        friendship1.addTalkHistory(message);
        friendship2.addTalkHistory(message);


        if ( ! getFriendshipWithPlayers(App.dataManager.getCurrentGame().getCurrentTurnPlayer(), targetPlayer).isTalk() ){

            updateFriendshipTalk(App.dataManager.getCurrentGame().getCurrentTurnPlayer(), targetPlayer);

        }


        return new Result(true,"Message sent.");
    }

    private void updateFriendshipTalk(Player player1, Player player2){

        FriendshipWithPlayers friendship1 = getFriendshipWithPlayers(player1, player2);
        FriendshipWithPlayers friendship2 = getFriendshipWithPlayers(player2, player1);

        if ( ! friendship1.isTalk() ){

            friendship1.setTalk(true);
            friendship2.setTalk(true);
            friendship1.setInteraction(true);
            friendship2.setInteraction(true);

            if ( (friendship1.getFriendshipXP() + 20) > ((friendship1.getFriendshipLevel().getLevel()+1) * 100) ){

                if ( friendship1.getFriendshipLevel().getLevel() < 4 ){

                    friendship1.setFriendshipXP((friendship1.getFriendshipXP() + 20) - ((friendship1.getFriendshipLevel().getLevel()+1) * 100));
                    friendship1.setFriendshipLevel(FriendshipLevel.values()[(friendship1.getFriendshipLevel().getLevel()+1)]);

                    friendship2.setFriendshipXP((friendship2.getFriendshipXP() + 20) - ((friendship2.getFriendshipLevel().getLevel()+1) * 100));
                    friendship2.setFriendshipLevel(FriendshipLevel.values()[(friendship2.getFriendshipLevel().getLevel()+1)]);

                }
                else{
                    friendship1.setFriendshipXP((friendship1.getFriendshipXP() + 20) - ((friendship1.getFriendshipLevel().getLevel()+1) * 100));
                    friendship2.setFriendshipXP((friendship2.getFriendshipXP() + 20) - ((friendship2.getFriendshipLevel().getLevel()+1) * 100));
                }

            }
            else{
                friendship1.setFriendshipXP(friendship1.getFriendshipXP() + 20);
                friendship2.setFriendshipXP(friendship2.getFriendshipXP() + 20);

            }

        }

    }

    private FriendshipWithPlayers getFriendshipWithPlayers(Player player1, Player player2){

        for ( FriendshipWithPlayers friendship : player1.getFriendships() ){

            if ( friendship.getTargetPlayer().equals(player2) ){
                return friendship;
            }

        }

        return null;

    }

    private void showMessage(Player messageSender, Player targetPlayer, String message){

        int lines = (int)Math.floor((double) message.length() /50) +1;

        System.out.println("************************************************************");
        System.out.println("*                                                          *");
        String firstText = "* Dear " + targetPlayer.getUsername() + ", Here is a message from " + messageSender.getUsername() + ":                                                                    ";
        char[] chars = firstText.toCharArray();
        chars[59] = '*';
        firstText = new String(chars);
        System.out.println(firstText);
        for ( int i = 0 ; i < lines-1; i++ ){
            System.out.println("*    " + message.substring(i*50, (i+1)*50) + "    *");
        }


        String lastLine = "*    " + message.substring((lines-1)*50) + "                                                                        ";
        chars = lastLine.toCharArray();
        chars[59] = '*';
        lastLine = new String(chars);

        System.out.println(lastLine);        /// CHECK
        System.out.println("*                                                          *");
        System.out.println("************************************************************");

    }

    private Player getPlayerByUsername(String username) {
        for (Player player : App.dataManager.getCurrentGame().getPlayers()) {
//            System.err.println("user is:" + player.getUsername());
            if (player.getUsername().trim().equals(username.trim())) {
                return player;
            }
        }
        return null;
    }

    public  void showTalkHistory(Matcher input){

        Player targetPlayer = getPlayerByUsername(input.group("username"));

        if ( targetPlayer == null ){
            System.out.println("User not found.");
            return;
        }

        System.out.println("Talk History between: " + App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername() + " and " + targetPlayer.getUsername());
        for ( String message : getFriendshipWithPlayers(App.dataManager.getCurrentGame().getCurrentTurnPlayer(),targetPlayer).getTalkHistory() ){
            System.out.println("*   " + message);
        }




    }

    ///        ----------------------->



    private Game getCurrentGame() {
        return App.dataManager.getCurrentGame();
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
        if (isNear(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            //all conditions passed for sending the message
            //game error

            return new Result(true, "You have successfully sent a message to: "
                    + targetPlayer.getUsername() + ". Your current friendship level with them is "
                    + game.getUserFriendship(App.dataManager.getCurrentGame().getCurrentTurnPlayer(), targetPlayer));
        }
        return new Result(false, "You must stand next to " + targetPlayer.getUsername() + "to be able to talk to them.");
    }

    public Result showTalkHistoryWithUser(String username) {
        Game game = getCurrentGame();
        User targetPlayer = game.getPlayerByUsername(username);
        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }
        StringBuilder historyMessage = new StringBuilder("Your talk history with " + username + ": ");
        HashMap<String, Boolean> sentMessages = game.getTalkHistory().get(App.dataManager.getCurrentGame().getCurrentTurnPlayer()).get(targetPlayer);
        historyMessage.append("You: ").append(sentMessages).append("\n");
        HashMap<String, Boolean> receivedMessages = game.getTalkHistory().get(App.dataManager.getCurrentGame().getCurrentTurnPlayer()).get(targetPlayer);
        historyMessage.append(username).append(": \n").append(receivedMessages).append("\n");
        return new Result(true, historyMessage.toString().trim());
    }

    public Result giveGift(String username, String itemName, int amount) {
        Game game = getCurrentGame();


        Player targetPlayer = game.getPlayerByUsername(username);
        if (targetPlayer == null) {
            return new Result(false, "User not found.");
        }
        if (!isNear(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            return new Result(false, "You must get near to " + username + " to be able to give them a gift.");
        }
        Item item = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack().getItemFromInventoryByName(itemName);
        //get item from backpack
        if (item == null) {
            return new Result(false, "Item not found.");
        }

        return new Result(true, "You give " + itemName + " from " + username + ".");
    }

    public Result giftList() {
        Game game = getCurrentGame();

        StringBuilder giftListMessage = new StringBuilder("Gift List: \n");
        for (Gift gift : App.dataManager.getCurrentGame().getCurrentTurnPlayer().getGift()) {
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
        return null;
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
        if (!isNear(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition(), targetPlayer.getCurrentPosition())) {
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

        if (!isNear(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition(), targetPlayer.getCurrentPosition())) {
            return new Result(false, "You must get near to " + username + " to propose to them.\n");
        }
        if (App.dataManager.getCurrentGame().getCurrentTurnPlayer().getGender().equals(targetPlayer.getGender())) {
            return new Result(false, "You are not allowed to marry a person of the same gender.");
        }
        boolean hasRing = false;
        if (!hasRing) {
            return new Result(false, "You do not have a ring to propose with:(");
        }
//        if(){
//            return new Result(false,"Your friendship level must be at least three in order to porpose.");
//        }
        // call the method for sending the marriage request.
        return new Result(true, "Your marriage proposal has been successfully sent to "+username+".");
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

        NPC npc = game.getNPCByName(npcName);
        if ( npc == null ) {

            return new Result(false, "NPC not found.");

        }

        // TODO
//        if ( closeTo(npc.getPosition(), App.dataManager.getCurrentGame().getCurrentTurnPlayer().getCurrentPosition()) ) {
//
//            return new Result(false, "You must be close to the Npc in order to talk to them.");
//
//        }

        Situation situation = new Situation(

                                            App.dataManager.getCurrentGame().getTime().getHour(),

                                            App.dataManager.getCurrentGame().getTime().getSeason(),

                                            App.dataManager.getCurrentGame().getWeather()

                                            );

        String dialog = npc.getType().getDialogBySituation(situation);

        if (dialog == null) {
            return new Result(false, npcName + " has no dialog right now.");
        }

        return new Result(true, npcName + ": " + dialog);

    }

    public Result giftNPC(String npcName, String itemName) {
        Game game = getCurrentGame();

        NPC npc = game.getNPCByName(npcName);
        if (npc == null) {
            return new Result(false, "NPC not found.");
        }

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






        public Result crowAttack() {

        return null;

    }

    public int howMuchWater() {

        return 0;

    }

    //----------------------> ENERGY

    public Result showPlayerEnergy() {
        int playerEnergy = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getEnergy();
        return new Result(true, "Your energy is: " + playerEnergy);
    }

    public Result setPlayerEnergy(Matcher input){
            Integer amount;
        try{
            amount = Integer.parseInt(input.group("value"));
        }
        catch (Exception e){
            return new Result(false,"Invalid coordinate");
        }

        App.dataManager.getCurrentGame().getCurrentTurnPlayer().setEnergy(amount);
        return new Result(true,"Thor cheat successfully applied");
    }


    public Result setUnlimitedEnergy() {
        App.dataManager.getCurrentGame().getCurrentTurnPlayer().setEnergyUnlimited(true);
        return new Result(true, "Unlimited Energy activated!");
    }

    public Result faint() {
        App.dataManager.getCurrentGame().getCurrentTurnPlayer().faint();
        // Skip to next day logic would go here
        // For now, we'll just set energy to 150 as specified
        return new Result(true, "You fainted and woke up the next day with 150 energy.");
    }

//    public Result showLearntCookingRecipes() {
//        String learntRecipes = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getStringLearntCookingRecipes();
//        return new Result(true, learntRecipes);
//    }

//    public Result learnNewRecipe() {
//
//        return null;
//    }

//    public Result showLearntCraftRecipes() {
//        String learntRecipes = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getStringLearntCraftRecipes();
//        return new Result(true, learntRecipes);
//    }


    public Result inventoryShow() {
        // Get the player's inventory contents
        Backpack playerBackpack = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack();

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

        Backpack playerBackpack = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack();

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

        Backpack playerBackpack = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack();
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

        Backpack currentBackpack = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack();
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
        App.dataManager.getCurrentGame().getCurrentTurnPlayer().upgradeBackpack(newType);

        return new Result(true, "Your backpack has been upgraded to " + newType + "!");
    }

    public Result showBackpackInfo() {
        Backpack playerBackpack = App.dataManager.getCurrentGame().getCurrentTurnPlayer().getBackpack();

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
    //ALL THE METHODS RELATED TO TOOLS


//
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
        App.dataManager.getCurrentGame().getCurrentTurnPlayer().eat(food.getName());
        return new Result(true, "");
    }

    private boolean canCraft(Item item) {
        return false;
    }

    private boolean canCook(Food food) {
        return false;
    }


    private boolean canItemBePlacedHere(Position position, Item item) {
        return false;
    }



    private Tile getTileByPosition(Position position) {
        return null;
    }


    public Result walk(Path path, boolean playerConfirmed) {
        if (!playerConfirmed) {
            return new Result(false, "You denied the walk.");
        }
        Position destination = path.getPathTiles().getLast();
        App.dataManager.getCurrentGame().getCurrentTurnPlayer().changePosition(destination);
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
                leveledUp = App.dataManager.getCurrentGame().getCurrentTurnPlayer().addSkillXP(Skill.FARMING, 5);
                break;
            case MINING:
                leveledUp = App.dataManager.getCurrentGame().getCurrentTurnPlayer().addSkillXP(Skill.MINING, 10);
                break;
            case FORAGING:
                leveledUp = App.dataManager.getCurrentGame().getCurrentTurnPlayer().addSkillXP(Skill.FORAGING, 10);
                break;
            case FISHING:
                leveledUp = App.dataManager.getCurrentGame().getCurrentTurnPlayer().addSkillXP(Skill.FISHING, 5);
                break;
        }

        // If player leveled up, we could notify them or apply effects
        if (leveledUp) {
            // Could send a notification or apply immediate effects
        }
    }





    /// AMIR YOUSOF: INVENTORY




}
