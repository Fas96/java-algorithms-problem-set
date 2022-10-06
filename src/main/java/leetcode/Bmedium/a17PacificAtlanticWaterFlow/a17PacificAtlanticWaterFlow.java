package leetcode.Bmedium.a17PacificAtlanticWaterFlow;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class a17PacificAtlanticWaterFlow {
    @Test
    public void test() {
        assertEquals(Arrays.asList(Arrays.asList(0,4),Arrays.asList(1,3),Arrays.asList(2,2),Arrays.asList(3,0),Arrays.asList(3,1),Arrays.asList(4,1)),pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }

    private  List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res= new ArrayList<>();
        if(heights.length==0) return res;
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights,i,0,pacific,Integer.MIN_VALUE);
            dfs(heights,i,n-1,atlantic,Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights,0,i,pacific,Integer.MIN_VALUE);
            dfs(heights,m-1,i,atlantic,Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j]&&atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(int[][] heights, int i, int i1, boolean[][] pacific, int minValue) {
        if(i<0||i>=heights.length||i1<0||i1>=heights[0].length||pacific[i][i1]||heights[i][i1]<minValue) return;
        pacific[i][i1]=true;
        for (int[] dir : dirs) {
            dfs(heights,i+dir[0],i1+dir[1],pacific,heights[i][i1]);
        }

    }


}
