/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            rq.enqueue(input);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
