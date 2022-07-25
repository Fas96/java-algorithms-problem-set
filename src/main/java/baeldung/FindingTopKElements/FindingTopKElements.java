package baeldung.FindingTopKElements;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class FindingTopKElements {
  @Test
  public void whenGivenListIntegers_findTopKPriorityQueueFound(){
    assertEquals(Arrays.asList(6,4),findTopKPriorityQueue(Arrays.asList(6,1,3,2,4),2));
  }

  //Brute-Force
  //O(n * k)
  public List findTopK(List input, int k) {
    List<Integer> array = new ArrayList<>(input);
    List<Integer> topKList = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      int maxIndex = 0;

      for (int j = 1; j < array.size(); j++) {
        if (array.get(j)>array.get(maxIndex)) {
          maxIndex = j;
        }
      }

      topKList.add(array.remove(maxIndex));
    }

    return topKList;
  }

  //Java Collections
  //O(n * log n)
  //the solution works only for an input array with distinct values
  //TreeSet  : Red-Black Tree data structure as a backbone
  public List<Integer> findTopKTreeSet(List<Integer> input, int k) {
    Set<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
    sortedSet.addAll(input);

    return sortedSet.stream().limit(k).collect(Collectors.toList());
  }

  //PriorityQueue
  //O(n * log k)
  public List<Integer> findTopKPriorityQueue(List<Integer> input, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    input.forEach(number -> {
      maxHeap.add(number);

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    });

    List<Integer> topKList = new ArrayList<>(maxHeap);
    Collections.reverse(topKList);

    return topKList;
  }


  //Selection Algorithm


}
