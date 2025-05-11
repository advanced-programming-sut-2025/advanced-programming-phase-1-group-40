package org.example.models;

public class Gift {
    private int id;
    private final Item item;
    private final int amount;
    private final Player sender;
    private final Player receiver;
    private int rating;


    public Gift(int id, Item item, int amount, Player sender, Player receiver) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }
    public int getId() {
        return id;
    }
    public Item getItem() {
        return item;
    }
    public int getAmount() {
        return amount;
    }
    public Player getSender() {
        return sender;
    }
    public Player getReceiver() {
        return receiver;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int calculateFriendshipXP() {
        return (this.rating-3)*30 +15; //the formula written in the doc

    }
}
