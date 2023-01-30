package leetcode.Y2023.weekly.w330;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/*
*
You are given a positive integer n, that is initially placed on a board. Every day, for 109 days, you perform the following procedure:

For each number x present on the board, find all numbers 1 <= i <= n such that x % i == 1.
Then, place those numbers on the board.
Return the number of distinct integers present on the board after 109 days have elapsed.

Note:

Once a number is placed on the board, it will remain on it until the end.
% stands for the modulo operation. For example, 14 % 3 is 2.
*
*
* Input: n = 5
Output: 4
Explanation: Initially, 5 is present on the board.
The next day, 2 and 4 will be added since 5 % 2 == 1 and 5 % 4 == 1.
After that day, 3 will be added to the board because 4 % 3 == 1.
At the end of a billion days, the distinct numbers on the board will be 2, 3, 4, and 5.
*
*
* Input: n = 3
Output: 2
Explanation:
Since 3 % 2 == 1, 2 will be added to the board.
After a billion days, the only two distinct numbers on the board are 2 and 3.
* */
public class Q6337CountDistinctNumbersOnBoard {
    public int distinctIntegers(int n) {
        if(n==1) return 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 1) {
                    temp.add(j);
                }
            }
            set.addAll(temp);
        }
        return set.size();



    }

    @Test
    public void testdistinctIntegers() {
        int n = 5;
        int res = distinctIntegers(n);
        assertEquals(4, res);
        n=3;
        res = distinctIntegers(n);
        assertEquals(2, res);
        n=4;
        res = distinctIntegers(n);
        assertEquals(3, res);
        n=2;
        res = distinctIntegers(n);
        assertEquals(1, res);
        n=1;
        res = distinctIntegers(n);
        assertEquals(1, res);
        n=0;
        res = distinctIntegers(n);
        assertEquals(0, res);
    }
}
