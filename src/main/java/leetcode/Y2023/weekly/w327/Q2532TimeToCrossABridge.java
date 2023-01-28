package leetcode.Y2023.weekly.w327;

import java.util.PriorityQueue;

public class Q2532TimeToCrossABridge {
        public int findCrossingTime(int n, int k, int[][] times) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(10000, (x, y) -> {
                if(x[0] != y[0])return x[0] - y[0];
                return 0;
            });
            PriorityQueue<int[]> pqx = new PriorityQueue<>(10000, (x, y) -> {
                if(x[1] != y[1])return -(x[1] - y[1]);
                if (x[3] + x[5] != y[3] + y[5])return -((x[3]+x[5]) - (y[3]+y[5]));
                if(x[2] != y[2])return -(x[2] - y[2]);
                return 0;
            });
            int p = 0;
            for(int[] t : times){
                // time lr ind t
                pq.add(new int[]{0, 0, p++, t[0], t[1], t[2], t[3]});
            }
            int time = 0;
            int np = n;
            while(true){
                if(pqx.isEmpty() && pq.peek()[0] > time){
                    time = pq.peek()[0];
                }
                while(!pq.isEmpty() && pq.peek()[0] <= time){
                    pqx.add(pq.poll());
                }
                int[] cur = pqx.poll();
//				tr(cur, time);
                if(cur[1] == 0 && np == 0)continue;
                int ntime = 0;
                if(cur[1] == 0){
                    np--;
                    cur[1] = 1;
                    ntime = time + cur[3];
                    cur[0] = time + cur[3] + cur[4];
                }else{
                    n--;
                    if(n == 0)return time + cur[5];
                    cur[1] = 0;
                    ntime = time + cur[5];
                    cur[0] = time + cur[5] + cur[6];
                }
                time = ntime;
                pq.add(cur);
            }

    }
}
