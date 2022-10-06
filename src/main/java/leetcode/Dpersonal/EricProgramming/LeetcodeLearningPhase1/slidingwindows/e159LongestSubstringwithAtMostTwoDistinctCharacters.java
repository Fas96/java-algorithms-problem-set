package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class e159LongestSubstringwithAtMostTwoDistinctCharacters {
  private int lengthOfLongestSubstringTwoDistinct(String str){

    char[] arrs=str.toCharArray();
    int n=arrs.length ;
    if(str.length()<3)return str.length();

    int L=0,R=0,maxLen=Integer.MIN_VALUE;
    Map<Character,Integer> hm= new HashMap<>();

    while (R<n){
      hm.put(arrs[R],hm.getOrDefault(arrs[R],0)+1);
      while (hm.size()>2){
        hm.put(arrs[L],hm.getOrDefault(arrs[L],0)-1);
        if(hm.getOrDefault(arrs[L],0)==0){
          hm.remove(arrs[L]);
        }
        L++;
      }
      maxLen=Math.max(maxLen,R-L+1);
      R++;
    }

    return maxLen;

  }

}
