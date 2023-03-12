import edu.princeton.cs.algs4.StdIn;

public class Main {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println(p + " " + q);
            }
        }

    }
}