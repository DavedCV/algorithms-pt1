public class QuickUnionUF {

    private int[] id;
    private int[] idw;
    private int[] maxNode;

    public QuickUnionUF(int N){
        id = new int[N];
        idw = new int[N];
        maxNode = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            idw[i] = 0;
            maxNode[i] = i;
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

        if (pRoot == qRoot) return;
        if (idw[pRoot] > idw[qRoot]) {
            id[qRoot] = pRoot;
            idw[pRoot] += idw[qRoot];
            if (maxNode[qRoot] > maxNode[pRoot]){
                maxNode[pRoot] = maxNode[qRoot];
            }
        }
        else {
            id[pRoot] = qRoot;
            idw[qRoot] += idw[pRoot];
            if (maxNode[pRoot] > maxNode[qRoot]){
                maxNode[qRoot] = maxNode[pRoot];
            }
        }
    }

    public int find(int p){
        int pRoot = findRoot(p);
        return maxNode[pRoot];
    }
}
