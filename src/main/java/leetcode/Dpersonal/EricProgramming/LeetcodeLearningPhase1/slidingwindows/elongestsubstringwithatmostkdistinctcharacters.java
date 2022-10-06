package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.slidingwindows;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class elongestsubstringwithatmostkdistinctcharacters {
    public int lengthOfLongestSubstringKDistinctCharacters(String s,int k) {
        if(  k==0) return 0;
        int L=0,R=0,maxLen=0,N=s.length();
        char[] arr=s.toCharArray();
        Map<Character,Integer> hm= new HashMap<>();
        while (R<N){
            hm.merge(arr[R],1, (oldValue, newValue) -> oldValue + 1);

            while (hm.size()>k){
                hm.merge(arr[L],hm.get(arr[L]),(oldValue, newValue) -> oldValue -1);
                if(hm.get(arr[L])==0)hm.remove(arr[L]);
                L+=1;
            }
            maxLen=Math.max(maxLen,R-L+1);
            R++;
        }

        return  maxLen;
    }

    @Test
    public void  lengthOfLongestSubstringTest() {
        System.out.println(lengthOfLongestSubstringKDistinctCharacters("eceba",2));
    }
}
