package com.InventoryProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Horror Inventory CLI!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter command (or 'quit'): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if ("quit".equals(input)) {
                System.out.println("Goodbye!");
                break;
            }

            // For now, do nothing else
            System.out.println("You entered: " + input);
        }

        scanner.close();
    }
}