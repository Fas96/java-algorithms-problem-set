package leetcode.Y2023.weekly.w328;

import org.junit.Assert;
import org.junit.Test;
/*
* You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.

You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
*
* Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for for all row1i <= x <= row2i and col1i <= y <= col2i.
* */
public class Q6292IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (int[] query:queries){
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            for (int i=row1;i<=row2;i++){
                for (int j=col1;j<=col2;j++){
                    res[i][j]++;
                }
            }
        }
        return res;

    }

    @Test
    public void testrangeAddQueries() {
        int[][] queries = new int[][]{{1,1,2,2},{0,0,1,1}};
        int[][] res = rangeAddQueries(3, queries);

        Assert.assertEquals(new int[][]{{1,1,0},{1,2,1},{0,1,1}},res);


        int[][] queries1 = new int[][]{{0,0,1,1}};
        int[][] res1 = rangeAddQueries(2, queries1);

        Assert.assertEquals(new int[][]{{1,1},{1,1}},res1);
    }
}
