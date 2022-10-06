package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.slidingwindows;

import org.junit.Test;

import java.util.Arrays;

public class e1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums,int k) {
        int maxLen=Integer.MIN_VALUE,N=nums.length,counter=0;
        if(N<2) return N;
        int L=0,R=0;
        while (R<N){
           if(nums[R]==0) counter++;
           while (counter>1){
               if(nums[L]==0) counter--;
               L++;
           }
           maxLen=Math.max(maxLen,R-L+1);
            R++;
        }



        return maxLen;
    }
    @Test
    public void findMaxConsecutiveOnes() {
        System.out.println(longestOnes(new int[]{ 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}
