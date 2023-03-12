public class Main {
    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(20);
        int[] set = {17,10,6,15};

        for (int i = 0; i < set.length-1; i++){
            uf.union(set[i], set[i+1]);
        }

        for (int element : set){
            System.out.println("The largest number in the connected node is: " + uf.find(element));
        }
    }
}