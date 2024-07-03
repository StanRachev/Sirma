package Classes;

public class FragileItem extends InventoryItem {
    private double weight;
    private String material;

    public FragileItem(double weight, String material, String category, double price,
                       int itemId, int quantity) {
        super(category, true, false, price, itemId, quantity);
        this.weight = weight;
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public double calculateValue() {
        return getQuantity() * getItemPrice() + (this.weight / 1000);
    }
}