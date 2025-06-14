package org.example.view;


import org.example.controller.Game.GameController;
import org.example.models.App;
import org.example.models.Player;
import org.example.models.enums.Skill;
import org.example.models.enums.commands.GameCommands;
import org.example.models.enums.commands.PreGameMenuCommands;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Game implements AppMenu {

    private final GameController gameController = new GameController();
    private boolean exitingGame = false;

    @Override
    public void getInput(String input, Scanner scanner) {


        ///  GENERAL COMMANDS

        if ( GameCommands.EXIT_GAME.getMatcher(input) != null ) {

            System.out.println(gameController.exitGame().message());
            exitingGame = true;

        }
        else if ( GameCommands.CHEAT_ADD_ITEM2.getMatcher(input) != null ){

            System.out.println(gameController.cheatAddItemToInventory(GameCommands.CHEAT_ADD_ITEM2.getMatcher(input)).message());

        }
        else if ( GameCommands.SHOW_INVENTORY2.getMatcher(input) != null ){

            gameController.showInventory();

        }
        else if ( GameCommands.SHOW_MONEY.getMatcher(input) != null ){
            System.out.println(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getGold());
        }
        else if ( GameCommands.NEXT_TURN.getMatcher(input) != null ) {

            System.out.printf("Moving on from " + App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername() + " to ");
            App.dataManager.getCurrentGame().setCurrentTurnPlayer(gameController.nextTurn());
            System.out.println(App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername());

        }
        else if( GameCommands.WALK.getMatcher(input) != null){
            App.dataManager.getCurrentGame().handleWalk(input,scanner);
        }
        else if( GameCommands.TELEPORT.getMatcher(input) != null){
            App.dataManager.getCurrentGame().teleport(input);
        }
        else if( GameCommands.PRINT_MAP.getMatcher(input) != null){
            App.dataManager.getCurrentGame().showMapPartly(input);
        }
        else if( GameCommands.HELP_READING_MAP.getMatcher(input) != null){
            App.dataManager.getCurrentGame().helpReadingMap();
        }
        else if ( GameCommands.SHOW_MAP.getMatcher(input) != null ) {
            System.out.println(App.dataManager.getCurrentGame().handleShowMap());
        }
        else if( GameCommands.SHOW_CURRENT_MENU.getMatcher(input) != null){
            App.dataManager.getCurrentGame().showCurrentMenu();
        }






        ///  COOKING

        else if (GameCommands.COOKING_REFRIGERATOR.getMatcher(input) != null) {
            System.out.println(gameController.handleRefrigerator(GameCommands.COOKING_REFRIGERATOR.getMatcher(input)));
        }
        else if (GameCommands.COOKING_SHOW_RECIPES.getMatcher(input) != null) {
            System.out.println(gameController.showCookingRecipes());
        }
        else if (GameCommands.COOKING_PREPARE.getMatcher(input) != null) {
            System.out.println(gameController.prepareRecipe(GameCommands.COOKING_PREPARE.getMatcher(input)));
        }
        else if (GameCommands.EAT_FOOD.getMatcher(input) != null) {
            System.out.println(gameController.eatFood(GameCommands.EAT_FOOD.getMatcher(input)));
        }


        /// CRAFTING

        else if (GameCommands.SHOW_CRAFTING_RECIPES.getMatcher(input) != null) {
            System.out.println(gameController.showCraftingRecipes());
        }
        else if (GameCommands.CHEAT_ADD_ITEM.getMatcher(input) != null) {
            System.out.println(gameController.cheatAddItem(GameCommands.CHEAT_ADD_ITEM.getMatcher(input)));
        }



        ///  TIME & DATE

        else if (GameCommands.SHOW_TIME.getMatcher(input) != null) {


            System.out.println(gameController.showTime());


        }
        else if (GameCommands.SHOW_DATE.getMatcher(input) != null) {


            System.out.println(gameController.showDate());


        }
        else if (GameCommands.SHOW_DATETIME.getMatcher(input) != null) {


            System.out.println(gameController.showDateTime());


        }
        else if (GameCommands.SHOW_DAY_OF_THE_WEEK.getMatcher(input) != null) {


            System.out.println(gameController.showDayOfTheWeek());


        }
        else if (GameCommands.CHEAT_ADVANCE_TIME.getMatcher(input) != null) {


            System.out.println(gameController.cheatAdvanceTime(GameCommands.CHEAT_ADVANCE_TIME.getMatcher(input).group("time")).message());


        }
        else if (GameCommands.CHEAT_ADVANCE_DATE.getMatcher(input) != null) {


            System.out.println(gameController.cheatAdvanceDate(GameCommands.CHEAT_ADVANCE_DATE.getMatcher(input).group("date")).message());


        }
        else if (GameCommands.SHOW_SEASON.getMatcher(input) != null) {


            System.out.println(gameController.showSeason());


        }


        ///  WEATHER

        else if ( GameCommands.CHEAT_THOR.getMatcher(input) != null ) {

            System.out.println(gameController.cheatThor(GameCommands.CHEAT_THOR.getMatcher(input)).message());

        }
        else if ( GameCommands.SHOW_WEATHER.getMatcher(input) != null ) {

            System.out.println(gameController.showWeather());

        }
        else if ( GameCommands.SHOW_WEATHER_FORECAST.getMatcher(input) != null ) {

            System.out.println(gameController.showWeatherForecast());

        }
        else if ( GameCommands.CHEAT_WEATHER_SET.getMatcher(input) != null ) {

            System.out.println(gameController.cheatSetWeather(GameCommands.CHEAT_WEATHER_SET.getMatcher(input)).message());

        }




        else if( GameCommands.PICKUP.getMatcher(input) != null){
            if(App.dataManager.getCurrentGame().pickUpGroundItem()){
                System.out.println("Item picked up successfully");
            }
            else{
                System.out.println("Ummm no no");
            }
        }

        ///ENERGY
        
        
        else if( GameCommands.SHOW_ENERGY.getMatcher(input) != null){
            System.out.println(gameController.showPlayerEnergy().message());
        }
        else if( GameCommands.SET_ENERGY.getMatcher(input) != null){
            System.out.println(gameController.setPlayerEnergy(GameCommands.SET_ENERGY.getMatcher(input)).message());
        }
        else if(GameCommands.SET_UNLIMITED_ENERGY.getMatcher(input) != null){
            System.out.println(gameController.setUnlimitedEnergy().message());
        }
        else if( GameCommands.SKILL_XP_GAIN.getMatcher(input) != null){

            String stringValue = GameCommands.SKILL_XP_GAIN.getMatcher(input).group("skillName");
            Skill skill = Skill.valueOf(stringValue.toUpperCase());
            int amount = Integer.parseInt(GameCommands.SKILL_XP_GAIN.getMatcher(input).group("value"));
            gameController.handleSkillXPGain(skill, amount);
        }


        /// TOOLS

        else if (GameCommands.TOOLS_EQUIP.getMatcher(input) != null) {
            String toolName = GameCommands.TOOLS_EQUIP.getMatcher(input).group("toolName");
            System.out.println(gameController.equipTool(toolName).message());
        }
        else if (GameCommands.TOOLS_SHOW_CURRENT.getMatcher(input) != null) {
            System.out.println(gameController.showCurrentTool().message());
        }
        else if (GameCommands.TOOLS_SHOW_AVAILABLE.getMatcher(input) != null) {
            System.out.println(gameController.showAvailableTools().message());
        }
        else if (GameCommands.TOOLS_UPGRADE.getMatcher(input) != null) {
            String toolName = GameCommands.TOOLS_UPGRADE.getMatcher(input).group("toolName");
            System.out.println(gameController.upgradeTool(toolName).message());
        }
        else if (GameCommands.TOOLS_USE.getMatcher(input) != null) {
            String direction = GameCommands.TOOLS_USE.getMatcher(input).group("direction");
            System.out.println(gameController.useTool(direction).message());
        }


        ///  DAMDARI

        else if (GameCommands.BUILD.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if ( GameCommands.BUY_ANIMAL.getMatcher(input) != null) {


            System.out.println(gameController.buyAnimal(GameCommands.BUY_ANIMAL.getMatcher(input)).message());


        }
        else if (GameCommands.PET.getMatcher(input) != null) {


            System.out.println(gameController.petAnimal(GameCommands.PET.getMatcher(input)).message());


        }
        else if (GameCommands.CHEAT_SET_FRIENDSHIP.getMatcher(input) != null) {


            System.out.println(gameController.cheatSetFriendship(GameCommands.CHEAT_SET_FRIENDSHIP.getMatcher(input)).message());


        }
        else if (GameCommands.SHOW_ANIMAL_INFO.getMatcher(input) != null) {


            gameController.showAnimalInfo(GameCommands.SHOW_ANIMAL_INFO.getMatcher(input));

        }
        else if (GameCommands.SHEPHERD_ANIMALS.getMatcher(input) != null) {


            System.out.println(gameController.shepherd(GameCommands.SHEPHERD_ANIMALS.getMatcher(input)).message());


        }
        else if (GameCommands.FEED_HAY.getMatcher(input) != null) {


            System.out.println(gameController.feedWithHay(GameCommands.FEED_HAY.getMatcher(input)).message());


        }
        else if (GameCommands.SHOW_UNCOLLECTED_PRODUCTS.getMatcher(input) != null) {


            gameController.showUncollectedProducts();


        }
        else if (GameCommands.COLLECT_PRODUCTS.getMatcher(input) != null) {


            System.out.println(gameController.collectProducts(GameCommands.COLLECT_PRODUCTS.getMatcher(input)).message());


        }
        else if (GameCommands.SELL_ANIMAL.getMatcher(input) != null) {

            System.out.println(gameController.sellAnimal(GameCommands.SELL_ANIMAL.getMatcher(input)).message());


        }
        else if (GameCommands.FISHING.getMatcher(input) != null) {


            System.out.println(gameController.fishing(GameCommands.FISHING.getMatcher(input)).message());


        }


        ///  ARTISAN

//        else if (GameCommands.ARTISAN_USE.getMatcher(input) != null) {
//            Matcher matcher = GameCommands.ARTISAN_USE.getMatcher(input);
//            System.out.println(gameController.useArtisan(matcher));
//        }
//
//        else if (GameCommands.ARTISAN_GET.getMatcher(input) != null) {
//
//
//            System.out.println("build new building");
//
//
//        }

        ///  SHOP

        else if (GameCommands.SHOW_ALL_PRODUCTS_IN_STORE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_AVAILABLE_PRODUCTS_IN_STORE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.PURCHASE_ITEM.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.CHEAT_ADD_MONEY.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SELL_ITEM.getMatcher(input) != null) {


            System.out.println("build new building");


        }


        /// TAAMOLAT VA RAVABET BA DIGAR BAZIKONAN

        else if (GameCommands.SHOW_FRIENDSHIP.getMatcher(input) != null) {


            gameController.showFriendships();


        }
        else if (GameCommands.TALK_WITH_OTHERS.getMatcher(input) != null) {


            System.out.println(gameController.talk(GameCommands.TALK_WITH_OTHERS.getMatcher(input)).message());


        }
        else if (GameCommands.SHOW_TALK_HISTORY.getMatcher(input) != null) {

            gameController.showTalkHistory(GameCommands.SHOW_TALK_HISTORY.getMatcher(input));


        }
        else if (GameCommands.GIVE_GIFT_TO_OTHERS.getMatcher(input) != null) {


            System.out.println(gameController.giveGift(GameCommands.GIVE_GIFT_TO_OTHERS.getMatcher(input),scanner).message());


        }
        else if (GameCommands.SHOW_RECEIVED_GIFTS.getMatcher(input) != null) {


            System.out.println("build new building");


        }

        else if (GameCommands.GIFT_HISTORY_WITH_USER.getMatcher(input) != null) {


            gameController.showGiftHistory(GameCommands.GIFT_HISTORY_WITH_USER.getMatcher(input));


        }
        else if (GameCommands.HUG_USER.getMatcher(input) != null) {


            System.out.println(gameController.hugPlayer(GameCommands.HUG_USER.getMatcher(input)).message());


        }
        else if (GameCommands.FLOWER_USER.getMatcher(input) != null) {


            System.out.println(gameController.flowerPlayer(GameCommands.FLOWER_USER.getMatcher(input)).message());


        }
        else if (GameCommands.ASK_MARRIAGE.getMatcher(input) != null) {


            System.out.println(gameController.askMarriage(GameCommands.ASK_MARRIAGE.getMatcher(input),scanner).message());


        }


        ///  TRADE

        else if (GameCommands.START_TRADE.getMatcher(input) != null) {


           gameController.startTradeMenu();


        }


        /// NPC

        else if (GameCommands.MEET_NPC.getMatcher(input) != null) {


            System.out.println(gameController.meetNPC(GameCommands.MEET_NPC.getMatcher(input).group(1)).message());


        }
        else if (GameCommands.GIFT_NPC.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_FRIENDSHIP_WITH_NPC.getMatcher(input) != null) {


            System.out.println(gameController.showFriendshipNPCList().message());


        }
        else if (GameCommands.SHOW_QUESTS_LIST.getMatcher(input) != null) {


            System.out.println(gameController.showQuestsList().message());


        }
        else if (GameCommands.FINISH_QUESTS.getMatcher(input) != null) {


            System.out.println("build new building");


        }

        else{


            System.out.println("Invalid input");


        }


        if ( GameCommands.EXIT_GAME.getMatcher(input) == null ){
            System.out.printf("It is " + App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername() + "'s turn: ");
        }

    }




}
