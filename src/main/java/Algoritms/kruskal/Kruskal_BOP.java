package Algoritms.kruskal;

import java.util.List;

public class Kruskal_BOP {
    int parent[];
    int rank[];

    public Kruskal_BOP(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

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

    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }
    int V, E;
    Edge edge[];

    public Kruskal_BOP(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge(0, 0, 0);
    }
}
