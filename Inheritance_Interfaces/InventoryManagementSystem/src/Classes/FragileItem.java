package Classes;

public class FragileItem extends InventoryItem {
    private double weight;
    private String material;

    public FragileItem(double weight, String material, String category, double price, int quantity) {
        super(category, true, false, price, quantity);
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

    @Override
    public String getItemsDescription() {
        return toString();
    }

    @Override
    public String toString() {
        return "Type: Fragile" + "\n" +
                "ID: " + getItemId() + "\n" +
                "Weight: " + weight + "\n" +
                "Material: " + material + "\n" +
                "Category: " + getItemCategory() + "\n" +
                "Price: " + getItemPrice();
    }
}