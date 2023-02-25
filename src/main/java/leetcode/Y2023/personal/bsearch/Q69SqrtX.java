package leetcode.Y2023.personal.bsearch;

public class Q69SqrtX {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > x / mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;

    }
}
