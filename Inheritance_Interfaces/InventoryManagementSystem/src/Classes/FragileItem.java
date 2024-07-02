package Classes;

public class FragileItem extends InventoryItem {
    private int weight;
    private String material;

    public FragileItem(int weight, String material, String category, double price,
                       int itemId, int quantity) {
        super(category, true, false, price, itemId, quantity);
        this.weight = weight;
        this.material = material;
    }

    @Override
    public double calculateValue() {
        return getQuantity() * getItemPrice() * this.weight;
    }
}