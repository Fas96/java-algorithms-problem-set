package leetcode.Bmedium.a1338ReduceArraySizetoTheHalf;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public class a1338ReduceArraySizetoTheHalf {

  public static <K, V extends Comparable<V>> Map.Entry<K, V> getMaxEntryInMapBasedOnValue(Map<K, V> map) {
    Map.Entry<K, V> entryWithMaxValue = null;
    for (Map.Entry<K, V> currentEntry :
        map.entrySet()) {
      if (entryWithMaxValue == null || currentEntry.getValue().compareTo(entryWithMaxValue.getValue()) > 0) {
        entryWithMaxValue = currentEntry;
      }
    }
    return entryWithMaxValue;
  }

  @Test
  public void minSetSizeTest() {
   assertEquals(5,minSetSize(new int[]{9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19}));
  }



  public int minSetSize(int[] arr) {
    if(Arrays.stream(arr).boxed().collect(Collectors.toSet()).size()==1)
      return 1;
    int res = 0,sum = 0;
    Map<Integer,Integer> freq= new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      freq.merge(arr[i],1,Integer::sum);
    }
    Map<Integer, Long> freqmap = Arrays.stream(arr).boxed().collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().sorted(comparingByValue()).
        collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    while (!freqmap.isEmpty())
    {
      Entry<Integer, Long> basedOnValue = getMaxEntryInMapBasedOnValue(freqmap);
      sum+=basedOnValue.getValue();
      res+=1;
      if(freqmap.size()%2==0) {
        if (sum >= (arr.length + 1) / 2)
          return res;
      }else{
        if (sum >= (arr.length + 2) / 2)
          return res;
      }
    }
    return res;
  }
  public int minSetSizeWorking(int[] a) {
    Map<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      m.merge(a[i],1,Integer::sum);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>((c, d) -> d - c);
    for (int n : m.keySet()) pq.offer(m.get(n));


    int res = 0, sum = 0;
    while(!pq.isEmpty()){
      sum += pq.poll();
      res++;
      if (sum >= (a.length + 1) / 2) return res;
    }
    return 0;
  }

}
