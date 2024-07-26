package LiskovSubstitutionPrinciple.Bird;

public class Glarus extends FlyingBird {

    @Override
    public void fly() {
        System.out.println("Gets someones food and fly away");
    }

    @Override
    public void eat() {
        System.out.println("Enjoying freshly stolen food");
    }
}
