import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Main {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        String date, time;
        //timestamps are sorted ascending
        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            date = StdIn.readString();
            time = StdIn.readString();


            uf.union(p, q);

            StdOut.println("["+p+","+q+"]");

            if(uf.count() == 1){
                StdOut.println("All members were connected at: " + date + time);
                break;
            }
        }
    }
}