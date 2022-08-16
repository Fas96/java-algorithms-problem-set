package leetcode.Eweekly.w305;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class q4 {

  @Test
  public  void sol_test(){
    assertEquals(2,arithmeticTriplets(new int[]{0,1,4,6,7,10},   3));
  }
  public int arithmeticTriplets(int[] nums, int diff) {
    int res=0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          if((i<j && j<k)&& (nums[j] - nums[i] == diff)&& nums[k] - nums[j] == diff){
           res++;
          }

        }
      }
    }
    return  res;

  }

}
