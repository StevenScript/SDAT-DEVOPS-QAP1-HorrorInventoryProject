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

    /**
     * Code for the door, which a player needs to open.
     * To open, first use flashlight then key.
     */
    private boolean doorRevealed = false;
    private boolean doorUnlocked = false;

    public boolean isDoorUnlocked() {
        return doorUnlocked;
    }

    public boolean isDoorRevealed() {
        return doorRevealed;
    }

    /**
     * Reveal door using flashlight,
     * Open using key
     */
    public boolean useItem(String itemName) {
        if (!inventory.hasItem(itemName)) return false;

        if ("flashlight".equalsIgnoreCase(itemName)) {
            doorRevealed = true;
            inventory.useItem(itemName);
            return true;
        }
        else if ("key".equalsIgnoreCase(itemName)) {
            // only works if doorRevealed
            if (!doorRevealed) {
                return false;
            }
            doorUnlocked = true;
            inventory.useItem(itemName);
            return true;
        }
        // other items
        inventory.useItem(itemName);
        return true;
    }
}
