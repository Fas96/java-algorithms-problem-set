package kakao.a2022.demo;

import leetcode.Chard.c315CountofSmallerNumbersAfterSelf.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1 {
    @Test
    public void testSol(){
        Solution solution=new Solution();
        assertEquals(new int[]{1,10},solution.solution(new int[][]{{1,4},{3,4},{3,10}}));
        assertEquals(new int[]{2,1},solution.solution(new int[][]{{1,1},{2,2},{1,2}}));
    }

    class Solution {
        public int[] solution(int[][] v) {
            int[] answer = new int[2];
            int x1=v[0][0];
            int x2=v[1][0];
            int x3=v[2][0];
            int y1=v[0][1];
            int y2=v[1][1];
            int y3=v[2][1];
            if(x1==x2){
                answer[0]=x3;
            }else if(x1==x3){
                answer[0]=x2;
            }else{
                answer[0]=x1;
            }
            if(y1==y2){
                answer[1]=y3;
            }else if(y1==y3){
                answer[1]=y2;
            }else{
                answer[1]=y1;
            }
            return answer;
        }
    }
}
