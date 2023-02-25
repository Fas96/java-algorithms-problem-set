package leetcode.Y2023.daily.dmedium;

import lombok.ToString;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q904FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.merge(fruits[i], 1, Integer::sum);
            while (map.size() > 2) {
                int count = map.get(fruits[start]);
                if (count == 1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], count - 1);
                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }


        return max;

    }

    @ToString
    class Fruit {
        int type;
        int count;
        public Fruit(int type, int count) {
            this.type = type;
            this.count = count;
        }

    }

    @Test
    public void testtotalFruit() {
        int[] fruits = {5,1,4,1,4,2};
        int res = totalFruit(fruits);
        System.out.println(res);
    }

}
