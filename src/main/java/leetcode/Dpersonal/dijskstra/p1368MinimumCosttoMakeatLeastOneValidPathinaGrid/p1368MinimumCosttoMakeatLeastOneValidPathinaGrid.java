package leetcode.Dpersonal.dijskstra.p1368MinimumCosttoMakeatLeastOneValidPathinaGrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class p1368MinimumCosttoMakeatLeastOneValidPathinaGrid {
    public int minCost(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      //sort by cost
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

      boolean[][] visitedMN = new boolean[m][n];
      int endM = grid.length - 1, endN = grid[0].length - 1;

      //start at row 0,col 0, cost zero
      pq.offer(new int[]{0, 0, 0});

      while (!pq.isEmpty()) {
        int[] curColRowCost = pq.poll();
        int curCol = curColRowCost[0], curRow = curColRowCost[1], curCost = curColRowCost[2];
        visitedMN[curCol][curRow] = true;
        if (curCol == endM && curRow == endN) {
          return curCost;
        }
        if (curCol + 1 != m && !visitedMN[curRow][curCol + 1])
          pq.add(new int[]{curRow, curCol + 1, (grid[curRow][curCol] == 1 ? 0 : 1) + curCost});

        if (curCol - 1 != -1 && !visitedMN[curRow][curCol - 1])
          pq.add(new int[]{curRow, curCol - 1, (grid[curRow][curCol] == 2 ? 0 : 1) + curCost});

        if (curRow + 1 != n && !visitedMN[curRow + 1][curCol])
          pq.add(new int[]{curRow + 1, curCol, (grid[curRow][curCol] == 3 ? 0 : 1 )+ curCost});
        if (curRow - 1 != -1 && !visitedMN[curRow - 1][curCol])
          pq.add(new int[]{curRow - 1, curCol, (grid[curRow][curCol] == 4 ? 0 : 1) + curCost});

      }
      return 0;
    }
    @Test
  public void minCostTest(){
      System.out.println(minCost(new int[][]{{0,1,1,2}, {3,2,2,4},{5,1,1,6},{7,2,2,8}}));
    }

    private boolean isAtEnd(int[][]grid,int row,int col){
      return col == 0 || col == grid.length - 1 || row == grid.length - 1 || row == 0
          || row == grid[col].length - 1;
    }

}
