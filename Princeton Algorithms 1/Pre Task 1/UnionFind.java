public class UnionFind {

    // parent[i] = parent of i in the union-find tree
    private final int[] parent;

    // size[i] = size of the tree whose root is i
    private final int[] size;

    // number of components (groups)
    private int count;

    // Constructor: start with n elements, each in its own group.
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;  // each element is its own parent (root)
            size[i] = 1;    // each tree initially has size 1
        }
    }

    // Find the root ("boss") of p, with path compression.
    private int find(int p) {
        int root = p;

        // Step 1: climb to the root
        while (root != parent[root]) {
            root = parent[root];
        }

        // Step 2: path compression - make every visited node point to the root
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }

        return root;
    }

    // Are p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Merge the components containing p and q (weighted by tree size).
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return; // already in the same group, nothing to do
        }

        // Attach smaller tree under larger tree
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        count--;
    }

    // How many components remain?
    public int count() {
        return count;
    }
}
