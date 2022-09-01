package leetcode.Bmedium.a869ReorderedPowerof2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class a869ReorderedPowerof2 {
  public boolean reorderedPowerOf2(int n) {
    int x = 1;
    char[] giveCharArr=(""+n).toCharArray();
    Arrays.sort(giveCharArr);

    for (int i = 1; i < 1000000000; ){
      char[] c = ("" + i).toCharArray();
      Arrays.sort(c);

      if((new String(c)).equals(new String(giveCharArr))) return true;
      i <<= 1;
    }

    return false;
  }
  @Test
  public void TestReorderedPowerOf2(){
    System.out.println(reorderedPowerOf2(1));
  }
}
