package leetcode.Bmedium.a743NetworkDelayTime;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class a743NetworkDelayTime {

  @Test
  public  void sol_test(){
    assertEquals(1,networkDelayTime(new int[][]{new int[]{1,2,1}},2,1));
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    if(times==null||times.length==0)return -1;

    Map<Integer, Map<Integer,Integer>> map= new HashMap<>();
    for (int i = 1; i <=n; i++) {
      map.put(i,new HashMap<>());
    }
    for (int[] time:times){
      map.get(time[0]).put(time[1],time[2]);
    }
    PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);

    pq.offer(new int[]{k,0});

    int [] dis= new int[n+1];
    Arrays.fill(dis,Integer.MAX_VALUE);

    int[]v=new int[n+1];

    dis[k]=0;

    while (!pq.isEmpty()){
      int[]node = pq.poll();
      if(v[node[0]]==1) continue;
      v[node[0]]=1;
      for (Map.Entry<Integer,Integer> entry:map.get(node[0]).entrySet()){
        if(entry.getValue()+node[1]<dis[entry.getKey()]){
          dis[entry.getKey()]=entry.getValue()+node[1];
        }
        pq.offer(new int[]{entry.getKey(),dis[entry.getKey()]});
      }
    }
    int res=0;
    for (int i = 1; i <= n; i++) {
      if(dis[i]==Integer.MAX_VALUE){
        return -1;
      }
      res=Math.max(res,dis[i]);
    }
    return res;

  }
}
