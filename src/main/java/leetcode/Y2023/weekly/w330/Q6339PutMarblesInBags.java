package leetcode.Y2023.weekly.w330;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
*
* You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble. You are also given the integer k.

Divide the marbles into the k bags according to the following rules:

No bag is empty.
If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.
If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].
The score after distributing the marbles is the sum of the costs of all the k bags.

Return the difference between the maximum and minimum scores among marble distributions.
* */
public class Q6339PutMarblesInBags {

    public long putMarbles(int[] weights, int k) {
        List<Integer> sort = new ArrayList<>();
        for (int i = 1; i < weights.length; i++) {
            sort.add(weights[i - 1] + weights[i]);
        }
        Collections.sort(sort);
        long min = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += sort.get(i);
            max += sort.get(sort.size() - 1 - i);
        }
        return max - min;
    }


    @Test
    public void testputMarbles() {
        int[] weights = {1,3,5,1};
        int k = 2;
        long res = putMarbles(weights, k);
        assertEquals(4, res);
        //Input: weights = [1, 3], k = 2
        //Output: 0
        weights = new int[]{1,3};
        k = 2;
        res = putMarbles(weights, k);
        assertEquals(0, res);
    }
}
