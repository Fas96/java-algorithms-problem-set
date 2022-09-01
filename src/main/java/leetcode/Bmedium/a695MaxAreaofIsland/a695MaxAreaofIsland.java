package leetcode.Bmedium.a695MaxAreaofIsland;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class a695MaxAreaofIsland {
  @Test
  public void maxAreaOfIsland_Test(){
    assertEquals(6,maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
    {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
  }

//  https://leetcode.com/problems/max-area-of-island/discuss/186891/Java.-BFSDFSUnion-Find.
  public int maxAreaOfIsland(int[][] grid) {
    int col= grid.length-1;
    int row= grid[0].length-1;

    int max=0;
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        if(grid[i][j]>0){
          max=Math.max(max,dfs(grid,i,j));
        }


      }
    }

    return max;
  }
  private int dfs(int[][]grid,int i,int j){

    if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
      grid[i][j] = 0;
      return 1 + dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
    }

    return 0;
  }
}
