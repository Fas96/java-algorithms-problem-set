package leetcode.Y2023.daily.dmedium;

import java.util.*;

public class Q2477MinimumFuelCostToReportToTheCapital {
    private class Edge {
        public int from;
        public int to;
        public int capacity;

        public Edge(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", capacity=" + capacity +
                    '}';
        }
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Edge>[] graph= buildGraph(roads,n);
        long answer = 0;

        for (int i = 0; i < n; i++) {
         int idxSz= graph[i].size();
            for (Edge e : graph[i]) {
                e.capacity= seats ;
            }
        }
        Deque<Edge> q = new ArrayDeque<>();
        Set<Edge> seen = new HashSet<>();
        q.add(new Edge(0,0,seats));
        seen.add(new Edge(0,0,seats));


        while(!q.isEmpty()){
            Edge edge = q.poll();
            int from = edge.from;
            int to = edge.to;
            int capacity = edge.capacity;
            for(Edge next : graph[from]){
                if(seen.contains(next)) continue;
                if(next.capacity < capacity) continue;
                if(next.to == to) continue;
               answer=Math.max(answer,next.capacity-capacity);
                q.add(next);
                seen.add(next);
            }
        }

        return answer;

    }

    private List[] buildGraph(int[][]  roads,int n) {
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            graph[from].add(new Edge(from, to,0));
            graph[to].add(new Edge(to, from,0));
        }


        return graph;
    }
}
