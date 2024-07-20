package Classes;

public class InventoryItem extends AbstractItem {
    private int itemId;
    private int quantity;

    public InventoryItem(int itemId, String name, double price, int quantity) {
        super(name, price);
        this.itemId = itemId;
        this.quantity = quantity;
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
        return "ID: " + itemId + ", " + super.getItemDetails() + ", Quantity: " + quantity;
    }

    @Override
    public double calculateValue() {
        return this.price * this.quantity;
    }
}