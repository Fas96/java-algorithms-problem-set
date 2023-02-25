package leetcode.Y2023.daily.deasy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1137NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        int T0 = 0, T1 = 1, T2 = 1,T3=0;

        for (int i = 3; i <=n; i++) {
            T3 = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = T3;
        }
        return T2;
    }
    @Test
    public void test() {
        int n = 4;
        int res = tribonacci(n);
         assertEquals(4, res);
         n=25;
         res = tribonacci(n);
         assertEquals(1389537, res);
         n=0;
         res = tribonacci(n);
         assertEquals(0, res);
    }
}
