package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoxIntegerMain {
    public static void main(String[] args) {
        // Class that stores any type
        // toString prints {class full name}: {value}
        // Testing the Box class with Integer

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int inputLines = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(Integer.class, inputLines);

            for (int line = 0; line < inputLines; line++) {
                var item =Integer.parseInt(reader.readLine());
                box.add(item);
                System.out.println(box);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
    }
}
