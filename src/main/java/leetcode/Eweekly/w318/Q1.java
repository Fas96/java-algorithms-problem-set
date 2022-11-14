package leetcode.Eweekly.w318;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q1 {
    @Test
    public void testSol(){
        assertEquals(new int[]{1694,399,832,1758,412,206,272,0,0,0,0,0,0,0},applyOperations(new int[]{847,847,0,0,0,399,416,416,879,879,206,206,206,272}));

    }
    public int[] applyOperations(int[] nums) {

        int[] holder=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            holder[i]=nums[i];
        }

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                holder[i]=nums[i]*2;
                holder[i+1]=0;
                i++;
            }
        }
        //remove all the 0s
        int[] result=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(holder[i]!=0){
                result[j]=holder[i];
                j++;
            }
        }
        return result;

//
//
//        //shift all 0s to the end of the array
//        int[] answer = new int[nums.length];
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (applyanswer[i] != 0) {
//                answer[j] = applyanswer[i];
//                j++;
//            }
//        }
//        return answer;
    }
}
