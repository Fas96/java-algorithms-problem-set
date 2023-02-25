package AATemplates;

import java.util.HashSet;
import java.util.Set;

public class QGraphDFSRecursive {
    //TODO: change this to your starting node
    //MANUAL INPUT for the START_NODE
    private static final int START_NODE = 0;

    Set<Integer> seen = new HashSet<>();

    public int fn(int[][] graph) {
        seen.add(START_NODE);
        return dfs(START_NODE, graph);
    }

    public int dfs(int node, int[][] graph) {
        int ans = 0;
        // do some logic
        for (int neighbor: graph[node]) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                ans += dfs(neighbor, graph);
            }
        }

        return ans;
    }
}
