package GenericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SwapStringMain {
    public static void main(String[] args) {
        // Class Swap that swaps two indices of a list
        // Test with String

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter the number of elements: ");
            int length = Integer.parseInt(reader.readLine());

            Swap<String> swap = new Swap<>();
            List<String> list = new ArrayList<>();

            System.out.println("Enter the elements:");
            for (int i = 0; i < length; i++) {
                list.add(reader.readLine());
            }

            System.out.print("Enter the indices to swap (comma or space): ");
            String[] indexes = reader.readLine().split("[, ]+");
            int in1 = Integer.parseInt(indexes[0]);
            int in2 = Integer.parseInt(indexes[1]);

            swap.swap(list, in1, in2);
            swap.print(list);

        } catch (IOException e) {
            System.out.println("Please use digits");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
    }
}
