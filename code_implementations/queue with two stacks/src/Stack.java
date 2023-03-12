public class Stack<Item> {

    private class Node{
        Item value;
        Node next;
    }

    private Node first;

    public Item pop(){
        Item value = first.value;
        first = first.next;
        return value;
    }

    public void push(Item value){
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
