package leetcode.Eweekly.W309;

import org.junit.Test;

public class B {
  @Test
  public void testSol(){

    System.out.println("is "   );
  }

  public int numberOfWays(int startPos, int endPos, int k) {
    int ans=0;
    for (int i = startPos; i < k; i++) {
      if(startPos==endPos) return ans%(1000000007);
      if(i>1)ans+=Math.pow(i,2);
    }
   
     return ans;
  }

}
