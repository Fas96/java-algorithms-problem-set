package leetcode.Fbiweeklybiweeklycontest84;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class q3 {

  public long taskSchedulerIISA(int[] tasks, int space) {
    Map<Integer, Long> last = new HashMap<>();
    long day = 0;
    for(int t : tasks){
      if(last.containsKey(t)){
        long las = last.get(t);
        day = Math.max(day, las + space + 1);
      }
      last.put(t, day);
      day++;
    }
    return day;
  }


  @Test
  public  void sol_test(){
    assertEquals("faaas","fas");
  }
  int res = Integer.MAX_VALUE;

  public long taskSchedulerII(int[] tasks, int space) {
    Arrays.sort(tasks);
    dfs(tasks, tasks.length - 1, new int[0]);
    return res;
  }

  private void dfs(int[] jobs, int pos, int[] sum) {
    if (pos < 0) {
      res = Math.min(res, Arrays.stream(sum).max().getAsInt());
      return;
    }
    if (Arrays.stream(sum).max().getAsInt() >= res) return;           //prune1
    for (int i = 0; i < sum.length; i++) {
      if (i > 0 && sum[i] == sum[i - 1]) continue;                  //prune2
      sum[i] += jobs[pos];
      dfs(jobs, pos - 1, sum);
      sum[i] -= jobs[pos];
    }
  }

}
