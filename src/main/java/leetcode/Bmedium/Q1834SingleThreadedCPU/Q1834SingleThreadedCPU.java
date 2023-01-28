package leetcode.Bmedium.Q1834SingleThreadedCPU;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1834SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[] res = new int[n];
        int[][] newTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            newTasks[i][2] = i;
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];

        }
        Arrays.sort(newTasks, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int i = 0;
        int time = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                time = newTasks[i][0];
            }
            while (i < n && newTasks[i][0] <= time) {
                pq.add(newTasks[i++]);
            }
            int[] cur = pq.poll();
            res[cur[2]] = time + cur[1];
            time += cur[1];

        }
        return res;


    }
}
