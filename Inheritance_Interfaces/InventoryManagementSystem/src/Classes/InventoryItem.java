package Classes;

public class InventoryItem extends AbstractItem {
    private int itemId;
    private int quantity;

    public InventoryItem(String category, boolean breakable, boolean perishable, double price,
                         int itemId, int quantity) {
        super(category, breakable, perishable, price);
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public InventoryItem() {

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
