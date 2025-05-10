package org.example.models.inventory;

import org.example.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Inventory {

    protected Integer capacity;

    protected ArrayList<Item> items = new ArrayList<>();

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    public void addToInventory(Item item, int n) {


        ///  CHECK KON BEBIN SAKHTE ITEMO

        if ( this.getItems().size()  + n <= this.capacity ) {

            this.items.add(item);

        }


    }

    public void CheatAddToInventory(Item item, int n) {

        if ( this.getItems().size()  + n <= this.capacity ) {

            this.items.add(item);

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

    public void removeFromInventory(Item item, int n) {

        int count = this.getItemCount(item);

        for ( int i = 0 ; i < Math.min(n,count) ; i++ ){

            this.items.remove(item);

        }

    }

    public int getUsedCapacity() {
        return items.size();
    }

    public int getRemainingCapacity() {
        return capacity - getUsedCapacity();
    }


    public boolean hasItem(Item item) {
        return this.items.contains(item);
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

    public void transferAllItemsTo(Inventory targetInventory) {

        for (Item item : this.items) {
            targetInventory.CheatAddToInventory(item, 1);
        }

        this.clear();

    }


}
