package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadFile {

    public static List<InventoryItem> loadInventoryFromFile(String file) {
        List<InventoryItem> items = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = read.readLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }
                String className = line.trim();
                int itemId = Integer.parseInt(read.readLine().trim());
                String name = read.readLine().trim();
                double price = Double.parseDouble(read.readLine().trim());
                int quantity = Integer.parseInt(read.readLine().trim());
                String category = read.readLine().trim();

                InventoryItem item;
                switch (className) {
                    case "FragileItem": {
                        double weight = Double.parseDouble(read.readLine().trim());
                        item = new FragileItem(itemId, name, category, price, quantity, weight);
                    } break;
                    case "ElectronicsItem": {
                        item = new ElectronicsItem(itemId, name, category, price, quantity);
                    } break;
                    case "GroceryItem": {
                        item = new GroceryItem(itemId, name, category, price, quantity);
                    } break;
                    default:
                        throw new IllegalArgumentException("No such item type: " + className);
                }
                item.setItemId(itemId);
                items.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}
