package Classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveFile {

    public SaveFile() {
    }

    public static void saveInventoryToExistingFile(List<InventoryItem> items, String path) {

        try (PrintWriter write = new PrintWriter(new FileWriter(path, true))) {
            for (var item : items) {
                write.println(item.getClass().getSimpleName());
                write.println(item.getItemId());
                write.println(item.getName());
                write.println(item.getPrice());
                write.println(item.getQuantity());

                switch (item) {
                    case FragileItem fragileItem -> {
                        write.println(fragileItem.getCategory());
                        write.println(fragileItem.getWeight());
                    }
                    case ElectronicsItem electronicsItem -> write.println(electronicsItem.getCategory());
                    case GroceryItem groceryItem -> write.println(groceryItem.getCategory());
                    default -> {
                    }
                }
                write.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveInventoryToNewFile(List<InventoryItem> items, String path) {
        try (PrintWriter write = new PrintWriter(new FileWriter(path))) {
            for (var item : items) {
                write.println(item.getClass().getSimpleName());
                write.println(item.getItemId());
                write.println(item.getName());
                write.println(item.getPrice());
                write.println(item.getQuantity());

                switch (item) {
                    case FragileItem fragileItem -> {
                        write.println(fragileItem.getCategory());
                        write.println(fragileItem.isBreakable());
                        write.println(fragileItem.getWeight());
                    }
                    case ElectronicsItem electronicsItem -> write.println(electronicsItem.getCategory());
                    case GroceryItem groceryItem -> write.println(groceryItem.getCategory());
                    default -> {
                    }
                }
                write.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
