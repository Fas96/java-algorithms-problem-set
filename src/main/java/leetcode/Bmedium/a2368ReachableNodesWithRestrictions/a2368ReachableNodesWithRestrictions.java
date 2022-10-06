package leetcode.Bmedium.a2368ReachableNodesWithRestrictions;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class a2368ReachableNodesWithRestrictions {
     

    @Test
    public void testreachableNodes(){
        assertEquals(4,reachableNodes(7,new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}},new int[]{4,5}));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        int root = 0;
        Set<Integer> blocked = new HashSet<>(IntStream.of(restricted).boxed().collect(Collectors.toSet()));
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while(!queue.isEmpty()){

            root = queue.poll();

            if(visited.contains(root)) continue;
            visited.add(root);
            if(!blocked.contains(root)) count++;

            for(int childVertex : graph.getOrDefault(root, new ArrayList<>())){
                if(blocked.contains(childVertex)) continue;
                queue.add(childVertex);
            }
        }
        return count;

    }
}
