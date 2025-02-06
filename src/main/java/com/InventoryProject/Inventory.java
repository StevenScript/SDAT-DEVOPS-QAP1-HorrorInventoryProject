package com.InventoryProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class that manages a list of item names.
 * For now, it only works with adding items.
 */
public class Inventory {

    private List<String> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Methods to interact with inventory items
    public void addItem(String itemName) {
        items.add(itemName);
    }

    public boolean removeItem(String itemName) {
        return items.remove(itemName);
    }

    public boolean hasItem(String itemName) {
        return items.contains(itemName);
    }

    public boolean useItem(String itemName) {
        // TODO: Implement
        return false;
    }

    public List<String> getItems() {
        return items;
    }
}