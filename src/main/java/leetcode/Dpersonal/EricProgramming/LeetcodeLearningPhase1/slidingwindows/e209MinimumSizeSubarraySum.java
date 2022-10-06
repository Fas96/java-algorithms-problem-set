package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.slidingwindows;

public class e209MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int ans=Integer.MAX_VALUE;
    int L=0,R=0,N=nums.length, sum=0;
    while (R<N){
      sum+=nums[R];
      while (target<=sum){
        ans=Math.max(ans,R-L+1);
        sum-=nums[L++];
      }
      R++;
    }
    return ans;
  }
}
