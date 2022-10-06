package leetcode.Chard.c2416SumofPrefixScoresofStrings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c2416SumofPrefixScoresofStrings {
    public int[] sumPrefixScores(String[] words) {
        int N=words.length;
        if(N<2)return new int[N];
        System.out.println(";;;;");
        int[] res= new int[N];
        Map<String,Integer> hm= new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <words[i].length(); j++) {
                hm.merge(words[i].substring(0,j+1),1,Integer::sum);
            }
            int sum=0;
            for (int j = 0; j < words[i].length(); j++) {
                sum+= hm.getOrDefault(words[i].substring(0,j+1),0);
            }
            res[i]=sum;
        }


        return res;
    }
    @Test
    public void testsumPrefixScores(){
        System.out.println(Arrays.toString(sumPrefixScores(new String[]{"abcd"})));
    }
}
