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

    @Test
    void testCannotPickUpDoor() {
        Scenario scenario = new Scenario();
        boolean pickDoor = scenario.pickItem("door");
        assertFalse(pickDoor, "Should not be able to pick up the door.");

        // Also ensure it's not in the inventory
        assertFalse(scenario.hasItem("door"), "Door should never be in inventory.");
    }

    @Test
    void testUseFlashlightRevealsDoor() {
        Scenario scenario = new Scenario();
        // Must pick up flashlight first
        scenario.pickItem("flashlight");

        // Then use it
        boolean used = scenario.useItem("flashlight");
        assertTrue(used, "Using flashlight should succeed if we have it");

        // Store doorRevealed in Scenario and check it
        assertTrue(scenario.isDoorRevealed(), "After using flashlight, door should be revealed");

        // Check that it's removed
        assertFalse(scenario.hasItem("flashlight"), "Flashlight removed after use");
    }

    @Test
    void testUseKeyFailsIfDoorNotRevealed() {
        Scenario scenario = new Scenario();
        // pick up key
        scenario.pickItem("key");

        boolean usedKey = scenario.useItem("key");
        // should fail, door is not revealed
        assertFalse(usedKey, "Key usage fails if door isn't revealed");
        assertFalse(scenario.isDoorUnlocked(), "Door should not be unlocked");
    }

    @Test
    void testUseKeySucceedsOnceDoorRevealed() {
        Scenario scenario = new Scenario();
        scenario.pickItem("flashlight");
        scenario.useItem("flashlight"); // reveals door

        scenario.pickItem("key");
        boolean usedKey = scenario.useItem("key");
        assertTrue(usedKey, "Key usage should succeed once door is revealed");
        assertTrue(scenario.isDoorUnlocked(), "Door should be unlocked after using key");
    }

    @Test
    void testScenarioEndsOnceDoorUnlocked() {
        Scenario scenario = new Scenario();

        // Door is not revealed, so scenario is not finished.
        assertFalse(scenario.isFinished(), "Scenario shouldn't be finished at the start.");

        // Reveal the door
        scenario.pickItem("flashlight");
        scenario.useItem("flashlight"); // now doorRevealed = true
        assertFalse(scenario.isFinished(),
                "Even after revealing the door, scenario isn't finished until we unlock it.");

        // Unlock the door
        scenario.pickItem("key");
        boolean usedKey = scenario.useItem("key");
        assertTrue(usedKey, "Key usage should succeed if door is revealed.");

        // Now should be finished/escaped
        assertTrue(scenario.isFinished(),
                "Once the door is unlocked, scenario should be finished.");
    }

}