package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.twoPointers;

import java.util.Arrays;
import org.junit.Test;

public class e26RemoveDuplicatesfromSortedArray {
  public int removeDuplicates(int[] nums) {
    int L=0,R=1;
    while (R<nums.length){


     if (nums[L]==nums[R]) {
        R++;
      }
      if(nums[L]!=nums[R]) {
        L++;
        swap(nums, L, R);
        R++;
      }
      System.out.println(Arrays.toString(nums));
    }
    return L+1;
  }
  private void swap (int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  @Test
  public void removeDuplicatesTest(){
    System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
  }

}
