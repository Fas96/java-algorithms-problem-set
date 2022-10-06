package leetcode.Eweekly.W309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class C {

  @Test
  public void testSol() {
    System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
  }

  public int longestNiceSubarray(int[] nums) {
    int N = nums.length;
    int ans=Integer.MIN_VALUE;
    Set<List<Integer>> tes= new LinkedHashSet<>();
    List<Integer> collect= new ArrayList<>();
    for (int i : nums) {
      collect.add(i);
    }
    for (int i = 0; i < N; i++) {
      for (int j = i+1; j < N; j++) {
        List<Integer> subList = collect.subList(i, j);

        if(subList.size()>1){
          int NN=subList.size();
          int cnt=0;
          for (int k = i; k <= NN; k++) {
            for (int l = k+1; l <=NN; l++) {

              if((nums[k]&nums[l])==0)cnt++;
            }
          }
          if(NN==cnt){
            ans=Math.max(ans,NN);
          }
        }
      }
    }




    return ans==Integer.MIN_VALUE?1:ans;


  }
}
