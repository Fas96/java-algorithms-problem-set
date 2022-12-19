package Algoritms.UnionFind.code;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<Integer, Integer> parent;

    public DisjointSet() {
        parent = new HashMap<>();
    }

    // Find the representative element of the set that x belongs to
    public int find(int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            return x;
        }
        if (parent.get(x) == x) {
            return x;
        }
        int root = find(parent.get(x));
        parent.put(x, root);
        return root;
    }

    // Merge the sets that x and y belong to
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent.put(rootX, rootY);
        }
    }
}

