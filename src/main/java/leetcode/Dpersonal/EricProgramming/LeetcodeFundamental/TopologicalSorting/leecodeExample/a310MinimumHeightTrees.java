package leetcode.Dpersonal.EricProgramming.LeetcodeFundamental.TopologicalSorting.leecodeExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a310MinimumHeightTrees {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return Arrays.asList(0);

    List<Integer> ans = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] indeg = new int[n];
    for (int[] e : edges){
      map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
      map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
      indeg[e[0]]++;
      indeg[e[1]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++)
      if (indeg[i] == 1)
        queue.add(i);

    while(n > 2){
      int size = queue.size();
      n -= size;
      while (size-- > 0)
        for (int v : map.get(queue.poll()))
          if(--indeg[v] == 1)
            queue.offer(v);
    }

    while(!queue.isEmpty()) ans.add(queue.poll());
    //the remaining nodes will be in the queue, so add them to the ans list.

    return ans;
  }
}
