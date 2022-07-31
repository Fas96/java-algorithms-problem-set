package leetcode.Eweekly.w304;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class Question2 {

//  10,6,12,7,3,5
//  3,5,6,7,10,12
  @Test
  public  void sol_test(){
//    assertEquals(new int[]{1,3},getItemsNotUsed( new int[]{1,2,3},new int[]{2}));
    assertEquals(1, maximumGroups(new int[]{8,8}));
  }
  @Test
  public void testing(){
    assertEquals(new int[]{2,2,2,2},tes(new int[]{2,2,2,2}));
  }


  //get the  max
  // and the numbers closer to the half of the minimum

  public int maximumGroups(int[] grades) {

    int ans=0;
    int length=grades.length;

    while (length > ans) {
      length -= ++ans;
    }

    return ans;
  }

  public  int[] removeElement(int[] arr, int index)
  {
    if (arr == null
        || index < 0
        || index >= arr.length) {

      return arr;
    }
    // return the resultant array
    return IntStream.range(0, arr.length)
        .filter(i -> i != index)
        .map(i -> arr[i])
        .toArray();
  }
  int[] tes(int...integers){
    return integers;
  }
  int getMax(int [] arrs){
    return Arrays.stream(Arrays.stream(arrs).toArray()).max().getAsInt();
  }
    int findIndex(int arr[], int t)
  {
    int len = arr.length;
    return IntStream.range(0, len)
        .filter(i -> t == arr[i])
        .findFirst() // first occurrence
        .orElse(-1); // No element found
  }
  int [] getItemsNotUsed(int[] a,int []b){
    int[] uniqueEntries = IntStream.concat(IntStream.of(a), IntStream.of(b)).filter(x -> !IntStream.of(a).anyMatch(y -> y == x) || !IntStream.of(b).anyMatch(z -> z == x)).toArray();
    return  uniqueEntries;
  };

}
