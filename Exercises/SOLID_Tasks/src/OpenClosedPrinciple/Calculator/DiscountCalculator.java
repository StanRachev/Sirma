package OpenClosedPrinciple.Calculator;

public class DiscountCalculator {

    public double calculateDiscount(Discount discountType, double price) {
        return discountType.calculateDiscount(price);
    }
}
