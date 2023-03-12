import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args) {
        GenericLinkedListQueue<String> queue = new GenericLinkedListQueue<>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("-")) StdOut.print(queue.dequeue());
            else queue.enqueue(s);
        }
    }
}