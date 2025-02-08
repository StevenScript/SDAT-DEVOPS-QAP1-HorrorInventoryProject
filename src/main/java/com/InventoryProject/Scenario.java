package com.InventoryProject;




/**
 * Scenario class controlling the puzzle logic:
 * - The oor is hidden until the flashlight is used.
 * - The door cannot be picked up.
 * - Key only unlocks the door if the door is revealed.
 * - Once the door is unlocked, the scenario ends (player "escapes").
 */
public class Scenario {

    // Inventory class to store items
    private Inventory inventory;

    // Tracks if the door is currently revealed
    private boolean doorRevealed;

    // Tracks if the door has been unlocked
    private boolean doorUnlocked;

    // Tracks if the entire scenario is completed
    private boolean finished;


    /**
     * Starts scenario with all tasks for user uncompleted
     */
    public Scenario() {
        this.inventory = new Inventory();
        this.doorRevealed = false;
        this.doorUnlocked = false;
        this.finished = false;
    }

    /**
     * Picks an item.
     * Prevent picking up doors
     */
    public boolean pickItem(String itemName) {
        // If user tries "door", return false
        if ("door".equalsIgnoreCase(itemName)) {
            return false;
        }
        // Otherwise, add to inventory
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
     * Reveal door using flashlight,
     * Open using key
     */
    public boolean useItem(String itemName) {
        // Must actually have the item in our inventory
        if (!inventory.hasItem(itemName)) {
            return false;
        }

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
            finished = true;
            return true;
        }
        // other items
        inventory.useItem(itemName);
        return true;
    }


    /**
     * Code for a hidden door, which a player needs to open.
     * To open, first use flashlight then key.
     */
    // Checks if the door is unlocked.
    public boolean isDoorUnlocked() {
        return doorUnlocked;
    }

    // Checks if the door has been revealed by the flashlight.
    public boolean isDoorRevealed() {
        return doorRevealed;
    }

    // Checks whether this scenario is completed
    public boolean isFinished() {
        return finished;
    }
}
