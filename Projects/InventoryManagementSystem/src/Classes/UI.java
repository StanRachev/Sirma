package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private List<InventoryItem> items;
    BufferedReader reader;

    public UI() {
        items = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenuOption() throws IOException {
        System.out.println("""
                1. Add item
                2. Remove items by ID
                3. Display items
                4. Categorize items
                5. Exit
                """);
        /*
                5. Place order
                6. Add Inventory to File
                7. Load Inventory from File
        */
        System.out.print("Enter your choice: ");
        int choice = choice(5);

        switch (choice) {
            case 1:
                addItem();
                break;
            case 2:
                removeItemsById();
                break;
            case 3:
                displayItems();
                break;
            case 4:
                categorizeItems();
                break;
            case 5:
                placeOrder();
                break;
            case 6:
                break;
            default:
                reader.close();
        }
    }

    private void addItem() throws IOException {
        System.out.println("""
                Type of an item:
                1. Fragile
                2. Electronics
                3. Grocery
                """);
        System.out.print("-> ");

        int choice = choice(3);

        System.out.println("Category: ");
        String category = reader.readLine();
        System.out.println("Quantity: ");
        int quantity = choice(10_000);
        System.out.println("Price: ");
        int price = choice(10_000);

        switch (choice) {
            case 1: {
                System.out.println("Material: ");
                String material = reader.readLine();
                System.out.println("Weight: ");
                double weight = choice(10_000.0);
                items.add(new FragileItem(weight, material, category, price, quantity));
            } break;
            case 2: {
                System.out.println("Brand: ");
                String brand = reader.readLine();
                System.out.println("Warranty: ");
                int warranty = choice(60);
                items.add(new ElectronicsItem(brand, warranty, category, price, quantity));
            } break;
            default:
                System.out.println("Name: ");
                String name = reader.readLine();
                System.out.println("Type: ");
                String type = reader.readLine();
                items.add(new GroceryItem(name, type, category, price, quantity));
        }

        showMenuOption();
    }

    private void removeItemsById() throws IOException {
        System.out.print("Remove by ID (-1 to exit): ");

        int id = choice(Integer.MAX_VALUE);

        if (id == -1) {
            showMenuOption();
        }

        InventoryItem itemToRemove = null;
        for (var item : items) {
            if (item.getItemId() == id) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove);
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
        showMenuOption();
    }

    private void displayItems() throws IOException {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty");
            showMenuOption();
        } else {
            for (var item : items) {
                System.out.println(item.getItemsDescription());
                System.out.println();
            }
        }
        showMenuOption();
    }

    private void categorizeItems() throws IOException {

        while (true) {
            if (items.isEmpty()) {
                System.out.println("Inventory is empty");
                break;
            } else {
                System.out.print("Choose an item by ID (-1 to exit): ");
            }

            int choice = 0;
            try {
                choice = Integer.parseInt(reader.readLine());

                InventoryItem itemToCategorize = null;
                for (var item : items) {
                    if (item.getItemId() == choice) {
                        itemToCategorize = item;
                    }
                }
                if (itemToCategorize != null) {
                    System.out.print("Enter category: ");
                    String category = reader.readLine();
                    itemToCategorize.setItemCategory(category);
                } else {
                    System.out.println("Item not found. Try again:");
                }
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use numbers");
            }
        }
        showMenuOption();
    }

    private void placeOrder() throws IOException {
        try {
            System.out.print("Product ID: ");
            int id = Integer.parseInt(reader.readLine());

            System.out.print("Quantity: ");

            int quantity = choice(50);

            InventoryItem itemToOrder = null;

            for (var item : items) {
                if (item.getItemId() == id) {
                    itemToOrder = item;
                    break;
                } else {
                    System.out.println("Item not found");
                    showMenuOption();
                }
            }

            if (itemToOrder != null) {
                if (itemToOrder.getQuantity() >= quantity) {
                    itemToOrder.setQuantity(itemToOrder.getQuantity() - quantity);
                    System.out.println("Order is successful");
                } else {
                    System.out.println("Insufficient quantity.");
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Use numbers");
        }
    }

    private int choice(int totalChoices) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(reader.readLine());
                if (choice >= 1 && choice <= totalChoices) {
                    break;
                } else if (choice == -1) {
                    return -1;
                }else {
                    System.out.println("Choose 1 - " + totalChoices);
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use numbers 1 - " + totalChoices);
            }
        }
        return choice;
    }

    private double choice(double weight) {
        double choice = 0;
        while (true) {
            try {
                choice = Double.parseDouble(reader.readLine());
                if (choice >= 0 && choice <= weight) {
                    break;
                } else {
                    System.out.println("Choose 0 - " + weight);
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use number 0 - " + weight);
            }
        }
        return choice;
    }
}
