package com.InventoryProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scenario scenario = new Scenario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! You see a flare gun, flashlight, and key on a table.");
        System.out.println("Commands: pick <item>, drop <item>, use <item>, quit");


        while (true) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if ("quit".equals(input)) {
                System.out.println("Goodbye!");
                break;
            }

            String[] parts = input.split("\\s+", 2);
            if (parts.length < 2) {
                System.out.println("Invalid command. Try 'pick flare gun'.");
                continue;
            }
            String action = parts[0];
            String item   = parts[1];

            switch (action) {
                case "pick":
                    boolean picked = scenario.pickItem(item);
                    if (picked) {
                        System.out.println("You picked up the " + item + ".");
                    } else {
                        System.out.println("You cannot pick up the " + item + ".");
                    }
                    break;

                case "drop":
                    boolean dropped = scenario.dropItem(item);
                    if (dropped) {
                        System.out.println("You dropped the " + item + ".");
                    } else {
                        System.out.println("You don't have a " + item + " to drop!");
                    }
                    break;

                default:
                    System.out.println("Unknown command. Try 'pick <item>' or 'drop <item>'.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Your final inventory: " + scenario.getInventory().getItems());
    }