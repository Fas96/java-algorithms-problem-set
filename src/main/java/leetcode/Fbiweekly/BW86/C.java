package leetcode.Fbiweekly.BW86;

import org.junit.Test;

public class C {
  @Test
  public void testSol(){
    System.out.println(1<<~2);
  }
  public int maximumRows(int[][] mat, int cols) {
    int m = mat.length, n = mat[0].length;
    int ans = 0;
    for(int i = 0;i < 1<<m;i++){
      int hit = 0;
      inner:
      for(int k = 0;k < n;k++){
        for(int j = 0;j < m;j++){
          if(i<<~j<0){
            if(mat[j][k] == 1){
              hit++;
              continue inner;
            }
          }
        }
      }
      if(hit <= cols){
        ans = Math.max(ans, Integer.bitCount(i));
      }
    }
    return ans;
  }

}
