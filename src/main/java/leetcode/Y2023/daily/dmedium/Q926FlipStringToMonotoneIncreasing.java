package leetcode.Y2023.daily.dmedium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class Q926FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int flip0 = 0;
        int flip1 = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                flip1 = Math.min(flip0, flip1) + 1;
            } else {
                flip1 = Math.min(flip0, flip1);
                flip0++;
            }
        }
        return Math.min(flip0, flip1);

    }
    @Test
    public void test() {
        int res = minFlipsMonoIncr("010110");
        Assert.assertEquals(2, res);
    }
}
