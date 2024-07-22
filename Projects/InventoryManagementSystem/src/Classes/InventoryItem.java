package Classes;

public class InventoryItem extends AbstractItem {
    private int itemId;
    private int quantity;
    private String category;

    public InventoryItem() {
    }

    public InventoryItem(int itemId, String name, double price, int quantity, String category) {
        super(name, price);
        this.itemId = itemId;
        this.quantity = quantity;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getItemId() {
        return this.itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getItemDetails() {
        return String.format("%-20s %s %-20s %-20s", ("ID: " + itemId), (super.getItemDetails()), ("Category: " + category), ("Quantity: " + quantity));
    }

    @Override
    public double calculateValue() {
        return this.price * this.quantity;
    }
}