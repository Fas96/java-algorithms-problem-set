package leetcode.Y2023.daily.deasy;

public class Q2553SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) sb.append(num);
        int[] res = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) res[i] = sb.charAt(i) - '0';
        return res;


    }
}
