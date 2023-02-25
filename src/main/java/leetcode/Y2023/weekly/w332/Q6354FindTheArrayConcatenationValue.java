package leetcode.Y2023.weekly.w332;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q6354FindTheArrayConcatenationValue {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) stack.push(num);

        while (!stack.isEmpty()) {
            if(stack.size() >= 2) {
                String a = stack.removeLast()+"";
                String b = stack.removeFirst()+"";
                System.out.println(a + b);
                ans += Integer.parseInt(a + b);
            }else{
                ans += stack.pop();
                break;
            }

        }

        return ans;

    }

}
