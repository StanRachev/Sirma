package OpenClosedPrinciple.Calculator;

public class Student implements Discount {

    private double discount;

    public Student(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateDiscount(double price) {
        return price * discount;
    }
}
