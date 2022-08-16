package leetcode.Fbiweeklybiweeklycontest84;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class q4 {


  @Test
  public  void sol_test(){
    assertEquals("faaas","fas");
  }
  private  boolean isSortedArray(int[] array, int n){
    if(n == 1 || n == 0) return true;
    return array[n-2] <= array[n-1] && isSortedArray(array, n-1);
  }
  public long minimumReplacement(int[] nums) {

    if(isSortedArray(nums,nums.length))return 0;
    return Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().mapToInt(i -> i.intValue()).sum()- Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() ;

  }

  public long minimumReplacementA(int[] nums) {
    int last = nums[nums.length-1];
    long ans = 0;
    for(int i = nums.length-2;i >= 0;i--){
      int v = nums[i];
      if(v % last == 0){
        ans += v/last - 1;
      }else if(v < last){
        last = v;
      }else{
        int div = (v+last-1)/last;
        ans += div - 1;
        last = v / div;
      }
    }
    return ans;
  }
}
