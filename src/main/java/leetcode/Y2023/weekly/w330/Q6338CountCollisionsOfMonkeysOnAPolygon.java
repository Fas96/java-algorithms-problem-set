package leetcode.Y2023.weekly.w330;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
*
* Each monkey moves simultaneously to a neighboring vertex. A neighboring vertex for a vertex i can be:

the vertex (i + 1) % n in the clockwise direction, or
the vertex (i - 1 + n) % n in the counter-clockwise direction.
*
* A collision happens if at least two monkeys reside on the same vertex after the movement.
*
* Return the number of ways the monkeys can move so that at least one collision happens. Since the answer may be very large, return it modulo 109 + 7.

Note that each monkey can only move once.
* */
public class Q6338CountCollisionsOfMonkeysOnAPolygon {
    public int monkeyMove(int n) {
        long mod = 1000000007;
        long pow = 2, res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= pow;
                res %= mod;
            }
            pow *= pow;
            pow %= mod;
            n >>= 1;
        }
        return (int)((res - 2 + mod) % mod);

    }

    @Test
    public void testmonkeyMove() {
        int n = 3;
        int res = monkeyMove(n);
//        assertEquals(6, res);
        n=4;
        res = monkeyMove(n);
        assertEquals(14, res);
    }
}
