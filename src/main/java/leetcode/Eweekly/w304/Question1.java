package leetcode.Eweekly.w304;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.OptionalInt;
import org.junit.Test;



public class Question1 {

  @Test
  public  void sol_test(){
    assertEquals(0,minimumOperations(new int[]{0}));
  }

  public int minimumOperations(int[] nums) {
    int res=0;
    while (!allIsZero(nums)){
      int min = findMin(nums);
      System.out.println(Arrays.toString(nums));
      res+=1;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i]>0){
          nums[i]=nums[i]-min;
        }
      }
    }
    return  res;
  }

  public int findMin(int [] arrs){
    return   Arrays.stream(Arrays.stream(arrs).toArray()).filter(e->e>0).min().getAsInt();
  }

  boolean allIsZero(int [] arrs){
    boolean ans=true;
    for (int num : arrs) {
      if(num!=0){
        ans=false;
        break;
      }
    }
    return ans;
  }
}
