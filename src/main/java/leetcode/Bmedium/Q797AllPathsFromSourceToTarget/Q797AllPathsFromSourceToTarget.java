package leetcode.Bmedium.Q797AllPathsFromSourceToTarget;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q797AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer,List<Integer>> edgeNConnections = new HashMap<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            edgeNConnections.computeIfAbsent(i, f -> new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                edgeNConnections.get(i).add(graph[i][j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, n - 1, edgeNConnections, path, res);
        System.out.println(edgeNConnections);

        return res;
    }

    private void dfs(int i, int nM1, HashMap<Integer, List<Integer>> edgeNConnections, List<Integer> path, List<List<Integer>> res) {
        if (i == nM1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < edgeNConnections.get(i).size(); j++) {
            path.add(edgeNConnections.get(i).get(j));
            dfs(edgeNConnections.get(i).get(j), nM1, edgeNConnections, path, res);
            path.remove(path.size() - 1);
        }

    }

    @Test
    public void givenGraph_whenFindAllPathsFromSourceToTarget_thenCorrect() {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));

    }
}
