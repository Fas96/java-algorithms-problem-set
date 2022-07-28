package epi.smallestNonconstructibleValue;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class SmallestNonconstructibleValue {

  @Test
  public void maxNonconstructibleValue_test() {
    assertEquals(4, smallestNonconstructibleValue(Arrays.asList(1, 2)));
  }
  @Test
  public void rearrange_test() {
    assertEquals( Arrays.asList(1, 6, 2, 4, 3, 9, 7, 11, 10, 12, 8),rearrange(Arrays.asList(1,3,6, 2,4,7,9,10,11,12,8)));
  }
  @Test
  public void longestCommonPrefix_test() {
    assertEquals("ab",longestCommonPrefix(new String[]{"ab","af","abc","abf"}));
  }
  @Test
  public void areRotations_test() {
    assertEquals(true,areRotations("fas","sfa"));
  }

  private int smallestNonconstructibleValue(List<Integer> A) {
    Collections.sort(A);
    int maxConstructibleValue = 0;
    for (Integer a : A) {
      if (a > maxConstructibleValue + 1)
        break;
      maxConstructibleValue += a;
    }
    return maxConstructibleValue + 1;
  }

  public List<Integer>  rearrange(List<Integer> A) {
    for (int i = 1; i < A.size(); ++i) {
      if (((i % 2) == 0 && A.get(i - 1) < A.get(i)) || ((i % 2) != 0 && A.get(i - 1) > A.get(i))) {
        Collections.swap(A, i - 1, i);
      }

    }

    return A;
  }

  public String longestCommonPrefix(String[] a) {
    int size = a.length;

    /* if size is 0, return empty string */
    if (size == 0)
      return "";

    if (size == 1)
      return a[0];
    /* sort the array of strings */
    Arrays.sort(a);
    /* find the minimum length from first and last string */
    int end = Math.min(a[0].length(), a[size-1].length());

    /* find the common prefix between the first and last string */
    int i = 0;

    while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
      i++;

    String pre = a[0].substring(0, i);
    return pre;
  }
  private boolean areRotations(String str1, String str2)
  {
    // There lengths must be same and str2 must be
    // a substring of str1 concatenated with str1.
    return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
  }
}
