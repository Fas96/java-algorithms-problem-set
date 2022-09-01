package leetcode.Aeasy.a2379MinimumRecolorstoGetKConsecutiveBlackBlocks;

import org.junit.Test;

public class a2379MinimumRecolorstoGetKConsecutiveBlackBlocks {
  @Test
  public void gT_Test(){
    System.out.println("::::");
    System.out.println(minimumRecolors("WWBBBWBBBBBWWBWWWB",16));
    System.out.println("::::::");
  }
  public int minimumRecolors(String blocks, int k) {
    int s=Integer.MAX_VALUE,count=0;
    if(k>=blocks.length())
      return (int) blocks.chars().filter(c->c=='W').count();
    System.out.println(blocks.length());
    for (int i = 0; i < blocks.length()-k+1; i++) {
      System.out.println(i+"--"+(k+i));
      System.out.println(blocks.substring(i,k+i).chars().filter(ch->ch=='W').count());
      s= (int) Math.min(s,blocks.substring(i,k+i).chars().filter(ch->ch=='W').count());
    }
    return s;
  }
}
