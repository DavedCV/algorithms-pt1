/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] stack;
    private int current;

    // construct an empty randomized queue
    public RandomizedQueue() {
        stack = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return current == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return current;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (current == stack.length) resize(2 * stack.length);
        stack[current++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        int rndm = StdRandom.uniformInt(current);
        Item value = stack[rndm];
        stack[rndm] = stack[--current];
        stack[current] = null;

        if (current > 0 && current == stack.length / 4) resize(stack.length / 2);
        return value;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int rndm = StdRandom.uniformInt(current);
        return stack[rndm];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < current; i++) {
            copy[i] = stack[i];
        }

        stack = copy;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new IterRandomQueue();
    }

    private class IterRandomQueue implements Iterator<Item> {

        private int n = 0;
        private Item[] copy = (Item[]) new Object[current];

        public IterRandomQueue() {
            for (int i = 0; i < current; i++) {
                copy[i] = stack[i];
            }
            StdRandom.shuffle(copy);
        }

        public boolean hasNext() {
            return n < current;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy[n++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        /*
        RandomizedQueue rq = new RandomizedQueue();
        int[] elems = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int elem : elems) {
            rq.enqueue(elem);
        }

        System.out.println("Random sample: " + rq.sample());
        System.out.println("Random dequeue: " + rq.dequeue());
        System.out.println("Random dequeue: " + rq.dequeue());

        System.out.print("random queue: [ ");
        for (Object elem : rq) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
         */
    }
}
