package leetcode.Bmedium.aThreeSumProblem;

import java.util.Arrays;

public class aThreeSumSmaller {
  public int threeSumSmaller(int[]  nums,int target){
    Arrays.sort(nums);
    //
    int n=nums.length,Counter=0;
    for (int i = 0; i < n; i++) {
      int L=i+1,R=n-1;
      while (L<R){
        int curSum=nums[i]+nums[L]+nums[R];
        if(curSum<target){
          Counter+=(R-L);
        }else{
          R--;
        }
      }
    }
    return Counter;
  }
}
