package GenericScale;

public class ScaleMain {
    public static void main(String[] args) {
        // Class that compares two elements and returns the greater

        Scale<Integer> scaleInt = new Scale<>(4, 5);
        System.out.println(scaleInt.getHeavier());

        Scale<String> scaleStr = new Scale<>("Hay", "Say");
        System.out.println(scaleStr.getHeavier());
    }
}