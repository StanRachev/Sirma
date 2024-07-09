package GenericBox;

import java.lang.reflect.Array;

public class Box<T> {
    private T[] items;
    private int size;

    public Box (Class<T> clasz, int length) {
        items = (T[]) Array.newInstance(clasz, length);
        size = 0;
    }

    public void add(T item) {
        if (size > items.length) {
            throw new ArrayIndexOutOfBoundsException("List is full");
        }
        items[size] = item;
        size++;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Box is empty";
        }
        return items[size - 1].getClass().getName() + ": " + items[size - 1];
    }
}