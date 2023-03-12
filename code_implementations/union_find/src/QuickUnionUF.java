public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int node){
        int aux = node;
        while (id[aux] != aux){
            aux = id[aux];
        }
        return aux;
    }

    public void union(int p, int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        id[pRoot] = qRoot;
    }
}
