package leetcode.Y2023.daily.dmedium;

import java.util.TreeMap;

public class Q2555MaximizeWinFromTwoSegments {
    public int maximizeWin(int[] prizePositions, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int counter = 1;

        int n = prizePositions.length;
        for (int i = 0; i < n; i++) {
            map.put(prizePositions[i], counter++);
        }
        System.out.println(map);

//        for (int i = 0, count = 0; i < prizePositions.length; i++) {
//            map.put(prizePositions[i], ++count);
//        }
        int max = 0, prev = 0;
        for (int i : map.keySet()) {
            max = Math.max(max,
                    prev + map.floorEntry(i + k).getValue() - (map.firstKey() < i ? map.lowerEntry(i).getValue() : 0));
            prev = Math.max(prev, map.get(i) - (map.firstKey() < i - k ? map.lowerEntry(i - k).getValue() : 0));
        }


        return max;


    }
}
