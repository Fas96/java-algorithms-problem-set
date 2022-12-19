package Algoritms.kruskal;

import java.util.Arrays;
import java.util.List;

public class Kruskal {
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

        class Subset {
            int parent, rank;
        }

        int V, E;
        Edge edge[];

        public Kruskal(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge(0, 0, 0);
        }

        int find(Subset subsets[], int i) {
            if (subsets[i].parent != i)
                subsets[i].parent = find(subsets, subsets[i].parent);
            return subsets[i].parent;
        }

        void Union(Subset subsets[], int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);
            if (subsets[xroot].rank < subsets[yroot].rank)
                subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                subsets[yroot].parent = xroot;
            else {
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }

        int minCost(){
            Edge result[] = new Edge[V];
            int e = 0;
            int i = 0;
            for (i = 0; i < V; ++i)
                result[i] = new Edge(0, 0, 0);
            java.util.Arrays.sort(edge);
            Subset subsets[] = new Subset[V];
            for (i = 0; i < V; ++i)
                subsets[i] = new Subset();
            for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
            i = 0;
            while (e < V - 1) {
                Edge next_edge = new Edge(0, 0, 0);
                next_edge = edge[i++];
                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);
                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
            int minimumCost = 0;
            for (i = 0; i < e; ++i)
                minimumCost += result[i].weight;
            return minimumCost;
        }

       void KruskalMST() {
            Edge result[] = new Edge[V];
            int e = 0;
            int i = 0;
            for (i = 0; i < V; ++i)
                result[i] = new Edge(0, 0, 0);
            java.util.Arrays.sort(edge);
            Subset subsets[] = new Subset[V];
            for (i = 0; i < V; ++i)
                subsets[i] = new Subset();
            for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
            i = 0;
            while (e < V - 1) {
                Edge next_edge = new Edge(0, 0, 0);
                next_edge = edge[i++];
                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);
                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
            System.out.println("Following are the edges in " + "the constructed MST");
            int minimumCost = 0;
            for (i = 0; i < e; ++i) {
                System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
                minimumCost += result[i].weight;
            }
            System.out.println("Minimum Cost Spanning Tree " + minimumCost);
        }

        private class Solution {
        public int minCostConnectPoints(int[][] points) {
             int n = points.length;
                Kruskal graph = new Kruskal(n, n * (n - 1) / 2);
                int k = 0;
                for (int i = 0; i < n; i++) {
                 for (int j = i + 1; j < n; j++) {
                      graph.edge[k].src = i;
                      graph.edge[k].dest = j;
                      graph.edge[k].weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                      k++;
                 }
                }
                return graph.minCost();
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; t++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (t >= w && dp[u][t - w] != Integer.MAX_VALUE) {
                    dp[v][t] = Math.min(dp[v][t], dp[u][t - w] + passingFees[v]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int t = 1; t <= maxTime; t++) {
            ans = Math.min(ans, dp[n - 1][t]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

}


