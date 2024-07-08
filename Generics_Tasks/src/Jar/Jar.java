package Jar;

import java.util.ArrayDeque;

public class Jar<E> {
    private ArrayDeque<E> items;

    public Jar() {
        items = new ArrayDeque();
    }

    public void add(E element) {
        this.items.push(element);
    }

    public E remove() {
        return items.pop();
    }

    public void print() {
        if (items.isEmpty()) {
            System.out.print("List is empty");
        } else {
            for (E item : items) {
                System.out.print(item);
                if (!item.equals(items.getLast())) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}