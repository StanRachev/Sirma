package Classes;

import Interfaces.Breakable;
import Interfaces.Categorizable;
import Interfaces.Sellable;

public class FragileItem extends InventoryItem implements Categorizable, Breakable, Sellable {
    private boolean breakable;
    private double weight;

    public FragileItem(int itemId, String name, String category, double price, int quantity, double weight) {
        super(itemId, name, price, quantity, category);
        this.breakable = true;
        this.weight = weight;
    }

    @Override
    public boolean isBreakable() {
        return this.breakable;
    }

    @Override
    public void handleBreakage() {
        if (this.breakable) {
            System.out.println(this.name + " is broken!");
        }
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

    public double getWeight() {
        return weight;
    }

    @Override
    public double calculateValue() {
        return super.calculateValue() + (this.weight * 0.1); // Example calculation
    }
}