package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private InventoryManager manager = new InventoryManager();
    private static BufferedReader reader;

    public UI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMenuOption() throws IOException {
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
        int choice = choice(8);

        switch (choice) {
            case 1:
                addItem();
                break;
            case 2:
                displayItems();
                returnToMenu();
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
//                placeOrder();
                break;
            case 7:
                saveInventoryToFile();
                break;
            case 8:
                loadInventoryFromFile();
                break;
            default:
                reader.close();
        }
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
        int type = choice(4);

        if (type == 4 || type == -1) {
            returnToMenu();
        }

        InventoryItem item = createItem(type);
        addItemToInventory(item);

        System.out.println("Item successfully created!");

        returnToMenu();
    }

    private void displayItems() {
        manager.displayItems();

        sortMenu();
    }

    private void searchForItem() {
        System.out.println(
                """
                1. Search by name.
                2. Search by category.
                3. Return to menu.
                """
        );
        System.out.print("-> ");

        while (true) {
            int choice = choice(3);

            switch (choice) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchByCategory();
                    break;
                case -1:
                case 3:
                    returnToMenu();
            }
        }
    }

    private void removeItemsById() throws IOException {
        boolean hasFiles = manager.displayItems();

        if (!hasFiles) {
            returnToMenu();
        }

        while (true) {
            boolean isRemoved = false;

            System.out.print("ID (-1 to exit): ");
            int id = choice(Integer.MAX_VALUE);

            if (id == -1) {
                showMenuOption();
            }

            isRemoved = manager.removeItemById(id);

            if (isRemoved) {

                if (manager.getInventory().isEmpty()) {
                    returnToMenu();
                }
                removeItemsById();
            }
        }
    }

    private void categorizeItems() {
        manager.categorizeItems();

        System.out.print("(-1 to return) ->");

        try {
            String choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            returnToMenu();
        }
    }

    private void placeOrder() {

    }

    private void saveInventoryToFile() {
        System.out.println(
                """
                1. Add new items to an existing file
                2. Save edited file
                3. Save new file
                4. Exit
                """
        );

        System.out.print("-> ");

        int choice = choice(2);

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
                returnToMenu();
        }
    }

    private void loadInventoryFromFile() {
        List<File> files = manager.getFiles();

        int choice = 0;
        while (true) {
            try {
                System.out.println("Please choose a file to load from (-1 to exit))");
                System.out.print("-> ");
                choice = choice(files.size());

                if (choice == -1) {
                    returnToMenu();
                }

                System.out.println("Inventory will be replaced. Do you wish to proceed? (Y/N)");
                System.out.print("-> ");
                String proceed = reader.readLine();

                if (proceed.equalsIgnoreCase("y")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        var file = files.get(choice - 1);
        var path = file.getAbsolutePath();

        manager.setInventory(LoadFile.loadInventoryFromFile(path));

        System.out.println("Inventory successfully loaded!");

        returnToMenu();
    }

    private InventoryItem createItem(int type) {
        int id = createNewId();

        try {
            System.out.print("Name: ");
            String name = reader.readLine();

            System.out.print("Category: ");
            String category = reader.readLine();

            System.out.print("Price: ");
            double price = choice(10_000.0);

            System.out.print("Quantity: ");
            int quantity = choice(10_000);

            double weight = 0;

            if (type == 1) {
                System.out.print("Weight: ");
                weight = choice(10_000.0);
            }

            System.out.println();

            switch (type) {
                case 1:
                    return new FragileItem(id, name, category, price, quantity, weight);
                case 2:
                    return new ElectronicsItem(id, name, category, price, quantity);
                default:
                    return new GroceryItem(id, name, category, price, quantity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int createNewId() {
        int id;
        while (true) {
            System.out.print("Id: ");
            id = choice(Integer.MAX_VALUE);

            boolean idExists = manager.exists(id);

            if (!idExists) {
                return id;
            }
        }
    }

    private void addItemToInventory(InventoryItem item) {
        manager.add(item);
    }

    private void sortMenu() {
        System.out.println(
                """
                1. Sort by name
                2. Sort by category
                3. Sort by price
                4. Return to menu
                """
        );
        System.out.print("-> ");

        while (true) {
            int choice = choice(4);

            if (choice != -1 && choice != 4) {
                sort(choice);
            } else {
                returnToMenu();
            }
        }
    }

    private void sort(int sortBy) {
        List<InventoryItem> itemsToSort = new ArrayList<>(manager.getInventory());

        int choice = 1;
        while (true) {
            switch (sortBy) {
                case 1:
                    manager.sortByName(itemsToSort, choice);
                    break;
                case 2:
                    manager.sortByCategory(itemsToSort, choice);
                    break;
                default:
                    manager.sortByPrice(itemsToSort, choice);
            }

            System.out.println("1 - ascending, 2 - descending, -1 - exit");
            System.out.print("-> ");

            choice = choice(2);

            if (choice == -1) {
                sortMenu();
            }
        }
    }

    private void searchByName() {
        while (true) {
            try {
                System.out.print("(-1 to exit) -> ");
                String name = reader.readLine();

                if (name.equals("-1")) {
                    searchForItem();
                }
                manager.searchByName(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void searchByCategory() {

        while (true) {
            try {
                System.out.print("(-1 to exit) -> ");
                String category = reader.readLine();

                if (category.equals("-1")) {
                    searchForItem();
                }
                manager.searchByCategory(category);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addToAnExistingFile() {
        List<File> files = manager.getFiles();

        System.out.println("Please choose a file to save to");
        System.out.print("-> ");

        int choice = choice(files.size());

        SaveFile.saveInventoryToExistingFile(manager.getInventory(), files.get(choice - 1).getAbsolutePath());

        returnToMenu();
    }

    private void saveEditedFile() {
        List<File> files = manager.getFiles();

        System.out.println("Please choose a file to save to");
        System.out.print("-> ");

        int choice = choice(files.size());

        SaveFile.saveInventoryToNewFile(manager.getInventory(), files.get(choice - 1).getAbsolutePath());

        returnToMenu();
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

                if (!exists(path)) {
                    saveInventoryToFile();
                }

                SaveFile.saveInventoryToNewFile(manager.getInventory(), (path + ".csv"));

                System.out.println("Inventory successfully saved");
                showMenuOption();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean exists(String path) {
        List<File> files = manager.getFileNames();

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

    private void returnToMenu() {
        try {
            showMenuOption();
        } catch (IOException e) {
            e.printStackTrace();
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
                    System.out.print("-> ");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use numbers 1 - " + totalChoices);
                System.out.print("-> ");
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
