package data_structure.union_find;

/**
 * Given a set of N objects
 * Union command: connect two objects
 * Find/connected query: is there a path connecting the two objects?
 */
public class UF {
    // id[i] is parent of i
    private int[] id;
    private int[] sz;

    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // path compression
    private int root(int i) {
        while (i != id[i]) {
            // make every other node in path point to the grandparent
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        // improvement using weighted UF
        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
