package Classes;

public class InventoryItem extends AbstractItem {
    private static int idCntr = 0;
    private int itemId;
    private int quantity;

    public InventoryItem(String category, boolean breakable, boolean perishable, double price, int quantity) {
        super(category, breakable, perishable, price);
        this.itemId = ++idCntr;
        this.quantity = quantity;
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
