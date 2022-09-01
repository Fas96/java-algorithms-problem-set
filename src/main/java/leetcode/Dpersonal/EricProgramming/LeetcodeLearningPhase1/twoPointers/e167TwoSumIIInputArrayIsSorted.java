package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.twoPointers;

import java.util.Arrays;
import org.junit.Test;

public class e167TwoSumIIInputArrayIsSorted {

  public int[] twoSum(int[] numbers, int target) {
    int startInc=0,endDec=0;
    int N=numbers.length;
    for (int i = 0; i <N ; i++) {
      if(numbers[startInc]+numbers[N-1-endDec]==target){
        System.out.println(numbers[startInc]+"||"+numbers[N-1-endDec]);
        return new int[]{startInc+1,N-1-endDec+1};
      } else if (numbers[startInc]+numbers[N-1-endDec]<target) {
        startInc++;
      } else if (numbers[startInc]+numbers[N-1-endDec]>target) {
        endDec++;
      }
    }
    return new int[]{};
  }

  @Test
  public void test_twoSum(){
    System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)));
  }
}
