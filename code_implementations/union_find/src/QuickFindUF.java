public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        // we create an array with N objects and each entry with its corresponding ID
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        // based in the fact that each connected items have the same id
        return id[p] == id[q];
    }

    public void union (int p, int q) {
        // iterate through each node of the array, and if the id of the position is equal to the id
        // of the first node, then replace it with the id of the second node
        int p_id = id[p];
        int q_id = id[p];

        for (int i = 0; i < id.length; i++){
            if (id[i] == p_id){
                id[i] = q_id;
            }
        }
    }
}
