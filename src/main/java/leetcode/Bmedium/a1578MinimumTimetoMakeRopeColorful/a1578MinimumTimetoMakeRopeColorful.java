package leetcode.Bmedium.a1578MinimumTimetoMakeRopeColorful;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class a1578MinimumTimetoMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        char[] cA=colors.toCharArray();
        int ans=0,L=0,R=1,N=cA.length;


        while (R<N){
            if(cA[L]!=cA[R]){
                L=R;
                R+=1;
                continue;
            }
            if(neededTime[L] <= neededTime[R]){
                ans += neededTime[L];
                L = R; R++;
            }

            else if(neededTime[L] > neededTime[R]){
                ans += neededTime[R];
                R++;
            }

        }

        return ans;


    }
    @Test
    public void testminCost(){
        assertEquals(26,minCost("aaabbbabbbb",new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }
}
