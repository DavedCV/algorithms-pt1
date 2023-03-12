public class LinkedListQueue {
    private class Node{
        private Node next;
        private String item;
    }

    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(String item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if (isEmpty()) first = newNode;
        else  last.next = newNode;
        last = newNode;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

}
