package leetcode.Y2023.weekly.w329;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/*You are given a positive integer n. Each digit of n has a sign according to the following rules:

The most significant digit is assigned a positive sign.
Each other digit has an opposite sign to its adjacent digits.
Return the sum of all digits with their corresponding sign.
Input: n = 521
Output: 4
*/
public class Q6296AlternatingDigitSum {
    public int alternateDigitSum(int n) {


        Queue<Integer> q = new LinkedList<>();

        for (String s : String.valueOf(n).split("")) {
            q.add(Integer.parseInt(s));
        }
        if (q.isEmpty()) return 0;

        int answer = q.poll();
        int state = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (state == 1) {
                answer -= cur;
                state = 0;
            } else {
                answer += cur;
                state = 1;
            }

        }
        return answer;




    }
    @Test
    public void test() {
        System.out.println(alternateDigitSum(10));
    }
}
