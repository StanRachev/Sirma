package LiskovSubstitutionPrinciple.Engine;

public class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Engine starts, but wonder did it start.");
    }
}
