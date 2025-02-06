package com.InventoryProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class that manages a list of item names.
 * For now, it is set up as an empty structure that just compiles.
 */
public class Inventory {

    private List<String> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // We'll implement the methods soon:
    public void addItem(String itemName) {
        // TODO: Implement
    }

    public boolean removeItem(String itemName) {
        // TODO: Implement
        return false;
    }

    public boolean hasItem(String itemName) {
        // TODO: Implement
        return false;
    }

    public boolean useItem(String itemName) {
        // TODO: Implement
        return false;
    }

    public List<String> getItems() {
        return items;
    }
}