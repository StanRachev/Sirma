package Classes;

import Interfaces.Item;

public abstract class AbstractItem implements Item {
    protected String name;
    protected double price;

    public AbstractItem() {
    }

    public AbstractItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getItemDetails() {
        return String.format("%-20s %-20s", ("Name: " + name), ("Price: " + price));
    }

    public abstract double calculateValue();
}
