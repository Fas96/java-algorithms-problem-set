package leetcode.Bmedium.Q150EvaluateReversePolishNotation;

import java.util.Stack;

public class Q150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int n1 = stack.pop(), n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();

    }
}
