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
        // The hasItem method should return true once we implement it
        assertTrue(inventory.hasItem("Flashlight"),
                "Flashlight should be in the inventory after adding it");
    }
}
