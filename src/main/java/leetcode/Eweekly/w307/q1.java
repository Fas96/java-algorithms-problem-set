package leetcode.Eweekly.w307;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class q1 {

  @Test
  public  void sol_test(){

    assertEquals(0,minNumberOfHours(5,3,new int[]{1,4},new int[]{2,5}));
  }


//  initialEnergy and initialExperience
public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
  int res=0;
  int i=0;
  int re=0;
  if(initialEnergy> Arrays.stream(energy).sum())return 0;
 while (initialEnergy>0){

   initialEnergy-=energy[i];
   initialExperience+=experience[i];
   re+=1;
   i+=1;

 }
  System.out.println(re);
 return re;

}
}

