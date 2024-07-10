package GenericCountMethod;

import java.util.List;

public class Count<T extends Comparable<T>> {

    public Count() {
    }

    public int count(List<T> list, T element) {
        int count = 0;

        for (var item : list) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
}