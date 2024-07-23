package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private InventoryManager inventoryManager;
    private FileManager fileManager;
    private static BufferedReader reader;
    private Cart cart;

    public UI() {
        inventoryManager = new InventoryManager();
        fileManager = new FileManager();
        reader = new BufferedReader(new InputStreamReader(System.in));
        cart = new Cart();
    }

    public void showMenu() {
        while (true) {
            try {
                displayMainMenu();
                int choice = getChoice(9);

                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        if (displayItems()) {
                            sortMenu();
                        }
                        break;
                    case 3:
                        searchForItem();
                        break;
                    case 4:
                        removeItemsById();
                        break;
                    case 5:
                        categorizeItems();
                        break;
                    case 6:
                        placeOrder();
                        break;
                    case 7:
                        saveInventoryToFile();
                        break;
                    case 8:
                        loadInventoryFromFile();
                        break;
                    default:
                        reader.close();
                        return;
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("""
                1. Add item
                2. Display items
                3. Search for an item
                4. Remove items by ID
                5. Categorize items
                6. Place order
                7. Save items to file
                8. Load items from file
                9. Exit
                """);
        System.out.print("-> ");
    }

    private void addItem() {
        System.out.println("""
                Type of an item:
                1. Fragile
                2. Electronics
                3. Grocery
                4. Return
                """);
        System.out.print("-> ");
        int type = getChoice(4);

        if (type == 4 || type == -1) {
            return;
        }

        InventoryItem item = createItem(type);
        inventoryManager.addItem(item);
        System.out.println("Item successfully created!");
    }

    private InventoryItem createItem(int type) {
        int id = createNewId();

        try {
            System.out.print("Name: ");
            String name = reader.readLine();

            System.out.print("Category: ");
            String category = reader.readLine();

            System.out.print("Price: ");
            double price = getChoice(10_000.0);

            System.out.print("Quantity: ");
            int quantity = getChoice(10_000);

            double weight = 0;
            if (type == 1) {
                System.out.print("Weight: ");
                weight = getChoice(10_000.0);
            }

            System.out.println();

            return switch (type) {
                case 1 -> new FragileItem(id, name, category, price, quantity, weight);
                case 2 -> new ElectronicsItem(id, name, category, price, quantity);
                default -> new GroceryItem(id, name, category, price, quantity);
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int createNewId() {
        int id;
        while (true) {
            System.out.print("Id: ");
            id = getChoice(Integer.MAX_VALUE);

            boolean idExists = itemExists(id);

            if (!idExists) {
                return id;
            }
        }
    }

    public boolean itemExists(int id) {
        for (var item : inventoryManager.getInventory()) {
            if (id == item.getItemId()) {
                System.out.println("There is an item with this ID");
                return true;
            }
        }
        return false;
    }

    private boolean displayItems() {
        return inventoryManager.displayItems();
    }

    private void searchForItem() {
        while (true) {
            System.out.println(
                    """
                    1. Search by name.
                    2. Search by category.
                    3. Return to menu.
                    """);
            System.out.print("-> ");

            int choice = getChoice(3);
            switch (choice) {
                case 1:
                    inventoryManager.searchByName();
                    break;
                case 2:
                    inventoryManager.searchByCategory();
                    break;
                case -1:
                case 3:
                    return;
            }
        }
    }

    private void removeItemsById() {
        if (!inventoryManager.displayItems()) {
            return;
        }

        while (true) {
            System.out.print("ID (-1 to exit): ");
            int id = getChoice(Integer.MAX_VALUE);

            if (id == -1) {
                return;
            }
            inventoryManager.removeItemById(id);

            if (inventoryManager.getInventory().isEmpty()) {
                return;
            }
        }
    }

    private void categorizeItems() {
        inventoryManager.categorizeItems();
        waitForInput();
    }

    private void waitForInput() {
        System.out.print("(-1 to return) -> ");

        try {
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void placeOrder() {
        while (true) {
            System.out.println("""
                    1. View available items
                    2. Add item to cart
                    3. Remove an item from cart
                    4. Show cart
                    5. Check-out
                    6. Return
                    """);
            System.out.print("-> ");

            int choice = getChoice(6);
            switch (choice) {
                case 1:
                    inventoryManager.displayItems();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    cart.displayItems();
                    break;
                case 5:
                    checkOut();
                    break;
                default:
                    return;
            }
        }
    }

    private void addToCart() {
        System.out.println("Please enter ID of the product (-1 to exit):");

        while (true) {
            System.out.print("-> ");
            int id = getChoice(Integer.MAX_VALUE);

            if (id == -1) {
                return;
            }
            InventoryItem item = inventoryManager.getItemById(id);

            if (item == null) {
                System.out.println("No match found. Try again.");
            } else {
                System.out.println();
                System.out.print("Quantity: ");

                int quantityLeft = inventoryManager.getAvailableQuantity(cart ,item);
                if (quantityLeft <= 0) {
                    System.out.println("Not enough amount. Please choose another product.");
                    continue;
                }
                int quantity = getChoice(quantityLeft);
                cart.add(item, quantity);

                System.out.println("Added successfully!");
                return;
            }
        }
    }

    private void removeFromCart() {
        cart.displayItems();
        System.out.println("Enter item id (-1 to exit):");

        int id = getChoice(Integer.MAX_VALUE);

        if (id != -1 && cart.remove(id)) {
            System.out.println("Item successfully removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private void checkOut() {
        System.out.println("Total cost: " + totalCost());
    }

    private double totalCost() {
        return cart.totalCost();
    }

    private void saveInventoryToFile() {
        while (true) {
            System.out.println("""
                    1. Add new items to an existing file
                    2. Save edited file
                    3. Save new file
                    4. Exit
                    """);
            System.out.print("-> ");

            int choice = getChoice(4);

            switch (choice) {
                case 1:
                    addToAnExistingFile();
                    break;
                case 2:
                    saveEditedFile();
                    break;
                case 3:
                    saveNewFile();
                    break;
                default:
                    return;
            }
        }
    }

    private void loadInventoryFromFile() {
        List<File> files = fileManager.getFiles();

        if (files.isEmpty()) {
            System.out.println("No files available to load.");
            return;
        }

        while (true) {
            System.out.println("Please choose a file to load from (-1 to exit))");
            System.out.print("-> ");
            int choice = getChoice(files.size());

            if (choice == -1) {
                return;
            }

            System.out.println("Inventory will be replaced. Do you wish to proceed? (Y/N)");
            System.out.print("-> ");

            try {
                String proceed = reader.readLine();

                if (proceed.equalsIgnoreCase("y")) {
                    var file = files.get(choice - 1);
                    inventoryManager.setInventory(LoadFile.loadInventoryFromFile(file.getAbsolutePath()));
                    System.out.println("Inventory successfully loaded!");
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sortMenu() {
        while (true) {
            System.out.println("""
                    1. Sort by name
                    2. Sort by category
                    3. Sort by price
                    4. Return to menu
                    """);
            System.out.print("-> ");

            int choice = getChoice(4);

            if (choice != -1 && choice != 4) {
                sort(choice);
            } else {
                return;
            }
        }
    }

    private void sort(int sortBy) {
        List<InventoryItem> itemsToSort = new ArrayList<>(inventoryManager.getInventory());

        int choice = 1;
        while (true) {
            switch (sortBy) {
                case 1:
                    inventoryManager.sortByName(itemsToSort, choice);
                    break;
                case 2:
                    inventoryManager.sortByCategory(itemsToSort, choice);
                    break;
                default:
                    inventoryManager.sortByPrice(itemsToSort, choice);
            }

            System.out.println("1 - ascending, 2 - descending, -1 - exit");
            System.out.print("-> ");

            choice = getChoice(2);

            if (choice == -1) {
                return;
            }
        }
    }

    private void addToAnExistingFile() {
        List<File> files = fileManager.getFiles();

        System.out.println("Please choose a file to save to");
        System.out.print("-> ");

        int choice = getChoice(files.size());

        SaveFile.saveInventoryToExistingFile(inventoryManager.getInventory(), files.get(choice - 1).getAbsolutePath());
    }

    private void saveEditedFile() {
        List<File> files = fileManager.getFiles();

        System.out.println("Please choose a file to save to");
        System.out.print("-> ");

        int choice = getChoice(files.size());

        SaveFile.saveInventoryToNewFile(inventoryManager.getInventory(), files.get(choice - 1).getAbsolutePath());
    }

    private void saveNewFile() {
        System.out.println("Please enter the name of the file (-1 to return):");
        System.out.print("-> ");

        while (true) {
            try {
                String path = reader.readLine();

                if (path.equals("-1")) {
                    saveInventoryToFile();
                }

                if (path.isEmpty()) {
                    System.out.println("Please enter name");
                    System.out.print("-> ");
                    continue;
                }

                if (!fileExists(path)) {
                    saveInventoryToFile();
                }

                SaveFile.saveInventoryToNewFile(inventoryManager.getInventory(), (path + ".csv"));

                System.out.println("Inventory successfully saved");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean fileExists(String path) {
        List<File> files = fileManager.getFileNames();

        try {
            for (var f : files) {
                if (f.getName().equals(path + ".csv")) {
                    System.out.printf("File %s already exists. Do you want to replace it? (Y/N)", f.getName());
                    System.out.println();
                    System.out.print("-> ");
                    String choice = reader.readLine();
                    if (choice.equalsIgnoreCase("y")) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static int getChoice(int maxChoice) {
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(reader.readLine());
                if (choice >= 1 && choice <= maxChoice) {
                    break;
                } else if (choice == -1) {
                    return -1;
                }else {
                    System.out.println("Choose 1 - " + maxChoice);
                    System.out.print("-> ");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use numbers 1 - " + maxChoice);
                System.out.print("-> ");
            }
        }
        return choice;
    }

    public static double getChoice(double weight) {
        double choice = 0;
        while (true) {
            try {
                choice = Double.parseDouble(reader.readLine());
                if (choice >= 0 && choice <= weight) {
                    break;
                } else {
                    System.out.println("Choose 0 - " + weight);
                    System.out.print("-> ");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use number 0 - " + weight);
                System.out.print("-> ");
            }
        }
        return choice;
    }
}
