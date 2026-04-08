/**
 * ============================================================
 * ABSTRACT CLASS - Room
 * ============================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This abstract class represents a generic hotel room.
 *
 * It models attributes that are intrinsic to a room type
 * and remain constant regardless of availability.
 *
 * Inventory-related concerns are intentionally excluded.
 *
 * @version 2.1
 */
import java.util.HashMap;
import java.util.Map;

// RoomInventory.java - Version 3.1
class RoomInventory {
    // Single source of truth using HashMap
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        // Initialize with default room types and availability
        inventory.put("Deluxe", 10);
        inventory.put("Suite", 5);
        inventory.put("Family", 3);
    }

    // Method to check availability - O(1) complexity
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability - Controlled update
    public boolean updateAvailability(String roomType, int count) {
        if (inventory.containsKey(roomType)) {
            int current = inventory.get(roomType);
            if (current + count >= 0) {
                inventory.put(roomType, current + count);
                return true;
            }
        }
        return false; // Cannot have negative rooms
    }

    public void displayInventory() {
        System.out.println("Current Inventory: " + inventory);
    }
}

public class Bookmystay {
    public static void main(String[] args) {
        RoomInventory manager = new RoomInventory();
        System.out.println("Initial State:");
        manager.displayInventory();

        // Simulate booking: Reduce 2 Deluxe rooms
        System.out.println("\nBooking 2 Deluxe rooms...");
        manager.updateAvailability("Deluxe", -2);
        manager.displayInventory();

        // Simulate adding new inventory: 1 Suite
        System.out.println("\nAdding 1 Suite room...");
        manager.updateAvailability("Suite", 1);
        manager.displayInventory();
    }
}