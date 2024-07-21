package Classes;

import Interfaces.Categorizable;
import Interfaces.Sellable;

public class ElectronicsItem extends InventoryItem implements Categorizable, Sellable {

    public ElectronicsItem(int itemId, String name, String category, double price, int quantity) {
        super(itemId, name, price, quantity, category);
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public void setCategory(String category) {
        super.setCategory(category);
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public double calculateValue() {
        return super.calculateValue(); // Example calculation
    }
}
