package CustomList;

import java.lang.reflect.Array;

public class CustomList<T extends Comparable<T>> {

    private T[] list;
    private int length;
    private int size;

    public CustomList(Class<T> clasz) {
        length = 4;
        list = (T[]) Array.newInstance(clasz, length);
        size = 0;
    }

    private void increase() {
        T[] newList = (T[]) new Object[length * 2];
        for (int i = 0; i < length * 2; i++) {
            if (i == length - 1) {
                newList[i] = null;
            }
            newList[i] = list[i];
        }
        list = newList;
        length *= 2;
    }

    public void add(T element) {
        if (size == length) {
            increase();
        }
        list[size] = element;
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T temp = list[index];

        for (int i = 0; i < length - 1; i++) {
            list[index] = list[index + 1];
        }
        list[--size] = null;
        return temp;
    }

    public boolean contains(T element) {
        for (var el : list) {
            if (el.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    public void swap(int in1, int in2) {
        if (in1 < 0 || in1 >= size || in2 < 0 || in2 >= size) {
            throw new ArrayIndexOutOfBoundsException("Out of bounds array indices.");
        }

        if (in1 == in2) {
            return;
        }
        T temp = list[in1];
        list[in1] = list[in2];
        list[in2] = temp;
    }

    public int countGreaterThan(T element) {
        int count = 0;

        for (var item : list) {
            if (item == null) {
                break;
            } else if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        if (size == 0) {
            System.out.println("List is empty");
        }
        T max = list[0];
        for (var item : list) {
            if (item == null) {
                break;
            } else if (max.compareTo(item) < 0) {
                max = item;
            }
        }
        return max;
    }

    public T getMin() {
        T min = list[0];
        for (var item : list) {
            if (item == null) {
                break;
            } else if (min.compareTo(item) > 0) {
                min = item;
            }
        }
        return min;
    }

    public void print() {
        for (var item : list) {
            if (item == null) {
                break;
            }
            System.out.println(item);
        }
    }
}