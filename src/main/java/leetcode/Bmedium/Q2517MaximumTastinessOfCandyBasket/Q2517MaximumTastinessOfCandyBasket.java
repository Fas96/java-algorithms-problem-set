package leetcode.Bmedium.Q2517MaximumTastinessOfCandyBasket;

import java.util.Arrays;

public class Q2517MaximumTastinessOfCandyBasket {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int low=1;
        int high=price[n-1]-price[0];
        while (low <= high) {
            int mid = (high + low) /2;

            if (tasty(price, k, mid)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;

    }

    private boolean tasty(int[] price, int k, int mid) {
        int value = price[0] + mid;
        k--;
        for (int i = 1; i < price.length && k > 0; i++) {
            if (price[i] >= value){
                value = price[i] + mid;
                k--;
            }
        }
        return k == 0;
    }

}
