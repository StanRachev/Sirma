package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomListMain {
    public static void main(String[] args) {
        // Generic data structure that store any type
        // can be compared
        // Test with String

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<String>(String.class);

        try {
            while (true) {
                String[] commands = reader.readLine().split("[, ]+");
                String command = commands[0];
                boolean isEnd = false;

                switch (command) {
                    case "Add":
                        String element = commands[1];
                        list.add(element);
                        break;
                    case "Remove":
                        int index = Integer.parseInt(commands[1]);
                        list.remove(index);
                        break;
                    case "Contains":
                        String el = commands[1];
                        System.out.println(list.contains(el));
                        break;
                    case "Swap":
                        int in1 = Integer.parseInt(commands[1]);
                        int in2 = Integer.parseInt(commands[2]);
                        list.swap(in1, in2);
                        break;
                    case "Greater":
                        String e = commands[1];
                        System.out.println(list.countGreaterThan(e));
                        break;
                    case "Max":
                        System.out.println(list.getMax());
                        break;
                    case "Min":
                        System.out.println(list.getMin());
                        break;
                    case "Print":
                        list.print();
                        break;
                    case "end":
                        isEnd = true;
                        break;
                }
                if (isEnd) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException n) {
            System.out.println("Please use digits");
        }
    }
}
