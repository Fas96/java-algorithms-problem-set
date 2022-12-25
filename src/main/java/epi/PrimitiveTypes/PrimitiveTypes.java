package epi.PrimitiveTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrimitiveTypes {
  @Test
  public void countBits_test(){
//    assertEquals(2,countBits(3));
//    assertEquals(1,8>>3);
//    assertEquals(-1,~0);
//    assertEquals(-4,-16>>2);
    assertEquals(13,15^2);
    assertEquals(64,Double.SIZE);
    assertEquals(32,Integer.SIZE);
    //generic numeric value of Character
    assertEquals(11,Character.getNumericValue((int)'B'));
    assertEquals(65,'A');
//    assertEquals(1, Boolean.logicalAnd());
    assertEquals(14,12^2);
    Character [] chrArr=new Character[]{'a','a'};
  }
  @Test
  public void parity_test(){
    assertEquals(1,parity(8));
  }
  public  short countBits(int x) {
    short numBits = 0;
    while (x != 0) {
      numBits += (x & 1);
//      numBits++;
      x>>>= 1;
    }
    return numBits;
  }
  public short parity(long x){
    short result = 0;
    while (x != 0) {
      result ^= (x & 1);
      x >>>= 1;
    }
      return result;
  }
//  erase the lowest set bit in a word in a single operation
  //This can be used to improve performance in the best- and average-cases.
  public short parityDropLowestBest(long x){
    short result = 0;
    while (x != 0) {
      result ^= 1;
      x&=(x-1); //drops the lowest set bit of x
    }
    return result;
  }
  public static short parityMasking(long x){
    final int W0RD_SIZE = 16;
    final int BIT_MASK = 0xFFFF;
//    return (short) (parityMasking((int)((x>>> (3 * W0RD_SIZE)) & BIT_MASK)]
//    A precomputedParity[(int)((x»>(2*W0RD_SIZE))&BIT_MASK)] A precomputedParity[(int)((x »> W0RD_SIZE) & BIT_MASK)]
//    A precomputedParity[(int)(x&BIT_MASK)]);
    return W0RD_SIZE;
  }
}
