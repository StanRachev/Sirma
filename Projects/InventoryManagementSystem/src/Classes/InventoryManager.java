package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InventoryManager {

    private List<InventoryItem> inventory;
    private static BufferedReader reader;

    public InventoryManager() {
        inventory = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void searchByName() {
        while (true) {
            try {
                System.out.print("(-1 to exit) -> ");
                String name = reader.readLine();

                if (name.equals("-1")) {
                    return;
                }

                Pattern pattern = Pattern.compile(name);
                Matcher matcher;

                boolean hasItem = false;
                for (var i : inventory) {
                    matcher = pattern.matcher(i.getName().toLowerCase());
                    if (matcher.find()) {
                        System.out.println(i.getItemDetails());
                        hasItem = true;
                    }
                }
                System.out.println();

                if (!hasItem) {
                    System.out.println("No result");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void searchByCategory() {
        while (true) {
            try {
                System.out.print("(-1 to exit) -> ");
                String category = reader.readLine();

                if (category.equals("-1")) {
                    return;
                }

                Pattern pattern = Pattern.compile(category);
                Matcher matcher;

                boolean hasItem = false;
                for (var i : inventory) {
                    matcher = pattern.matcher(i.getCategory().toLowerCase());
                    if (matcher.find()) {
                        System.out.println(i.getItemDetails());
                        hasItem = true;
                    }
                }
                System.out.println();

                if (!hasItem) {
                    System.out.println("No result");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void categorizeItems() {
        Map<String, List<InventoryItem>> categories = new TreeMap<>();

        for (var item : inventory) {
            categories.putIfAbsent(item.getCategory(), new ArrayList<InventoryItem>());
            categories.get(item.getCategory()).add(item);
        }

        for (var category : categories.entrySet()) {
            System.out.println(category.getKey());

            for (var item : category.getValue()) {
                System.out.println(item.getItemDetails());
            }
            System.out.println();
        }
    }

    public void sortByPrice(List<InventoryItem> itemsToSort, int choice) {
        if (choice == 1) {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getPrice));
        } else if (choice == 2) {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getPrice).reversed());
        } else {
            return;
        }

        System.out.println();
        for (var item : itemsToSort) {
            System.out.println(item.getItemDetails());
        }
        System.out.println();
    }

    public void sortByCategory(List<InventoryItem> itemsToSort, int choice) {
        if (choice == 1) {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getCategory));
        } else if (choice == 2) {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getCategory).reversed());
        } else {
            return;
        }

        System.out.println();
        for (var item : itemsToSort) {
            System.out.println(item.getItemDetails());
        }
        System.out.println();
    }

    public void sortByName(List<InventoryItem> itemsToSort, int choice) {
        if (choice == 1) {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getName));
        } else if (choice == 2) {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getName).reversed());
        } else {
            return;
        }

        System.out.println();
        for (var item : itemsToSort) {
            System.out.println(item.getItemDetails());
        }
        System.out.println();
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void addItem(InventoryItem item) {
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

    public InventoryItem getItemById(int id) {
        InventoryItem item = null;
        while (true) {
            for (var i : inventory) {
                if (id == i.getItemId()) {
                    item = i;
                    break;
                }
            }
            return item;
        }
    }

    public int getAvailableQuantity(Cart cart, InventoryItem item) {
        var itemsInCart = cart.getCart();

        for (var i : itemsInCart.entrySet()) {
            var itemInCart = i.getValue();
            if (itemInCart.getItemId() == item.getItemId()) {
                return item.getQuantity() - itemInCart.getQuantity();
            }
        }
        return 0;
    }
}
