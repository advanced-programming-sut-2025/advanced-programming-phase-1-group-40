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

    protected Map<Item, Integer> items = new HashMap<>();

    public Inventory(int capacity, boolean isCapacityUnlimited) {
        this.capacity = capacity;
        this.isCapacityUnlimited = isCapacityUnlimited;
    }

    public void addToInventory(Item item, int n) {
        if (!isCapacityUnlimited && getUsedCapacity() + n > capacity) {
            // Handle capacity exceeded - could throw exception or return false
            return;
        }

        if (items.containsKey(item)) {
            items.put(item, items.get(item) + n);
        } else {
            items.put(item, n);
        }
    }

    public void CheatAddToInventory(Item item, int n) {
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

        int newQuantity = items.get(item) - n;
        if (newQuantity <= 0) {
            items.remove(item);
        } else {
            items.put(item, newQuantity);
        }
    }

    public int getUsedCapacity() {
        return items.size();
    }

    public int getRemainingCapacity() {
        return capacity - getUsedCapacity();
    }

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

    public boolean hasItem(Item item) {
        return items.containsKey(item);
    }

    public int getItemQuantity(Item item) {
        return items.getOrDefault(item, 0);
    }

    public Map<Item, Integer> getItems() {
        return new HashMap<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getTotalItemCount() {
        int total = 0;
        for (int quantity : items.values()) {
            total += quantity;
        }
        return total;
    }

    public void clear() {
        items.clear();
    }

    public void transferAllItemsTo(Inventory targetInventory) {
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            targetInventory.CheatAddToInventory(entry.getKey(), entry.getValue());
        }
        this.clear();
    }
}
