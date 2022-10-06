package leetcode.Fbiweekly.BW86;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class A {

  public boolean findSubarrays(int[] nums) {

    Set<Integer> u = new HashSet<>();
    for(int i = 0;i < nums.length-1;i++){
      u.add(nums[i] + nums[i+1]);
    }

     return u.size() != nums.length-1;
  }
  private void findSubsets(Set<List<Integer>> subset, List<Integer> nums, ArrayList<Integer> output, int index) {
    if (index == nums.size()) {
      subset.add(output);
      return;
    }

    findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    output.add(nums.get(index));
    findSubsets(subset, nums, new ArrayList<>(output), index + 1);
  }

  private List<List<Integer>> ofSize(List<Integer> collect, int chunkSize) {
    List<List<Integer>> result= new ArrayList<>();

    AtomicInteger counter = new AtomicInteger();

    for (int number : collect) {
      if (counter.getAndIncrement() % chunkSize == 0) {


          result.add(new ArrayList<>());


      }
      result.get(result.size() - 1).add(number);
    }

    return result;
  }
  @Test
  public void testSol(){
    System.out.println(findSubarrays(new int[]{4,2,4}));
  }

}
