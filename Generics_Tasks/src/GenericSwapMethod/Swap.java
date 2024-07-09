package GenericSwapMethod;

import java.util.List;

public class Swap<T> {

    public Swap() {
    }

    public void swap(List<T> list, int in1, int in2) {
        if (in1 < 0 || in1 >= list.size() || in2 < 0 || in2 >= list.size()) {
            throw new ArrayIndexOutOfBoundsException("Out of bounds array indices.");
        }
        T temp = list.get(in1);
        list.set(in1, list.get(in2));
        list.set(in2, temp);
    }

    public void print(List<T> list) {
        for (var item : list) {
            if (item != null) {
                System.out.println(item.getClass().getName() + ": " + item);
            } else {
                System.out.println("Null item");
            }
        }
    }
}
