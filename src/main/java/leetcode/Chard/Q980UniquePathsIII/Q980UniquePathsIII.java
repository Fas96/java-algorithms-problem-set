package leetcode.Chard.Q980UniquePathsIII;

import org.junit.Test;

public class Q980UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int pathZeros = 0;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    pathZeros++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, pathZeros);

    }

    private int dfs(int[][] grid, int x, int y, int zeros) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return zeros == -1 ? 1 : 0;
        }
        grid[x][y] = -1;
        int res = dfs(grid, x + 1, y, zeros - 1) + dfs(grid, x - 1, y, zeros - 1) + dfs(grid, x, y + 1, zeros - 1) + dfs(grid, x, y - 1, zeros - 1);
        grid[x][y] = 0;
        return res;
    }


    @Test
    public void givenGrid_whenFindUniquePaths_thenCorrect() {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(uniquePathsIII(grid));
    }
}
