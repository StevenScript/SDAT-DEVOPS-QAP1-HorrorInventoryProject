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
        assertTrue(success, "Should succeed in picking up a flare gun.");

        // Now confirm it's in the scenario's inventory
        assertTrue(scenario.hasItem("flashlight"), "Scenario inventory should contain 'flashlight'.");
    }
}