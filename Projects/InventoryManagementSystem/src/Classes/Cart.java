package Classes;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    Map<Integer, InventoryItem> cart;
    double total;

    public Cart() {
        cart = new LinkedHashMap<>();
    }

    public Map<Integer, InventoryItem> getCart() {
        return cart;
    }

    public void add(InventoryItem item, int quantity) {
        InventoryItem newItem;
        if (item instanceof FragileItem) {
            newItem = new FragileItem((FragileItem) item, quantity);
        } else if (item instanceof ElectronicsItem) {
            newItem = new ElectronicsItem((ElectronicsItem) item, quantity);
        } else {
            newItem = new GroceryItem((GroceryItem) item, quantity);
        }

        if (cart.get(item.getItemId()) == null) {
            cart.put(item.getItemId(), newItem);
        } else {
            var tempItem = cart.get(item.getItemId());
            tempItem.setQuantity(tempItem.getQuantity() + quantity);
        }
    }

    public boolean remove(int itemId) {
        boolean isRemoved = false;
        for (var item : cart.entrySet()) {
            var itemToDelete = item.getValue();
            if (itemToDelete.getItemId() == itemId) {
                cart.remove(itemToDelete.getItemId());
                isRemoved = true;
            }
        }

        return isRemoved;
    }

    public void displayItems() {
        for (var item : cart.entrySet()) {
            System.out.println(item.getValue().getItemDetails());
        }
        System.out.println();
    }

    public double totalCost() {
        double total = 0;
        for (var i : cart.entrySet()) {
            var item = i.getValue();
            int quantity = item.getQuantity();
            double price = item.getPrice();

            total += price * quantity;
        }
        return total;
    }
}
