package leetcode.Bmedium.a1329SorttheMatrixDiagonally;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import org.junit.Test;

public class a1329SorttheMatrixDiagonally {

  public int[][] diagonalSort(int[][] A) {
    int m = A.length, n = A[0].length;
    HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        d.putIfAbsent(i - j, new PriorityQueue<>());
        d.get(i - j).add(A[i][j]);
        System.out.print(i-j +",");
      }
      System.out.println(d);
      System.out.println(":::::");

    }
    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        A[i][j] = d.get(i - j).poll();
    return A;
  }

  @Test
  public void diagonalSortTest(){
    System.out.println(
        Arrays.deepToString(diagonalSort(new int[][]{{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}})));
  }
}
