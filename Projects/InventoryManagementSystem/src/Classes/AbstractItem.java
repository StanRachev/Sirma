package Classes;

public abstract class AbstractItem {
    protected String name;
    protected double price;

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
        return "Name: " + name + ", Price: " + price;
    }

    public abstract double calculateValue();
}
