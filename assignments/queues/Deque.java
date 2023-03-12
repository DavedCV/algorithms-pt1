/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Node next;
        Node previous;
        Item value;
    }

    private Node first;
    private Node last;
    private int size;

    public Deque() {

    }

    public boolean isEmpty() {
        return first == last && first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node oldFirst = first;
        first = new Node();
        first.value = item;
        size++;

        if (oldFirst == null) last = first;
        else {
            first.next = oldFirst;
            oldFirst.previous = first;
        }
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node oldLast = last;
        last = new Node();
        last.value = item;
        size++;

        if (oldLast == null) first = last;
        else {
            last.previous = oldLast;
            oldLast.next = last;
        }
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) last = null;
        else first.next.previous = null;

        Item value = first.value;
        first = first.next;
        size--;
        return value;

    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) first = null;
        else last.previous.next = null;

        Item value = last.value;
        last = last.previous;
        size--;
        return value;
    }

    public Iterator<Item> iterator() {
        return new IterDeque();
    }

    private class IterDeque implements Iterator<Item> {

        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item value = current.value;
            current = current.next;
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        /*
        Deque dq = new Deque();

        for (int i = 1; i <= 10; i++) {
            dq.addFirst(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(dq.removeLast());
        }
        System.out.println();
        for (Object elem : dq) {
            System.out.println((int) elem);
        }
        */

/*
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.removeFirst();
        deque.removeLast();
        deque.addFirst(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addFirst(8);
        deque.addLast(9);
        deque.addLast(10);

        deque.removeLast();

        System.out.print("[ ");
        for (Object elem :
                deque) {
            System.out.print(elem + " ");
        }
        System.out.println("]");



 */
    }
}
