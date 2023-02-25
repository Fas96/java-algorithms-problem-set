package leetcode.Y2023.personal.bsearch;

public class Q1011CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int l=0, r=0;

        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }
        while (l < r){
            int mid = l + (r - l) / 2;
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if (need > days) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
