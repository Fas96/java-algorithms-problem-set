package leetcode.Fbiweekly.bw91;

import org.junit.Test;

import java.util.Arrays;


public class Q2 {
    @Test
    public void testSol(){

    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        final int mod = 1000000007;
        long[] dp = new long[100001];
        dp[0] = 1;
        for(int i = 1;i <= 100000;i++){
            if(i-zero >= 0)dp[i] += dp[i-zero];
            if(i-one >= 0)dp[i] += dp[i-one];
            dp[i] %= mod;
        }
        long ans = 0;
        for(int i = low;i <= high;i++){
            ans += dp[i];
        }
        return (int)(ans%mod);

    }


}
