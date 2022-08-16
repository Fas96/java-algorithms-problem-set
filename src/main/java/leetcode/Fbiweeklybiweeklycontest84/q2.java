package leetcode.Fbiweeklybiweeklycontest84;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class q2 {


  @Test
  public  void sol_test(){
    assertEquals("faaas","fas");
  }


    public long countBadPairs(int[] nums) {
     long res=0;
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if(i < j && j - i != nums[j] - nums[i])res++;
        }
      }
         return res;
    }
  public long countBadPairsB(int[] nums) {
    int n = nums.length;
    int[] a = new int[n];
    for(int i = 0;i < n;i++){
      a[i] = nums[i] - i;
    }
    Arrays.sort(a);
    long ans = 0;
    for(int i = 0;i < n;){
      int j = i;
      while(i < n && a[i] == a[j])i++;

      ans += (long)(i-j)*(i-j-1)/2;
    }
    return (long)n*(n-1)/2-ans;
  }

}
