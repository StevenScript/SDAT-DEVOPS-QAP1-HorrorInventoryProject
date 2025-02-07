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
        // If user tries "door", return false
        if ("door".equalsIgnoreCase(itemName)) {
            return false;
        }
        inventory.addItem(itemName);
        return true;
    }

    /**
     * Check if inventory contains the item.
     */
    public boolean hasItem(String itemName) {
        return inventory.hasItem(itemName);
    }

    /**
     * Drops item if in inventory
     */
    public boolean dropItem(String itemName) {
        return inventory.removeItem(itemName);
    }

    private boolean doorRevealed = false;

    public boolean isDoorRevealed() {
        return doorRevealed;
    }

    public boolean useItem(String itemName) {
        // must have item in inventory
        if (!inventory.hasItem(itemName)) {
            return false;
        }

        if ("flashlight".equalsIgnoreCase(itemName)) {
            // reveal door
            doorRevealed = true;
            // remove it if we want one-time usage
            inventory.useItem(itemName);
            return true;
        }
        // Any other item usage does nothing special
        inventory.useItem(itemName);
        return true;
    }
}
