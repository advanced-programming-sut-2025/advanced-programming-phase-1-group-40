package org.example.controller.Game;

import org.example.models.*;
import org.example.models.Animal.AnimalProduct;
import org.example.models.Animal.AnimalProductQuality;
import org.example.models.Map.SecondaryMapComponents.Crop;
import org.example.models.Map.SecondaryMapComponents.ForagingCrop;
import org.example.models.Map.SecondaryMapComponents.ForagingMineral;
import org.example.models.enums.Menu;
import org.example.models.enums.commands.GameCommands;
import org.example.models.enums.commands.TradeMenuCommands;
import org.example.models.enums.types.*;
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

    private Item getItemByNameForCheat(String name){

        for ( CraftTypes craftType : CraftTypes.values() ){
            if ( craftType.getName().equals(name) ){
                return new Craft(craftType);
            }
        }

        for ( AnimalProductType animalProductType : AnimalProductType.values() ){
            if ( animalProductType.getDisplayName().equals(name) ){
                return new AnimalProduct(animalProductType, AnimalProductQuality.NORMAL);
            }
        }

        for ( ForagingMineralType foragingMineralType : ForagingMineralType.values() ){
            if ( foragingMineralType.getDisplayName().equals(name) ){
                return new ForagingMineral(new Position(0,0), foragingMineralType);     /// POSITION PLAYER MITOONE BASHE
            }
        }

        for ( ForagingCropType foragingCropType : ForagingCropType.values() ){
            if ( foragingCropType.getDisplayName().equals(name) ){
                return new ForagingCrop(new Position(0,0), foragingCropType);
            }
        }

        for ( CropType cropType : CropType.values() ){
            if ( cropType.getDisplayName().equals(name) ){
                Crop newCrop = new Crop(new Position(0,0));
                newCrop.setCropType(cropType);
                return newCrop;
            }
        }

        for ( ShopItemTypes shopItemType : ShopItemTypes.values() ){
            if ( shopItemType.getDisplayName().equals(name) ){
                return new ShopItem(shopItemType);
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
            newTrade.setSenderAccepted(true);
            newTrade.setReceiverAccepted(false);
            newTrade.setTargetPlayer(receiver);

        }
        else{

            receiver = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            sender = getPlayerByUsername(input.group("username"));
            newTrade.setSenderAccepted(false);
            newTrade.setReceiverAccepted(true);
            newTrade.setTargetPlayer(sender);


        }


        if ( sender.equals(receiver) ) {
            return new Result(false, "You cant trade with yourself");
        }


        newTrade.setSender(sender);
        newTrade.setReceiver(receiver);




        Item item = getItemByNameForCheat(input.group("item"));

        if ( item == null ){
            return new Result(false,"Item does not exist");
        }

        item = getItemByName(sender,input.group("item"));

        if ( item == null ){
            return new Result(false,"Sender does not have this item");
        }

        int amount;
        try{
            amount = Integer.parseInt(input.group("amount"));
        }
        catch (NumberFormatException e){
            return new Result(false, "Amount is not a number");
        }

        if ( sender.getBackpack().getItemCount(item) < amount ){
            return new Result(false,"Sender does not have enough of this item");
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

        App.dataManager.getCurrentGame().addTrade(newTrade);

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



        Player sender;      // ITEM AVALO MIFRESTE
        Player receiver;

        if ( newTrade.getType1() == TradeType.OFFER ) {

            sender = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            receiver = getPlayerByUsername(input.group("username"));
            newTrade.setSenderAccepted(true);
            newTrade.setReceiverAccepted(false);
            newTrade.setTargetPlayer(receiver);

        }
        else{

            receiver = App.dataManager.getCurrentGame().getCurrentTurnPlayer();
            sender = getPlayerByUsername(input.group("username"));
            newTrade.setSenderAccepted(false);
            newTrade.setReceiverAccepted(true);
            newTrade.setTargetPlayer(sender);


        }


        if ( sender.equals(receiver) ) {
            return new Result(false, "You cant trade with yourself");
        }


        newTrade.setSender(sender);
        newTrade.setReceiver(receiver);




        Item item1 = getItemByNameForCheat(input.group("item"));
        Item item2 = getItemByNameForCheat(input.group("targetItem"));

        if ( item1 == null || item2 == null ){
            return new Result(false,"Item does not exist");
        }

        if ( newTrade.getType1() == TradeType.OFFER ) {
            item1 = getItemByName(sender,input.group("item"));
            if ( item1 == null ){
                return new Result(false,"Sender does not have this item");
            }
            item2 = getItemByName(receiver,input.group("targetItem"));
            if ( item2 == null ){
                return new Result(false,"Receiver does not have this item");
            }
        }
        else{

            item1 = getItemByName(receiver, input.group("item"));
            if (item1 == null) {
                return new Result(false, "Receiver does not have this item");
            }
            item2 = getItemByName(receiver, input.group("targetItem"));
            if (item2 == null) {
                return new Result(false, "Sender does not have this item");
            }

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

        if ( sender.getBackpack().getItemCount(item1) < amount1 ){
            return new Result(false,"Sender does not have enough of this item");
        }
        if ( sender.getBackpack().getItemCount(item2) < amount2 ){
            return new Result(false,"Receiver does not have enough of this item");
        }


        newTrade.setItem1(item1);
        newTrade.setItem2(item2);
        newTrade.setAmount1(amount1);
        newTrade.setAmount2(amount2);

        App.dataManager.getCurrentGame().addTrade(newTrade);

        return new Result(true,"Trade Listed successfully");

    }

    private Trade getTradeByID(int tradeID){
        for ( Trade trade : App.dataManager.getCurrentGame().getTrades() ){
            if ( trade.getTradeID() == tradeID ){
                return trade;
            }
        }
        return null;
    }

    public Result responseToTrade(Matcher input){

        String answer = input.group("answer");

        int tradeID;

        try{
            tradeID = Integer.parseInt(input.group("id"));
        }
        catch (NumberFormatException e){
            return new Result(false, "Trade ID is not a number");
        }

        Trade selectedTrade = getTradeByID(tradeID);

        if ( selectedTrade == null ){
            return new Result(false,"Trade does not exist");
        }

        if ( ! App.dataManager.getCurrentGame().getCurrentTurnPlayer().equals(selectedTrade.getTargetPlayer()) ){
            return new Result(false,"You are not the target player");
        }

        if ( ! selectedTrade.isTradeOpen() ){
            return new Result(false,"Trade is not open");
        }

        if ( answer.trim().toLowerCase().equals("reject") ) {

            if ( App.dataManager.getCurrentGame().getCurrentTurnPlayer().equals(selectedTrade.getSender()) ){
                selectedTrade.setSenderAccepted(false);
            }
            else{
                selectedTrade.setReceiverAccepted(false);
            }

            selectedTrade.closeTrade();
            return new Result(false,"Trade rejected successfully");
        }

        if ( selectedTrade.getType2() == TradeType.MONEY ) {

            if ( selectedTrade.getSender().getBackpack().hasItem(selectedTrade.getItem1()) < selectedTrade.getAmount1()){
                return new Result(false,"Sender does not have item");
            }
            if ( selectedTrade.getReceiver().getGold() < selectedTrade.getPrice() ){
                return new Result(false,"Receiver does not have enough gold");
            }

            selectedTrade.getSender().setGold(selectedTrade.getSender().getGold() + selectedTrade.getPrice());
            selectedTrade.getSender().getBackpack().removeFromInventory(selectedTrade.getItem1(),selectedTrade.getAmount1());

            selectedTrade.getReceiver().setGold(selectedTrade.getReceiver().getGold() - selectedTrade.getPrice());
            selectedTrade.getReceiver().getBackpack().addToInventory(selectedTrade.getItem1(),selectedTrade.getAmount1());


        }
        else {

            if ( selectedTrade.getSender().getBackpack().hasItem(selectedTrade.getItem1()) < selectedTrade.getAmount1()){
                return new Result(false,"Sender does not have item");
            }
            if ( selectedTrade.getReceiver().getBackpack().hasItem(selectedTrade.getItem2()) < selectedTrade.getAmount2()){
                return new Result(false,"Receiver does not have item");
            }

            selectedTrade.getSender().getBackpack().removeFromInventory(selectedTrade.getItem1(),selectedTrade.getAmount1());
            selectedTrade.getSender().getBackpack().addToInventory(selectedTrade.getItem2(),selectedTrade.getAmount2());

            selectedTrade.getReceiver().getBackpack().removeFromInventory(selectedTrade.getItem2(),selectedTrade.getAmount2());
            selectedTrade.getReceiver().getBackpack().addToInventory(selectedTrade.getItem1(),selectedTrade.getAmount1());


        }

        selectedTrade.closeTrade();
        return new Result(true,"Trade accepted successfully");

    }

    public void showTradeList() {

        for ( Trade trade : App.dataManager.getCurrentGame().getTrades() ){

            if ( ! trade.isTargetAlert() ){
                if ( trade.getTargetPlayer().equals(App.dataManager.getCurrentGame().getCurrentTurnPlayer()) ){
                    System.out.println("***** You have new Trade Offers *****");
                    trade.setTargetAlert(true);
                }
            }

        }

        System.out.println("----------TRADE LIST----------");

        for ( Trade trade : App.dataManager.getCurrentGame().getTrades() ){

            System.out.println(trade.getTradeID()+". " + trade.getReceiver().getUsername()+" wants ("
                    + trade.getAmount1() + " * " + trade.getItem1().getItemName() + ") from " + trade.getSender().getUsername());

        }

        System.out.println("------------------------------");

    }

    public void showTradeHistory() {

        for ( Trade trade : App.dataManager.getCurrentGame().getTrades() ){

            if ( ! trade.isTradeOpen() && trade.getSender().equals(App.dataManager.getCurrentGame().getCurrentTurnPlayer())){

                if ( trade.isSenderAccepted()){
                    System.out.println("You accepted trade from " + trade.getReceiver().getUsername());
                }
                else{
                    System.out.println("You declined trade from " + trade.getReceiver().getUsername());
                }

            }
            else if ( ! trade.isTradeOpen() && trade.getReceiver().equals(App.dataManager.getCurrentGame().getCurrentTurnPlayer())){

                if ( trade.isReceiverAccepted()){
                    System.out.println("You accepted trade from " + trade.getReceiver().getUsername());
                }
                else{
                    System.out.println("You declined trade from " + trade.getReceiver().getUsername());
                }

            }


        }

    }

    public void exitTradeMenu(){
        App.dataManager.setCurrentMenu(Menu.GAME);
        System.out.println("You are back to the game");
    }




}
