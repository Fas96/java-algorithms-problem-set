package leetcode.Chard.c315CountofSmallerNumbersAfterSelf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76611/Short-Java-Binary-Index-Tree-BEAT-97.33-With-Detailed-Explanation
* 1, we should build an array with the length equals to the max element of the nums array as BIT.
2, To avoid minus value in the array, we should first add the (min+1) for every elements
(It may be out of range, where we can use long to build another array. But no such case in the test cases so far.)
*
* */
public class LCCSolution {

  @Test
  public void countSmaller_test(){
    assertEquals(Arrays.asList(2,1,1,0),counterSmaller(new int[]{5,2,6,1}));
  }
  public List<Integer> counterSmaller(int[] nums){
    List<Integer> res = new LinkedList<Integer>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    // find min value and minus min by each elements, plus 1 to avoid 0 element
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      min = (nums[i] < min) ? nums[i]:min;
    }
    int[] nums2 = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      nums2[i] = nums[i] - min + 1;
      max = Math.max(nums2[i],max);
    }
    int[] fenwickTree = new int[max+1];
    for (int i = nums2.length-1; i >= 0; i--) {
      res.add(0,getFenwickTree(nums2[i]-1,fenwickTree));
      updateFenwickTree(nums2[i],fenwickTree);
    }
    return res;
  }

  private int getFenwickTree(int i, int[] fwtree) {
    int num = 0;
    while (i > 0) {
      num +=fwtree[i];
      i -= i&(-i);
    }
    return num;
  }
  private void updateFenwickTree(int i, int[] fwtree) {
    while (i < fwtree.length) {
      fwtree[i] ++;
      i += i & (-i);
    }
  }

}
