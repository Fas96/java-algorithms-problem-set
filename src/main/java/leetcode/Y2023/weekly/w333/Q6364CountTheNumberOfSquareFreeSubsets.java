package leetcode.Y2023.weekly.w333;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
/*
* You are given a positive integer 0-indexed array nums.

A subset of the array nums is square-free if the product of its elements is a square-free integer.

A square-free integer is an integer that is divisible by no square number other than 1.

Return the number of square-free non-empty subsets of the array nums. Since the answer may be too large, return it modulo 109 + 7.

A non-empty subset of nums is an array that can be obtained by deleting some (possibly none but not all) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.
* */
public class Q6364CountTheNumberOfSquareFreeSubsets {
    private static final int mod = 1_000_000_007;

    private void add(int[] x, int y) {
        if ((x[0] += y) >= mod) x[0] -= mod;
    }

    public int squareFreeSubsets(int[] nums) {
        int[] p = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] f = new int[1 << 10];
        f[0] = 1;
        for (int x : nums) {
            int y = 0;
            for (int i = 0; i < 10; i += 1) {
                if (x % p[i] == 0) {
                    if (x / p[i] % p[i] == 0) {
                        y = -1;
                        break;
                    } else {
                        y |= 1 << i;
                    }
                }
            }
            if (y == -1) continue;
            if (y == 0) {
                for (int i = 0; i < f.length; i++) {
                    add(new int[]{f[i]}, f[i]);
                }
            } else {
                for (int i = (1 << 10) - 1; i > 0; i -= 1) {
                    if ((i & y) == y) add(new int[]{f[i]}, f[i ^ y]);
                }
            }
        }
        int ans = 0;
        for (int fi : f) add(new int[]{ans}, fi);
        if (ans == 0) ans = mod - 1;
        else ans = ans - 1;
        return ans;
    }

    private boolean isSquareFree(int product) {
        for (int i = 2; i * i <= product; i++) {
            if (product % (i * i) == 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        int[] nums = Ps.intArray("[[26,6,4,27,6,18]]")[0];
       assertEquals(squareFreeSubsets(nums), 3);
       nums=Ps.intArray("[[3,4,4,5]]")[0];
        assertEquals(squareFreeSubsets(nums), 3);
        nums=Ps.intArray("[[1]]")[0];
        assertEquals(squareFreeSubsets(nums), 3);
    }


}
