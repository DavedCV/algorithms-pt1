import java.util.Arrays;
import java.util.List;

public class WeightedQuickUnionFind {

    int[] id;
    int[] size;
    List names;
    boolean flag;

    public WeightedQuickUnionFind(int N, String[] names){
        this.size = new int[N];
        this.id = new int[N];
        this.names = Arrays.asList(names);
        for (int i = 0; i < N; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    private int findRoot(int node){
        int aux = node;
        while(id[aux] != aux){
            aux = id[aux];
        }
        return aux;
    }

    public boolean connected(String p, String q){
        int pIndex = names.indexOf(p);
        int qIndex = names.indexOf(q);

        return findRoot(pIndex) == findRoot(qIndex);
    }

    public void union(String p, String q){
        int pRoot = findRoot(names.indexOf(p));
        int qRoot = findRoot(names.indexOf(q));

        if (pRoot == qRoot) return;
        if (size[pRoot] > size[qRoot]){
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
            if (size[pRoot] == id.length) this.flag = true;
        }else {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
            if (size[qRoot] == id.length) this.flag = true;
        }
    }

}
