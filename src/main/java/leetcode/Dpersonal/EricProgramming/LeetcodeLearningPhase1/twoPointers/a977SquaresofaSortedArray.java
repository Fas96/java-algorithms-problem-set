package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.twoPointers;

import java.util.Arrays;
import org.junit.Test;

public class a977SquaresofaSortedArray {
  public int[] sortedSquares(int[] nums) {
    nums=Arrays.stream(nums).map(e->e*e).toArray();
    Arrays.sort(nums);
    return nums;
  }
  public int[] sortedSquaresTP(int[] nums) {
    int left=0,n=nums.length,right=n-1,index=n-1;
    int[] res=new int[n];
    while (0<=index){
      int leftNum=nums[left]*nums[left];
      int rightNum=nums[right]*nums[right];
      if(leftNum<rightNum){
        res[index--]=rightNum;
        right--;
      }else{
        left++;
        res[index--]=leftNum;
      }

    }
    return res;

  }
  @Test
  public void sortedSquaresTest(){
    System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
  }
}
