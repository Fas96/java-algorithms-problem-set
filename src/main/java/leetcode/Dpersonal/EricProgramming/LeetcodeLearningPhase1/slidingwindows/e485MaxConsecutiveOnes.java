package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.slidingwindows;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class e485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen=Integer.MIN_VALUE;
        int N=nums.length,counter=0;


        for (int i = 0; i < N; i++) {
            if(nums[i]==0)counter=0;
            counter++;
            maxLen=Math.max(counter,maxLen);
        }


        return maxLen;
    }
    public int findMaxConsecutiveOnesW(int[] nums) {
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
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
