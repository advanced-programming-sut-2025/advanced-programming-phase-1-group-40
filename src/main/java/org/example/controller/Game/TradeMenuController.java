package org.example.controller.Game;

import org.example.models.*;
import org.example.models.Animal.AnimalProduct;
import org.example.models.Map.SecondaryMapComponents.Crop;
import org.example.models.Map.SecondaryMapComponents.ForagingCrop;
import org.example.models.Map.SecondaryMapComponents.ForagingMineral;
import org.example.models.enums.Menu;
import org.example.models.enums.types.TradeType;
import org.example.models.inventory.Inventory;

import java.util.regex.Matcher;


public class TradeMenuController {

    private Player getPlayerByUsername(String username) {
        for (Player player : App.dataManager.getCurrentGame().getPlayers()) {
            if (player.getUsername().trim().equals(username.trim())) {
                return player;
            }
        }
        return null;
    }


    private Item getItemByName(Player player ,String name) {

        for (Item item : player.getBackpack().getItems()) {

            if (item instanceof AnimalProduct) {

                if (((AnimalProduct) item).getType().getDisplayName().equals(name)) {
                    return item;
                }

            }

            if (item instanceof ForagingMineral) {

                if (((ForagingMineral) item).getMineralType().getDisplayName().equals(name)) {
                    return item;
                }

            }

            if (item instanceof ForagingCrop) {

                if (((ForagingCrop) item).getType().getDisplayName().equals(name)) {
                    return item;
                }

            }

            if (item instanceof Crop) {

                if (((Crop) item).getCropType().getDisplayName().equals(name)) {
                    return item;
                }

            }

            if (item instanceof ShopItem) {

                if (((ShopItem) item).getType().getDisplayName().equals(name)) {
                    return item;
                }

            }

        }
        return null;
    }


    public Result tradeWithMoney(Matcher input){

        Trade newTrade = new Trade();
        newTrade.setType2(TradeType.MONEY);
        if ( getPlayerByUsername(input.group("username")) == null ){
            return new Result(false,"Target player not found");
        }

        if ( input.group("type").trim().toLowerCase().equals("offer") ) {
            newTrade.setType1(TradeType.OFFER);
        }
        else if ( input.group("type").trim().toLowerCase().equals("request") ){
            newTrade.setType1(TradeType.REQUEST);
        }
        else{
            return new Result(false, "Invalid trade type");
        }



        Player sender;
        Player receiver;

        if ( newTrade.getType1() == TradeType.OFFER ) {

            sender = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            receiver = getPlayerByUsername(input.group("username"));

        }
        else{

            receiver = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            sender = getPlayerByUsername(input.group("username"));

        }


        if ( sender.equals(receiver) ) {
            return new Result(false, "You cant trade with yourself");
        }


        newTrade.setSender(sender);
        newTrade.setReceiver(receiver);




        Item item = getItemByName(sender,input.group("item"));

        if ( item == null ){
            return new Result(false,"Item does not exist");
        }

        int amount;
        try{
            amount = Integer.parseInt(input.group("amount"));
        }
        catch (NumberFormatException e){
            return new Result(false, "Amount is not a number");
        }

        int price;
        try{
            price = Integer.parseInt(input.group("price"));
        }
        catch (NumberFormatException e){
            return new Result(false, "Price is not a number");
        }

        newTrade.setItem1(item);
        newTrade.setAmount1(amount);
        newTrade.setPrice(price);

        return new Result(true,"Trade Listed successfully");

    }

    public Result tradeWithItem(Matcher input){

        Trade newTrade = new Trade();
        newTrade.setType2(TradeType.ITEM);

        if ( getPlayerByUsername(input.group("username")) == null ){
            return new Result(false,"Target player not found");
        }

        if ( input.group("type").trim().toLowerCase().equals("offer") ) {
            newTrade.setType1(TradeType.OFFER);
        }
        else if ( input.group("type").trim().toLowerCase().equals("request") ){
            newTrade.setType1(TradeType.REQUEST);
        }
        else{
            return new Result(false, "Invalid trade type");
        }



        Player sender;
        Player receiver;

        if ( newTrade.getType1() == TradeType.OFFER ) {

            sender = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            receiver = getPlayerByUsername(input.group("username"));

        }
        else{

            receiver = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            sender = getPlayerByUsername(input.group("username"));

        }


        if ( sender.equals(receiver) ) {
            return new Result(false, "You cant trade with yourself");
        }


        newTrade.setSender(sender);
        newTrade.setReceiver(receiver);




        Item item1 = getItemByName(sender,input.group("item"));
        Item item2 = getItemByName(sender,input.group("targetItem"));

        if ( item1 == null || item2 == null ){
            return new Result(false,"Item does not exist");
        }

        int amount1;
        int amount2;
        try{
            amount1 = Integer.parseInt(input.group("amount"));
            amount2 = Integer.parseInt(input.group("targetAmount"));
        }
        catch (NumberFormatException e){
            return new Result(false, "Amount is not a number");
        }



        newTrade.setItem1(item1);
        newTrade.setItem2(item2);
        newTrade.setAmount1(amount1);
        newTrade.setAmount2(amount2);

        return new Result(true,"Trade Listed successfully");

    }


    public Result trade(String username, String typeStr, String itemName, String amountStr, String priceStr,
                        String targetItemName, String targetAmountStr) {
        User player = App.dataManager.getCurrentUser();
        if (username.equals(player.getUsername())) {
            return new Result(false, "You can't trade with yourself.");
        }

        Game game = App.dataManager.getCurrentGame();

        User targetUser = game.getPlayerByUsername(username);
        if (targetUser == null) {
            return new Result(false, "User not found.");
        }

        if (!amountStr.matches("\\d+")) {
            return new Result(false, "Invalid amount.");
        }
        int amount = Integer.parseInt(amountStr);

        // TODO: Item item = ...
//        if (item == null) {
//            return new Result(false, "Item not found.");
//        }

        boolean isOffer = typeStr.equals("offer");
        if (priceStr != null) {
            int price = Integer.parseInt(priceStr);
            if (targetItemName != null) {
                return new Result(false, "You can only trade with money or item and not both.");
            }
            // TODO
        }
        return new Result(true, "");
    }

    public Result showTradeList() {
        return new Result(true, "");
    }

    public Result tradeResponse(String response, String idStr) {
        return new Result(true, "");
    }

    public Result showTradeHistory() {
        return new Result(true, "");

    }

    public void exitTradeMenu(){
        App.dataManager.setCurrentMenu(Menu.GAME);
        System.out.println("You are back to the game");
    }

}
