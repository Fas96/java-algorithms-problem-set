package Algoritms.UnionFind.code;

import java.util.List;

public class UnionFU_BOP {
    private int[] parent;
    private int[] rank;

    public UnionFU_BOP(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the representative element of the set that x belongs to
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    // Merge the sets that x and y belong to
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFU_BOP uf = new UnionFU_BOP(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.find(source) == uf.find(destination);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        UnionFU_BOP uf = new UnionFU_BOP(n);
        for (int i = 0; i < n; i++) {
            for (int j : rooms.get(i)) {
                uf.union(i, j);
            }
        }
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != uf.find(0)) {
                return false;
            }
        }
        return true;

    }

}
