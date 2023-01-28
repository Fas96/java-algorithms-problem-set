package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Q57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        boolean isInserted = false;

        for(int[] x: intervals){
            if(isInserted){
                list.add(Arrays.asList(x[0],x[1]));
            } else if(end < x[0]){
                list.add(Arrays.asList(start, end));
                list.add(Arrays.asList(x[0],x[1]));
                isInserted = true;
            } else if ( start > x[1]) {
                list.add(Arrays.asList(x[0],x[1]));
            } else {
                start = Math.min(start, x[0]);
                end = Math.max(end, x[1]);
            }
        }

        if(!isInserted)
            list.add(Arrays.asList(start, end));

        int[][] ans = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] res = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        System.out.println(Arrays.deepToString(res));

        System.out.println("done");
//        intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
        int[][] res2 = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        System.out.println(Arrays.deepToString(res2));

    }
}
