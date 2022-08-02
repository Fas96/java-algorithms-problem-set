package leetcode.Bmedium.a378KthSmallestElementinaSortedMatrix;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class a378KthSmallestElementinaSortedMatrixTest {

  @Test
  public void testKthSmallest() {
    assertEquals(1, (new a378KthSmallestElementinaSortedMatrix()).kthSmallest(
        new int[][]{new int[]{1, 2, 3, 4}}, 1));
  }


  @Test
  @Ignore("TODO: Complete this test")
  public void testKthSmallest2() {
    (new a378KthSmallestElementinaSortedMatrix()).kthSmallest(new int[][]{new int[]{}}, 1);
  }
}

