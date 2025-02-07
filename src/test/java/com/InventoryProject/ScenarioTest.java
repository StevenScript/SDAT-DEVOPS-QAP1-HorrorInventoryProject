package com.InventoryProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests for the main app's scenario,
 * to ensure it workings with the inventory system
 * as well as being setup to interact with the items.
 */

public class ScenarioTest {

    @Test
    void testPickUpFlashlight() {
        // Setup Scenario
        Scenario scenario = new Scenario();

        // Attempt to pick up the flashlight
        boolean success = scenario.pickItem("flashlight");
        assertTrue(success, "Should succeed in picking up a flashlight.");

        // Now confirm it's in the scenario's inventory
        assertTrue(scenario.hasItem("flashlight"), "Scenario inventory should contain 'flashlight'.");
    }

    @Test
    void testDropFlashlight() {
        Scenario scenario = new Scenario();
        scenario.pickItem("flashlight");

        // dropping it should return true
        boolean dropped = scenario.dropItem("flashlight");
        assertTrue(dropped, "Dropping flashlight should succeed if we have it.");

        // Now scenario should not have the flashlight
        assertFalse(scenario.hasItem("flashlight"), "After dropping, inventory shouldn't have it.");
    }

}