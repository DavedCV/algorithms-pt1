public class GenericLinkedListQueue<Item> {
    private class Node{
        private Node next;
        private Item item;
    }

    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Item item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if (isEmpty()) first = newNode;
        else  last.next = newNode;
        last = newNode;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }
}
