package OpenClosedPrinciple.Calculator;

public class Senior implements Discount {

    private double discount;

    public Senior(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateDiscount(double price) {
        return price * discount;
    }
}