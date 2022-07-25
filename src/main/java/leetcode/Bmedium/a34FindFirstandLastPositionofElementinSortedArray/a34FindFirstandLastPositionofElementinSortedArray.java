package leetcode.Bmedium.a34FindFirstandLastPositionofElementinSortedArray;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class a34FindFirstandLastPositionofElementinSortedArray {
  @Test
  public void whenGiven_searchRangeTargetFound(){
    assertEquals(new int[]{3,4},searchRange(new int[]{5, 7, 7, 8, 8, 10},8));
  }
  public int[] searchRange(int[] nums, int target) {
   int[] res= {-1,-1};
   if(nums.length==0 || Arrays.stream(nums).noneMatch(e->e==target)){
     return  res;
   };

   int low=0,high=nums.length-1;
   while (low<high){
     int mid=(low+high)/2;
     int dum = nums[mid] < target ? (low = mid + 1) : (high = mid);
   }
   if(nums[low]!=target){
     return res;
   }
   res[0]=low;

   high=nums.length;
   while (low<high){
     int mid=(low+high+1)/2;
     int dum = nums[mid] > target ? (high = mid - 1) : (low = mid);
   }

    res[1]=low;
    System.out.println(Arrays.toString(res));
   return res;

  }

}
