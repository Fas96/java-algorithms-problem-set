package leetcode.Bmedium.a473MatchstickstoSquare;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class a473MatchstickstoSquare {
  @Test
  public void canMakeSquare_test(){
    assertEquals(false,new Solution().makesquare(new int[]{3,3,3,3,4}));
  }

  public static void main(String[] args) {
    Solution s= new Solution();
    s.makesquare(new int[]{1,1,2,2,2});
  }

}

class Solution {
  private boolean dfs(int[] A,int pos,int[] target){
    if (pos== A.length) return true;
    for (int j = 0; j < 4; j++) {
      if(target[j]>=A[pos]){
        target[j]-= A[pos];
        if (dfs(A,pos+1,target)){
          return true;
        }
        target[j]+=A[pos];
      }
    }
    return false;
  };
  public boolean makesquare(int[] matchsticks) {
    if (matchsticks.length<4)return false;
    int sm=Arrays.stream(matchsticks).sum();
    Arrays.sort(matchsticks);
    int [] us=Arrays.stream(matchsticks).boxed()
        .sorted(Collections.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
    if (sm%4 !=0) return false;



    int[] target=new int[4];
    Arrays.fill(target, sm / 4);

    return dfs(us,0,target);

  }
}