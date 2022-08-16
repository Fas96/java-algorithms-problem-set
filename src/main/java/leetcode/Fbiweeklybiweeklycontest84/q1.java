package leetcode.Fbiweeklybiweeklycontest84;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class q1 {
  @Test
  public  void sol_test(){
    assertEquals(new int[]{1,4,3,3,1},mergeSimilarItems(new int[][]{{1,1},{4,5},{3,8}},new int[][]{{3,1},{1,5}}));
  }
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
      List<List<Integer>> res= new ArrayList<>();
      int[][] merge = new int[items1.length + items2.length][];

      System.arraycopy(items1, 0, merge, 0, items1.length);
      System.arraycopy(items2, 0, merge, items1.length, items2.length);

      HashMap<Integer,Integer> map= new HashMap<>();
      for (int[] one : merge) {
        System.out.println(Arrays.toString(one));
        map.put(one[0],map.getOrDefault(one[0],0) + one[1]);
      }
      System.out.println(map);
      for (Entry<Integer, Integer> one:   map.entrySet()) {
        List<Integer> list=new ArrayList<>();
        list.add(one.getKey());
        list.add(one.getValue());
        res.add(list);
      }
      res.stream().sorted(Comparator.comparingDouble(o -> o.get(0))).collect(Collectors.toList());
      System.out.println(res.stream().sorted(Comparator.comparingDouble(o -> o.get(0))).collect(Collectors.toList()) );


      return  res;
    }

}
