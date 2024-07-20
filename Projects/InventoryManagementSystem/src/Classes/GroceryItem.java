package Classes;

import Interfaces.Categorizable;
import Interfaces.Perishable;
import Interfaces.Sellable;

public class GroceryItem extends InventoryItem implements Categorizable, Perishable, Sellable {
    private String category;
    private boolean perishable;

    public GroceryItem(int itemId, String name, String category, double price, int quantity) {
        super(itemId, name, price, quantity);
        this.category = category;
        this.perishable = true;
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
}
