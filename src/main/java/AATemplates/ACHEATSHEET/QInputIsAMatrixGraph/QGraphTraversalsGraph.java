package AATemplates.ACHEATSHEET.QInputIsAMatrixGraph;

import java.util.*;

public class QGraphTraversalsGraph {
    void dfs(Map<Integer, List<Integer>> graph, int cur, Set<Integer> visited) {
        if (visited.contains(cur)) return;
        visited.add(cur);
        System.out.print(cur + " ");
        for (int next : graph.get(cur)) {
            dfs(graph, next, visited);
        }
    }

    void bfs(Map<Integer, List<Integer>> graph, int node) {
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.addLast(node);
        visited.add(node);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            System.out.print(cur + " ");
            for (int next : graph.get(cur)) {
                if (visited.contains(next)) continue;
                q.addLast(next);
                visited.add(next);
            }
        }
    }
}
