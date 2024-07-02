package Classes;

public class GroceryItem extends InventoryItem {
    private String name;
    private String type;

    public GroceryItem(String name, String type, String category, double price,
                       int itemId, int quantity) {
        super(category, false, true, price, itemId, quantity);
        this.name = name;
        this.type = type;
    }

    @Override
    public double calculateValue() {
        return getQuantity() * getItemPrice();
    }
}
