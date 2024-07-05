package Classes;

import Interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable,
        Perishable, Sellable {
    private String category;
    private boolean breakable;
    private boolean perishable;
    private double price;

    public AbstractItem(String category, boolean breakable,
                        boolean perishable, double price) {
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.price = price;
    }

    public AbstractItem() {
    }

    @Override
    public void itemDetails() {
    }

    @Override
    public double calculateValue() {
        return 0;
    }

    @Override
    public String getItemsDescription() {
        return null;
    }

    @Override
    public boolean checkIfBreakable() {
        return this.breakable;
    }

    @Override
    public void handleItemBreakage() {
    }

    @Override
    public String getItemCategory() {
        return this.category;
    }

    @Override
    public void setItemCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean checkIfPerishable() {
        return this.perishable;
    }

    @Override
    public void handleItemExpiration() {
    }

    @Override
    public double getItemPrice() {
        return this.price;
    }

    @Override
    public void setItemPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Category = '" + category + "\n" +
                "Breakable = " + breakable + "\n" +
                "Perishable = " + perishable + "\n" +
                "Price = " + price;
    }
}
