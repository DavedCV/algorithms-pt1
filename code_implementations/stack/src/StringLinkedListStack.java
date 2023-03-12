public class StringLinkedListStack {
    class Node {
        Node next;
        String item;
    }

    private Node first;

    public boolean isEmpty(){
        return first == null;
    }
    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
    }

    public String pop(){
        String value = first.item;
        first = first.next;
        return value;
    }
}
