package com.InventoryProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Tests for the Inventory class.
 */
public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        // Create a fresh inventory every test
        inventory = new Inventory();
    }

    @Test
    @DisplayName("Test if an item can be added")
    void testAddItem() {
        inventory.addItem("Flashlight");
        assertTrue(inventory.hasItem("Flashlight"),
                "Flashlight should be in the inventory after adding it");
    }

    @Test
    @DisplayName("Test removing an item")
    void testRemoveItem() {
        // Add an item
        inventory.addItem("Key");

        // Attempt to remove the item
        boolean removed = inventory.removeItem("Key");
        assertTrue(removed, "removeItem should return true if item was present");
        assertFalse(inventory.hasItem("Key"), "After removal, Key should not be in inventory");
    }

    @Test
    @DisplayName("Test using an item and removes it if present)")
    void testUseItem() {
        inventory.addItem("Knife");
        boolean used = inventory.useItem("Knife");
        assertTrue(used, "useItem should return true if the item was in inventory");
        assertFalse(inventory.hasItem("Knife"), "Knife should be removed after being used");
    }

    @Test
    @DisplayName("Test using an item that doesn't exist")
    void testUseNonExistentItem() {
        boolean used = inventory.useItem("Potato");
        assertFalse(used, "useItem should return false if the item is not in inventory");
    }

}

