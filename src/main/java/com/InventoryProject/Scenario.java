package com.InventoryProject;

public class Scenario {
    private Inventory inventory;

    public Scenario() {
        // Connects to inventory management
        this.inventory = new Inventory();
    }

    /**
     * Picks an item. For now, adds items with no conditions
     */
    public boolean pickItem(String itemName) {
        inventory.addItem(itemName);
        return true;
    }

    /**
     * Check if inventory contains the item.
     */
    public boolean hasItem(String itemName) {
        return inventory.hasItem(itemName);
    }
}
