package leetcode.Eweekly.w317;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    @Test
    public void testW317Q3() {

    }
    public long makeIntegerBeautiful(long n, int target) {
        long pow = 1;
        long val = n;
        List<Long> list = new ArrayList<>();
        list.add(val);
        long lVal;

        long left;

        while (n > 0){
            left = n % 10;
            n /= 10;
            lVal = val - (val % pow);

            if (lVal < val)
                lVal += pow;

            list.add(lVal);
            pow *= 10;
        }

        lVal = val - (val % pow);

        if (lVal < val)
            lVal += pow;

        list.add(lVal);
        long result = Long.MAX_VALUE;

        for (long num : list){
            if (sum(num) <= target)
                result = Math.min(result, num - val);
        }

        return result;
    }

    private long sum(long val){
        long result = 0;

        while (val > 0){
            result += val % 10;
            val /= 10;
        }

        return result;
    }
}
