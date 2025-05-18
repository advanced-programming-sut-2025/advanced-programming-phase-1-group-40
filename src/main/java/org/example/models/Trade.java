package org.example.models;

import org.example.models.enums.types.TradeType;
import org.example.models.inventory.Inventory;

public class Trade {

    private final int tradeID;
    private boolean tradeIsOpen;
    private Player sender;
    private Player receiver;
    private boolean targetAlert;
    private boolean senderAccepted;
    private boolean receiverAccepted;
    private Player targetPlayer;
    private TradeType type1;
    private TradeType type2;


    private Integer price;


    private Item item1;         /// SENDER GIVES
    private Integer amount1;

    private Item item2;         /// RECEIVER GIVES
    private Integer amount2;

    public Trade(){
        this.tradeID = App.dataManager.getCurrentGame().getTrades().size() + 1;
        this.tradeIsOpen = true;
        this.targetAlert = false;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public void setTargetPlayer(Player targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public boolean isTargetAlert() {
        return targetAlert;
    }

    public void setTargetAlert(boolean targetAlert) {
        this.targetAlert = targetAlert;
    }

    public boolean isSenderAccepted() {
        return senderAccepted;
    }

    public void setSenderAccepted(boolean senderAccepted) {
        this.senderAccepted = senderAccepted;
    }

    public boolean isReceiverAccepted() {
        return receiverAccepted;
    }

    public void setReceiverAccepted(boolean receiverAccepted) {
        this.receiverAccepted = receiverAccepted;
    }

    public void closeTrade(){
        this.tradeIsOpen = false;
    }

    public boolean isTradeOpen(){
        return this.tradeIsOpen;
    }

    public int getTradeID() {
        return tradeID;
    }

    public Player getSender() {
        return sender;
    }

    public void setSender(Player sender) {
        this.sender = sender;
    }

    public Player getReceiver() {
        return receiver;
    }

    public void setReceiver(Player receiver) {
        this.receiver = receiver;
    }

    public TradeType getType1() {
        return type1;
    }

    public void setType1(TradeType type1) {
        this.type1 = type1;
    }

    public TradeType getType2() {
        return type2;
    }

    public void setType2(TradeType type2) {
        this.type2 = type2;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Integer getAmount1() {
        return amount1;
    }

    public void setAmount1(Integer amount1) {
        this.amount1 = amount1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Integer getAmount2() {
        return amount2;
    }

    public void setAmount2(Integer amount2) {
        this.amount2 = amount2;
    }
}
