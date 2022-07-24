package epi.PrimitiveTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SwapBits {

  @Test
  public void bitSwaps_Test() {
    assertEquals(6, 6 & (16 - 1));
    assertEquals(10, 11 & (11 - 1));
    assertEquals(16, 20 & (20 - 1));
    assertEquals(16, 16 & ~(16 - 1));
    assertEquals(1, 11 & ~(11 - 1));
    assertEquals(4, 20 & ~(20 - 1));
//    MSB LSB
  }

  //The time complexity is 0(1), independent of the word size.

  public static long swapBits(long x, int i, int j) {

// Extract the i-th and j-th bits, and see if they differ.
 if (((x>>>i)&1)!=((x>>>j)&1)){
// i-th and j-th bits differ. We will swap them by flipping their values.
// Select the bits to flip with bitMask. Since xAl = <9 when x = 1 and 1
// when x = (9, we can perform the flip XOR .
    long bitMask = (1L<<i)|(1L <<j);
    x^= bitMask;
  }
return x;
}
}
