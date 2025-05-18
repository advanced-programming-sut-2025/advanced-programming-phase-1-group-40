package org.example.models.inventory;

import org.example.models.*;

import java.util.ArrayList;

public abstract class Inventory {

    protected Integer capacity;

    protected ArrayList<Item> items = new ArrayList<>();

    public Inventory(int capacity) {
        this.capacity = capacity;
    }


    public void showInventory() {

        System.out.println("\nInventory Items are:");
        for (Item item : items) {
            System.out.println(item.getItemName());
        }
        System.out.println();

    }

    public void addToInventory(Item item, int n) {


        ///  CHECK KON BEBIN SAKHTE ITEMO

        if ( this.getItems().size()  + n <= this.capacity ) {

            for ( int i = 0; i < n; i++ ) {
                this.items.add(item);
            }

        }


    }

    public void updateInventory(ArrayList<Item> items) {
        this.items = items;
    }

    public void CheatAddToInventory(Item item, int n) {

        if ( this.getItems().size()  + n <= this.capacity ) {

            for ( int i = 0; i < n; i++ ) {

                this.items.add(item);

            }

        }

    }

    public int getItemCount(Item item){

        int count = 0;
        for ( Item itemInInventory : this.items ){

            if ( itemInInventory.equals(item) ){

                count ++;

            }

        }

        return count;

    }

    public Result removeFromInventory(Item item, int n) {

        int count = this.getItemCount(item);

        for ( int i = 0 ; i < Math.min(n,count) ; i++ ){

            this.items.remove(item);

        }

        return null;
    }

    public int getUsedCapacity() {
        return items.size();
    }

    public int getRemainingCapacity() {
        return capacity - getUsedCapacity();
    }


    public int hasItem(Item item) {

        int count = 0;
        for ( Item itemInBackPack : this.items ){
            if ( itemInBackPack.equals(item) ){
                count ++;
            }
        }

        return count;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getTotalItemCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public String getInventoryContents(){

        String contents = "";
        for ( Item item : items ){

            if ( ! contents.contains(item.toString())  ){

                contents += item.toString();
                contents += "\n";

            }

        }

        return contents;

    }
    public Item removeFromInventory(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }


    public void transferAllItemsTo(Inventory targetInventory) {

        for (Item item : this.items) {
            targetInventory.CheatAddToInventory(item, 1);
        }

        this.clear();

    }


}
