public class InsertionSort {

    public static void sort(Comparable[] iterable){
        int length = iterable.length;
        for (int i = 0; i < length; i++){
            for (int j = i; i > 0; i--){
                if (less(iterable[j], iterable[j-1])){
                    exch(iterable, j, j-1);
                }else{
                    break;
                }
            }
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] iterable, int a, int b){
        Comparable aux = iterable[a];
        iterable[a] = b;
        iterable[b] = aux;
    }
}
