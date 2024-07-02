package Classes;

public class ElectronicsItem extends InventoryItem {
    private String brand;
    private int warranty;

    public ElectronicsItem(String brand, int warranty, String category, double price,
                           int itemId, int quantity) {
        super(category, true, true, price, itemId, quantity);
        this.brand = brand;
        this.warranty = warranty;
    }

    @Override
    public double calculateValue() {
        return getQuantity() * getItemPrice();
    }
}
