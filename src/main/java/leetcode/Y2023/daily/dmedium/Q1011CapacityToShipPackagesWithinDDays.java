package leetcode.Y2023.daily.dmedium;

public class Q1011CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int leftWeight = 0, rightWeight = 0;
        for (int weight : weights) {
            leftWeight = Math.max(leftWeight, weight);
            rightWeight += weight;
        }
        System.out.println(leftWeight + " " + rightWeight);
        while (leftWeight < rightWeight) {
            int midWeight = leftWeight + (rightWeight - leftWeight) / 2;
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > midWeight) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if (need > days) {
                leftWeight = midWeight + 1;
            } else {
                rightWeight = midWeight;
            }
        }
        return leftWeight;

    }
}
