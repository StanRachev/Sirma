import Classes.ElectronicsItem;
import Classes.FragileItem;
import Classes.GroceryItem;
import Classes.InventoryItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<InventoryItem> items = new ArrayList<>();
        items.add(new FragileItem(300, "Glass", "Kitchenware", 15, 1, 2));
        items.add(new ElectronicsItem("TherMe", 36, "Health", 15, 2, 3));
        items.add(new GroceryItem("Tomatoes", "Vegetable", "Watery", 1.5, 3, 10));

        saveInventoryToFile(items, "C:\\Users\\vival\\OneDrive\\Desktop\\Stan\\Java\\Sirma\\Homeworks_For_GitHub\\Sirma\\Inheritance_Interfaces\\saveItems.txt");

        items.clear();

        items.addAll(loadInventoryFromFile("C:\\Users\\vival\\OneDrive\\Desktop\\Stan\\Java\\Sirma\\Homeworks_For_GitHub\\Sirma\\Inheritance_Interfaces\\saveItems.txt"));

        System.out.println(items.get(0).getClass().getSimpleName() + ": " + items.get(0).calculateValue());
        System.out.println(items.get(1).getClass().getSimpleName() + ": " + items.get(1).calculateValue());
        System.out.println(items.get(2).getClass().getSimpleName() + ": " + items.get(2).calculateValue());
    }

    public static void saveInventoryToFile(List<InventoryItem> items, String file) {
        try (PrintWriter write = new PrintWriter(new FileWriter(file))) {
            for (var item : items) {
                write.println(item.getClass().getSimpleName());
                write.println(item.getQuantity());
                write.println(item.getItemId());
                write.println(item.getItemPrice());
                write.println(item.getItemCategory());

                if (item instanceof FragileItem) {
                    write.println(((FragileItem) item).getWeight());
                    write.println(((FragileItem) item).getMaterial());
                } else if (item instanceof ElectronicsItem) {
                    write.println(((ElectronicsItem) item).getBrand());
                    write.println(((ElectronicsItem) item).getWarranty());
                } else if (item instanceof GroceryItem) {
                    write.println(((GroceryItem) item).getName());
                    write.println(((GroceryItem) item).getType());
                }
                write.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<InventoryItem> loadInventoryFromFile(String file) {
        List<InventoryItem> items = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = read.readLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }
                String className = line.trim();
                int quantity = Integer.parseInt(read.readLine().trim());
                int itemId = Integer.parseInt(read.readLine().trim());
                double price = Double.parseDouble(read.readLine().trim());
                String category = read.readLine().trim();

                switch (className) {
                    case "FragileItem": {
                        double weight = Double.parseDouble(read.readLine().trim());
                        String material = read.readLine().trim();
                        items.add(new FragileItem(weight, material, category, price, itemId, quantity));
                    } break;
                    case "ElectronicsItem": {
                        String brand = read.readLine().trim();
                        int warranty = Integer.parseInt(read.readLine().trim());
                        items.add(new ElectronicsItem(brand, warranty, category, price, itemId, quantity));
                    } break;
                    case "GroceryItem": {
                        String name = read.readLine().trim();
                        String type = read.readLine().trim();
                        items.add(new GroceryItem(name, type, category, price, itemId, quantity));
                    } break;
                    default:
                        throw new IllegalArgumentException("No such item type: " + className);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}