package Classes;

public class GroceryItem extends InventoryItem {
    private String name;
    private String type;

    public GroceryItem(String name, String type, String category, double price, int quantity) {
        super(category, false, true, price, quantity);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public double calculateValue() {
        return getQuantity() * getItemPrice();
    }

    @Override
    public String getItemsDescription() {
        return toString();
    }

    @Override
    public String toString() {
        return "Type: Grocery" + "\n" +
                "ID: " + getItemId() + "\n" +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Category: " + getItemCategory() + "\n" +
                "Price: " + getItemPrice();
    }
}
