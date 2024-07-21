package Classes;

import Interfaces.Categorizable;
import Interfaces.Perishable;
import Interfaces.Sellable;

public class GroceryItem extends InventoryItem implements Categorizable, Perishable, Sellable {
    private boolean perishable;

    public GroceryItem(int itemId, String name, String category, double price, int quantity) {
        super(itemId, name, price, quantity, category);
        this.perishable = true;
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
    public boolean isPerishable() {
        return this.perishable;
    }

    @Override
    public void handleExpiration() {
        if (this.perishable) {
            System.out.println(this.name + " has expired!");
        }
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
