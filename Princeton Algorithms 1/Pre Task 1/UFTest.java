

public class UFTest {
    public static void main(String[] args) {
        // Create UF with 10 elements: 0..9
        UnionFind uf = new UnionFind(10);

        // Same sequence as Sedgewick's tinyUF example
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5,1);

        System.out.println("connected(0, 7): " + uf.connected(0, 7)); // false
        System.out.println("connected(8, 9): " + uf.connected(8, 9)); // true
        System.out.println("connected(5,1): " + uf.connected(5,1));

        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);

        System.out.println("connected(0, 7): " + uf.connected(0, 7)); // true
        System.out.println("Number of groups: " + uf.count());
    }
}
