package leetcode.Chard.c2421NumberofGoodPaths;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.nio.file.Files.find;
import static org.apache.commons.collections.ListUtils.union;
import static org.junit.Assert.assertEquals;

public class c2421NumberofGoodPaths {

    @Test
    public void numberOfGoodPathsTest() {
        assertEquals(7,numberOfGoodPaths(new int[]{1,1,2,2,3}, new int[][]{{0,1},{1,2},{2,3},{2,4}}));
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int ans=0;
        Map<Integer, LinkedList<Integer>> mp=  new HashMap<>();
        for (int[] edge : edges) {
            mp.putIfAbsent(edge[0],new LinkedList<>());
            mp.get(edge[0]).add(edge[1]);
            mp.putIfAbsent(edge[1],new LinkedList<>());
            mp.get(edge[1]).add(edge[0]);
        }
        //user map to perform dfs and discover all the paths












        return ans;
    }




    private void union(int[] parent, int a, int b) {
        int pa= find(parent,a);
        int pb= find(parent,b);
        if(pa!=pb){
            parent[pa]=pb;
        }
    }

    private int find(int[] parent, int a) {
        if(parent[a]==a)return a;
        return find(parent,parent[a]);
    }


}
