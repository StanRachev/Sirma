package Classes;

import Interfaces.Categorizable;
import Interfaces.Sellable;

public class ElectronicsItem extends InventoryItem implements Categorizable, Sellable {
    private String category;

    public ElectronicsItem(int itemId, String name, String category, double price, int quantity) {
        super(itemId, name, price, quantity);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
