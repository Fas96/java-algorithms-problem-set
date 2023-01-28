package leetcode.Bmedium.Q1833MaximumIceCreamBars;

import java.util.Arrays;

public class Q1833MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        int numberOfIceCream = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins >= cost) {
                numberOfIceCream++;
                coins -= cost;
            } else {
                break;
            }
        }
        return numberOfIceCream;

    }
}
