package LiskovSubstitutionPrinciple.Engine;

public class CombustionEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Engine starts with roar");
    }
}
