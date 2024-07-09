package GenericCountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountDoubleMain {
    public static void main(String[] args) {
        // Compares elements from a list to a given element
        // and returns count of elements that are greater in the list
        // Test with Double

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Count<Double> count = new Count<>();
        List<Double> list = new ArrayList<>();

        try {
            int elements = Integer.parseInt(reader.readLine());
            for (int el = 0; el < elements; el++) {
                Double item = Double.parseDouble(reader.readLine());
                list.add(item);
            }

            Double elToCompare = Double.parseDouble(reader.readLine());

            int countElementsGreaterThan = count.count(list, elToCompare);
            System.out.println(countElementsGreaterThan);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException n) {
            System.out.println("Please use digits");
        }
    }
}
