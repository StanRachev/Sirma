package Classes;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private List<InventoryItem> inventory = new ArrayList<>();

    public InventoryManager() {
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void add(InventoryItem item) {
        inventory.add(item);
    }

    public boolean removeItemById(int itemId) {
        boolean isRemoved = inventory.removeIf(item -> item.getItemId() == itemId);
        if (isRemoved) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
        return isRemoved;
    }

    public boolean displayItems() {
        if (inventory.isEmpty()) {
            System.out.println("List is empty");
            System.out.println();
            return false;
        }

        for (var item : inventory) {
            System.out.println(item.getItemDetails());
        }
        System.out.println();
        return true;
    }




}
