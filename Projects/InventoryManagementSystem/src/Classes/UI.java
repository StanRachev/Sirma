package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
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
                3. Remove items by ID
                4. Categorize items
                5. Place order
                6. Save items to file
                7. Load items from file
                8. Exit
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
                removeItemsById();
                break;
            case 4:
                categorizeItems();
                break;
            case 5:
//                placeOrder();
                break;
            case 6:
                saveInventoryToFile();
                break;
            case 7:
                loadInventoryFromFile();
                break;
            default:
                reader.close();
        }
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

    private String getLastModified(File file) {

        if (file.exists()) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            return formatter.format(file.lastModified());
        } else {
            System.out.println("File not found.");
        }
        return null;
    }

    private List<File> listFiles() {
        File file = new File("C:\\Users\\vival\\OneDrive\\Desktop\\Stan\\Java\\Sirma\\Homeworks_For_GitHub\\Sirma\\Projects\\InventoryManagementSystem\\");
        File[] files = file.listFiles();

        System.out.printf("   %-35s %10s", "Name", "Date Modified");
        System.out.println();

        int cntr = 0;
        List<File> fileList = new ArrayList<>();
        for (var f : files) {
            if (f.toString().endsWith(".csv")) {
                System.out.printf("%d. %-35s %10s", ++cntr, f.getName(), getLastModified(f));
                System.out.println();
                fileList.add(f);
            }
        }
        System.out.println();

        return fileList;
    }

    private static List<File> getFileNames() {
        File file = new File("C:\\Users\\vival\\OneDrive\\Desktop\\Stan\\Java\\Sirma\\Homeworks_For_GitHub\\Sirma\\Projects\\InventoryManagementSystem\\");
        File[] files = file.listFiles();

        List<File> fileList = new ArrayList<>();
        for (var f : files) {
            if (f.toString().endsWith(".csv")) {
                fileList.add(f);
            }
        }
        return fileList;
    }

    private boolean exists(String path) {
        List<File> files = getFileNames();

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

    public void saveToExistingFile() {
        List<File> files = listFiles();

        System.out.println("Please choose a file to save to");
        System.out.print("-> ");

        int choice = choice(files.size());

        SaveFile.saveInventoryToExistingFile(manager.getInventory(), files.get(choice - 1).getAbsolutePath());

        returnToMenu();
    }

    public void saveNewFile() {
        System.out.println("Please enter the name of the file:");
        System.out.print("-> ");

        while (true) {
            try {
                String path = reader.readLine();

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

    public void saveInventoryToFile() {
        System.out.println(
                """
                1. Save/Add to existing file
                2. Save to new file
                3. Exit
                """
        );

        System.out.print("-> ");

        int choice = choice(2);

        switch (choice) {
            case 1:
                saveToExistingFile();
                break;
            case 2:
                saveNewFile();
                break;
            default:
                returnToMenu();
        }
    }

    private void addItem() throws IOException {
        System.out.println("""
                Type of an item:
                1. Fragile
                2. Electronics
                3. Grocery
                4. Return
                """);
        System.out.print("-> ");
        int choice = choice(4);

        if (choice == 4 || choice == -1) {
            returnToMenu();
        }

        System.out.print("Id: ");
        int id = Integer.parseInt(reader.readLine());

        

        System.out.print("Name: ");
        String name = reader.readLine();
        System.out.print("Category: ");
        String category = reader.readLine();
        System.out.print("Price: ");
        double price = choice(10_000);
        System.out.print("Quantity: ");
        int quantity = choice(10_000);

        double weight = 0;

        if (choice == 1) {
            System.out.print("Weight: ");
            weight = choice(10_000.0);
        }

        System.out.println();

        switch (choice) {
            case 1: {
                manager.add(new FragileItem(id, name, category, price, quantity, weight));
            } break;
            case 2: {
                manager.add(new ElectronicsItem(id, name, category, price, quantity));
            } break;
            default:
                manager.add(new GroceryItem(id, name, category, price, quantity));
        }
        System.out.println("Item successfully created!");

        showMenuOption();
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

    private void displayItems() throws IOException {
        manager.displayItems();
    }

    private void categorizeItems() {

        var items = manager.getInventory();
        while (true) {
            int choice = 0;
            try {
                displayItems();

                if (manager.getInventory().isEmpty()) {
                    System.out.println("Inventory is empty");
                    returnToMenu();
                } else {
                    System.out.println("Choose an item by ID (-1 to exit): ");
                    System.out.print("-> ");
                }

                choice = Integer.parseInt(reader.readLine());

                if (choice == -1) {
                    returnToMenu();
                }

                InventoryItem itemToCategorize = null;
                for (var item : items) {
                    if (item.getItemId() == choice) {
                        itemToCategorize = item;
                    }
                }
                if (itemToCategorize != null) {
                    System.out.print("Enter category: ");
                    String category = reader.readLine();

                    switch (itemToCategorize) {
                        case FragileItem fragileItem -> fragileItem.setCategory(category);
                        case ElectronicsItem electronicsItem -> electronicsItem.setCategory(category);
                        case GroceryItem groceryItem -> groceryItem.setCategory(category);
                        default -> {
                        }
                    }

                } else {
                    System.out.println("Item not found. Try again:");
                }
                returnToMenu();
            } catch (NumberFormatException | IOException e) {
                System.out.println("Use numbers");
            }
        }
    }

/*    private void placeOrder() throws IOException {
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
*/

    public void loadInventoryFromFile() {
        List<File> files = listFiles();

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
                String choice2 = reader.readLine();
                if (choice2.equalsIgnoreCase("y")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        manager.setInventory(LoadFile.loadInventoryFromFile(files.get(choice - 1).getAbsolutePath()));

        System.out.println("Inventory successfully loaded!");

        returnToMenu();
    }
}
