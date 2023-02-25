package leetcode.Y2023.weekly.w331;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q6346HouseRobberIV {
    public  int minCapability(int[] nums, int k) {
        int low = 0, high = 1000000001;
        while(high - low > 1){
            int h = high+low / 2;
            int num = 0;
            boolean done = false;
            for(int v : nums){
                if(v <= h && !done){
                    num++;
                    done = true;
                }else if(done){
                    done = false;
                }
            }
            if(num >= k) {
                high = h;
            }else{
                low = h;
            }
        }
        return high;
    }

    @Test
    public void testminCapability(){
        int[]given={2,3,5,9};
        int k=2;
        System.out.println(minCapability(given,k));
    }
}
