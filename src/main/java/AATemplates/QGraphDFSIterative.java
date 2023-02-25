package AATemplates;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class QGraphDFSIterative {
    public int fn(int[][] graph) {
        //TODO: change this to your starting node
        //MANUAL INPUT for the START_NODE
        final int START_NODE = 0;

        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(START_NODE);
        seen.add(START_NODE);
        int ans = 0;

        while (!stack.empty()) {
            int node = stack.pop();
            // do some logic
            for (int neighbor: graph[node]) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }

        return ans;
    }
}
