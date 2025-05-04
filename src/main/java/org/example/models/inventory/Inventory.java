package org.example.models.inventory;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Inventory {
    protected int capacity;
    protected boolean isCapacityUnlimited;
    // Add a map to store items and their quantities
    protected Map<Item, Integer> items = new HashMap<>();

    public Inventory(int capacity, boolean isCapacityUnlimited) {
        this.capacity = capacity;
        this.isCapacityUnlimited = isCapacityUnlimited;
    }

    public void addToInventory(Item item, int n) {
        // Check if adding this item would exceed capacity
        if (!isCapacityUnlimited && getUsedCapacity() + n > capacity) {
            // Handle capacity exceeded - could throw exception or return false
            return;
        }
        
        // Add item to inventory
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + n);
        } else {
            items.put(item, n);
        }
    }

    public void CheatAddToInventory(Item item, int n) {
        // Cheat mode ignores capacity constraints
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + n);
        } else {
            items.put(item, n);
        }
    }

    public void removeFromInventory(Item item, int n) {
        // Check if item exists and in sufficient quantity
        if (!items.containsKey(item) || items.get(item) < n) {
            // Handle insufficient items - could throw exception or return false
            return;
        }
        
        // Remove the specified quantity
        int newQuantity = items.get(item) - n;
        if (newQuantity <= 0) {
            items.remove(item);
        } else {
            items.put(item, newQuantity);
        }
    }
    
    // Get the number of unique items (as per the requirement that each type takes one slot)
    public int getUsedCapacity() {
        return items.size();
    }
    
    // Get remaining capacity
    public int getRemainingCapacity() {
        return capacity - getUsedCapacity();
    }
    
    // Get a formatted string representation of the inventory contents
    public String getInventoryContents() {
        if (items.isEmpty()) {
            return "";
        }
        
        StringBuilder contents = new StringBuilder();
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            contents.append(entry.getKey().toString())
                   .append(": ")
                   .append(entry.getValue())
                   .append("\n");
        }
        return contents.toString();
    }
    
    // Check if an item exists in the inventory
    public boolean hasItem(Item item) {
        return items.containsKey(item);
    }
    
    // Get the quantity of a specific item
    public int getItemQuantity(Item item) {
        return items.getOrDefault(item, 0);
    }

    // Add this method to allow access to the items map
    public Map<Item, Integer> getItems() {
        return new HashMap<>(items); // Return a copy to prevent direct modification
    }

    // Add a method to check if inventory is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Add a method to get total number of items (not just unique items)
    public int getTotalItemCount() {
        int total = 0;
        for (int quantity : items.values()) {
            total += quantity;
        }
        return total;
    }

    // Add a method to clear the inventory
    public void clear() {
        items.clear();
    }

    // Add a method to transfer items to another inventory
    public void transferAllItemsTo(Inventory targetInventory) {
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            targetInventory.CheatAddToInventory(entry.getKey(), entry.getValue());
        }
        this.clear();
    }
}
