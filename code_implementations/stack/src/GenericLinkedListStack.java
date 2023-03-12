import java.util.Iterator;

public class GenericLinkedListStack<Item> implements Iterable<Item>{
    class Node {
        Node next;
        Item item;
    }

    private Node first;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
    }

    public Item pop(){
        Item value = first.item;
        first = first.next;
        return value;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current;

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){}

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
