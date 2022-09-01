package leetcode.Bmedium.a659SplitArrayintoConsecutiveSubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.Test;

public class a659SplitArrayintoConsecutiveSubsequences {

@Test
public void isPossibleTest(){
  System.out.println(isPossibleLarry(new int[]{1,2,3,3,4,5}));
}
  public boolean isPossible(int[] nums) {
  boolean isPossible=false;
  List<Integer> list1= new ArrayList<>();
  List<Integer> list2= new ArrayList<>();
  int N=nums.length;
    for (int i = 1; i < N; i++) {

      if(nums[i]!=nums[i-1]){
        list1.add(nums[i]);
      }
      if(nums[N-i-1]!=nums[N-i]){
        list2.add(nums[N-i-1]);
      }
      if(Objects.equals(list1.get(0), list2.get(0))){
        break;
      }
    }
    System.out.println(list1);
    System.out.println(list2);

  return  isPossible;

  }

  public boolean isPossibleLarry(int[] nums) {
  Map<Integer,Integer> ones= new HashMap<>();
  Map<Integer,Integer> twos= new HashMap<>();
  Map<Integer,Integer> threes= new HashMap<>();
    for (int num : nums) {
      if(ones.getOrDefault(num-1,0)>0){
       ones.put(num-1, ones.get(num-1)-1);
       twos.put(num, ones.getOrDefault(num,0)+1);
       continue;
      }
      if(twos.getOrDefault(num-1,0)>0){
        twos.put(num-1, twos.get(num-1)-1);
        threes.put(num, threes.getOrDefault(num,0)+1);
        continue;
      }
      if(threes.getOrDefault(num-1,0)>0){
        threes.put(num-1, threes.get(num-1)-1);
        threes.put(num, threes.getOrDefault(num,0)+1);
        continue;
      }

      ones.merge(num, 1,Integer::sum);

    }
    if (ones.size()>0 && twos.size()>0)
      return false;

  return true;
  }
  public boolean isPossiblea(int[] nums) {
    Map<Integer,Integer> mapExisting = new HashMap<>();
    Map<Integer,Integer> freq = new HashMap<>();

    for(int i : nums){
      freq.merge(i, 1,Integer::sum);
    }
  
    for(int i : nums){
      if(freq.get(i) == 0) continue;
      if(mapExisting.getOrDefault(i,0) > 0){
        mapExisting.put(i, mapExisting.get(i)-1);
        mapExisting.put(i+1, mapExisting.getOrDefault(i+1, 0)+1);
        freq.put(i, freq.get(i)-1);
      }
      else if(freq.getOrDefault(i, 0) > 0 && freq.getOrDefault(i+1, 0) > 0 && freq.getOrDefault(i+2, 0) > 0){
        freq.put(i, freq.get(i)-1);
        freq.put(i+1, freq.get(i+1)-1);
        freq.put(i+2, freq.get(i+2)-1);
        mapExisting.put(i+3, mapExisting.getOrDefault(i+3,0)+1);
      }
      else{
        return false;
      }

    }

    return true;
  }
}
