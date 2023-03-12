public class stack{
    private class Node{
        Comparable value;
        Node next;
    }

    private Node first;
    private Comparable max;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Comparable value){
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
        if (max == null) max = value;
        else if (value.compareTo(max) > 0) max = value;
    }

    public Comparable pop(){
        Comparable value = first.value;
        first = first.next;
        return value;
    }

    public Comparable returnMaximum(){
        return max;
    }
}
