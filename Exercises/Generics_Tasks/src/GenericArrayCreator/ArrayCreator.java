package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public ArrayCreator() {
    }

    public static <T> T[] create(int length, T item) {
        T[] items = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < items.length; i++) {
            items[i] = item;
        }
        return items;
    }

    public static <T> T[] create(Class<T> classT, int length, T item) {
        T[] items = (T[]) Array.newInstance(classT, length);

        for (int i = 0; i < items.length; i++) {
            items[i] = item;
        }
        return items;
    }
}
