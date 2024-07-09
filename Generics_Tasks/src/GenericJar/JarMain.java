package Jar;

public class JarMain {
    public static void main(String[] args) {
        // Class that can store anything

        Jar<String> jar = new Jar<String>();

        jar.add("Glasses");
        jar.add("Phone");
        jar.add("Laptop");

        System.out.print("Initial list: ");
        jar.print();

        System.out.println("Item removed: " + jar.remove());

        System.out.print("Updated list: ");
        jar.print();

        Jar<Integer> jarInt = new Jar<Integer>();

        jarInt.add(123);

        System.out.print("Initial list: ");
        jarInt.print();

        System.out.println("Item removed: " + jarInt.remove());

        System.out.print("Updated list: ");
        jarInt.print();
    }
}
