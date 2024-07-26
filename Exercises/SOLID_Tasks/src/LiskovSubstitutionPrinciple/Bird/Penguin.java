package LiskovSubstitutionPrinciple.Bird;

public class Penguin extends Bird{

    @Override
    public void eat() {
        System.out.println("Eats a whole bunch of squids");
    }
}
