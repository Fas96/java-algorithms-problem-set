package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.twoPointers;

import java.util.Arrays;
import java.util.Map;
import org.junit.Test;

public class a11ContainerWithMostWater {

  public int maxArea(int[] height) {
    int mxArea=Integer.MIN_VALUE,N=height.length;
    if(N<=2)return Arrays.stream(height).min().getAsInt();
    int L=0,R=N-1;

    while (L<R){
      int H = Math.max(height[L], height[R]);
      int W=R-L;

      mxArea=Math.max(mxArea,H*W);
      System.out.println(W+"-"+H+"|--"+ height[L]+"---"+height[R]+"|A="+mxArea);
      if(height[R] > height[L])L++;
      if(height[L] > height[R])R--;
      if(height[L] == height[R]){R--;L++;}
    }
    return  mxArea;
  }

  @Test
  public void maxAreaTest(){
    System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
  }

}
