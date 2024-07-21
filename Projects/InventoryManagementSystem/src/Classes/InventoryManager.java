package Classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InventoryManager {

    private List<InventoryItem> inventory = new ArrayList<>();

    public InventoryManager() {
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

    public void searchByName(String name) {
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
    }

    public void searchByCategory(String category) {
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
    }

    public boolean exists(int id) {

        boolean idExists = false;
        for (var item : inventory) {
            if (id == item.getItemId()) {
                System.out.println("There is an item with this ID");
                idExists = true;
            }
        }
        return idExists;
    }

    public List<File> getFileNames() {
        File file = new File("inventory/");
        File[] files = file.listFiles();

        List<File> fileList = new ArrayList<>();
        for (var f : files) {
            if (f.toString().endsWith(".csv")) {
                fileList.add(f);
            }
        }
        return fileList;
    }

    public List<File> getFiles() {
        File file = new File("inventory/");
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
        } else {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getPrice).reversed());
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
        } else {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getCategory).reversed());
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
        } else {
            itemsToSort.sort(Comparator.comparing(InventoryItem::getName).reversed());
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
