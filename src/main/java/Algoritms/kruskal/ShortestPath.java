package Algoritms.kruskal;


public class ShortestPath {
    private class  Edge implements Comparable<Edge> {
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
     int getParent(int parent[], int i) {
         if (parent[i] == -1)
             return i;
         return getParent(parent, parent[i]);
     }
     void unionParent(int parent[], int x, int y) {
         x = getParent(parent, x);
         y = getParent(parent, y);
         if (x < y)
             parent[y] = x;
         else
             parent[x] = y;
     }

        int V, E;
        Edge edge[];
        public ShortestPath(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge(0, 0, 0);
        }


    static int minShortPath(int[][] edges,int v,int e) {
        ShortestPath graph = new ShortestPath(v, e);
        for (int i = 0; i < e; i++) {
            graph.edge[i].src = edges[i][0];
            graph.edge[i].dest = edges[i][1];
            graph.edge[i].weight = edges[i][2];
        }
        int parent[] = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = -1;
        }
        int sum = 0;
        for (int i = 0; i < e; i++) {
            int x = graph.getParent(parent, graph.edge[i].src);
            int y = graph.getParent(parent, graph.edge[i].dest);
            if (x != y) {
                graph.unionParent(parent, x, y);
                sum += graph.edge[i].weight;
            }
        }
        return sum;
    }

}
