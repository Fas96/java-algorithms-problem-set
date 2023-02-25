package leetcode.Y2023.daily.dmedium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Q926FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        int flip0 = (int) s.chars().filter(c -> c == '0').count();
        if(flip0 == n) return 0;

        int flip1 = 0;
        int res = flip0;

        for(int i=0;i<n;i++) {
            if (s.charAt(i) == '0') flip0--;
            else flip1++;
            res = Math.min(res, flip0 + flip1);
        }
        return res;
    }
    @Test
    public void test() {
        int res = minFlipsMonoIncr("010110");
        // f1=1, f0=0
        // f1=0, f0=1
        // f1=1, f0=1
        // f1=2, f0=1
        // f1=1, f0=2
        // f1=2, f0=2
//        Assert.assertEquals(2, res);
//        res = minFlipsMonoIncr("00011000");
//        Assert.assertEquals(2, res);
//        //00110
//        res = minFlipsMonoIncr("00110");
        //f1=1, f0=0
        //f1=1, f0=0
        //f1=0, f0=1
        //f1=0, f0=2
        //f1=1, f0=2
        Assert.assertEquals(2, res);
    }
}
