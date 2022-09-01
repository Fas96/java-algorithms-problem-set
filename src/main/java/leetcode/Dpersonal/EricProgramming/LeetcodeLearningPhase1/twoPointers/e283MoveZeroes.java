package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.twoPointers;

import java.util.Arrays;
import org.junit.Test;

public class e283MoveZeroes {
  public void moveZeroes(int[] nums) {
    int L=0,R=1,N=nums.length;
    while (R<N){
      if(nums[L]!=0 ){L++;R++;
      } else if (nums[R]==0) {
        R++;
      }else {
        swap(nums,L,R);
      }
    }
  }
  private void swap (int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  @Test
  public void testMoveZeros(){
     moveZeroes(new int[]{0,1,0,3,12});
  }
}
