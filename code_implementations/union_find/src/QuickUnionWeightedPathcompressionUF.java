public class QuickUnionWeightedPathcompressionUF {
    private int[] id;
    private int[] idw;

    public QuickUnionUF(int N){
        id = new int[N];
        idw = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            idw[i] = 0;
        }
    }

    public boolean connected(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int node){
        int aux = node;
        while (id[aux] != aux){
            id[aux] = id[id[aux]];
            aux = id[aux];
        }
        return aux;
    }

    public void union(int p, int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;
        if (idw[pRoot] > idw[qRoot]) {id[qRoot] = pRoot; idw[pRoot] += idw[qRoot];}
        else {id[pRoot] = qRoot; idw[qRoot] += idw[pRoot];}
    }

}
