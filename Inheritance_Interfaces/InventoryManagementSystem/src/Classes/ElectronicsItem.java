package Classes;

public class ElectronicsItem extends InventoryItem {
    private String brand;
    private int warranty;

    public ElectronicsItem(String brand, int warranty, String category, double price, int quantity) {
        super(category, true, true, price, quantity);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarranty() {
        return warranty;
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
        return "Type: Electronics" + "\n" +
                "ID: " + getItemId() + "\n" +
                "Band: " + brand + "\n" +
                "Warranty: " + warranty + "\n" +
                "Category: " + getItemCategory() + "\n" +
                "Price: " + getItemPrice();
    }
}
