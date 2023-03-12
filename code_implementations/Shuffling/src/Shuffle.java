//use the StdRandom library of princeton
import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {
    public static void shuffle(Object[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            int r = StdRandom.uniformInt(i + 1);
            Object aux = a[i];
            a[i] = a[r];
            a[r] = aux;
        }
    }
}
