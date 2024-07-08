package GenericArrayCreator;

public class ArrayCreatorMain {
    public static void main(String[] args) {
        // Class that creates an Array of a given type
        // Returns an Array with given length and default item

        String[] arrStr = ArrayCreator.create(String.class,5, "Haha");
        print(arrStr);

        Integer[] arrInt = ArrayCreator.create(Integer.class,5, 1992);
        print(arrInt);
    }

    private static <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
