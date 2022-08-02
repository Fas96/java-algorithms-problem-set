package leetcode.Bmedium.a378KthSmallestElementinaSortedMatrix;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class a378KthSmallestElementinaSortedMatrix {

  @Test
  public void givenMatrix_kthSmallest_ISFOUND(){
    assertEquals(13,kthSmallest(new int[][]{new int[]{1,5,9},new int[]{10,11,13},new int[]{12,13,15}},8));
  }
  List<Integer> flatten2DList(List<List<Integer>> listOfLists){
    return   listOfLists.stream().collect(ArrayList::new, List::addAll, List::addAll);
  }
  public int kthSmallest(int[][] matrix, int k) {
    List<List<Integer>> acc= new ArrayList<>();
    for (int[] l : matrix) {
      acc.add( Arrays.stream(l).boxed().collect(Collectors.toList()));
    }
    List<Integer> flatten2DList = flatten2DList(acc).stream().sorted().collect(Collectors.toList());

    System.out.println(flatten2DList);
    return  flatten2DList.get(k-1);
  }
}
