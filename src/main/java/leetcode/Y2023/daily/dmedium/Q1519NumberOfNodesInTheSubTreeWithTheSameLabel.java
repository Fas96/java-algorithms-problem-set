package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q1519NumberOfNodesInTheSubTreeWithTheSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        return null;
    }




    //n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
    @Test
    public void test() {
        int[] res = countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");

        System.out.println(Arrays.toString(res));
        System.out.println("done");
    }

}
