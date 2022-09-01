package leetcode.Chard.c239SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;

public class c239SlidingWindowMaximum {
  @Test
  public void test_maxSlidingWindow(){
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
  }
  //TLE
  public int[] maxSlidingWindow(int[] nums, int k) {

    int[] res=new int[nums.length];
    int idx=0;

    for (int i = 0; i < nums.length-k+1; i++) {
      int[] subarray = new int[k];
      System.arraycopy(nums, i, subarray, 0, k);
      res[idx++]= Arrays.stream(subarray).max().getAsInt();
    }
    int[] ACres=new int[idx];
    for (int i = 0; i < idx; i++) {
      ACres[i]=res[i];
    }
    return ACres;
  }
}

