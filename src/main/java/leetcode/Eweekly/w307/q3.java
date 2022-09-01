package leetcode.Eweekly.w307;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class q3 {

  @Test
  public  void sol_test(){
    assertEquals(2,kSum(new int[]{2,4,-2},5));
  }

  public long kSum(int[] nums, int k) {
    if(k>nums.length){
      return Arrays.stream(nums).sum();
    }
    return  0;
  }
}
