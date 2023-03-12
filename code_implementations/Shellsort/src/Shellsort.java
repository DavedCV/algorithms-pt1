public class Shellsort {

    public static void shell(Comparable[] a){
        int N = a.length;

        int h = 1;
        while(h < N/3) h = 3*h + 1; //knuth's increment sequence

        while(h >= 1){
            // h-sort the array
            for (int i = h; i < N; i++){
                // insertion sort with step based on the h
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h){
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
