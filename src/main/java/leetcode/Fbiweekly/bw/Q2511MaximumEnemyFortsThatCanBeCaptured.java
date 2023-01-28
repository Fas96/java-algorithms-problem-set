package leetcode.Fbiweekly.bw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q2511MaximumEnemyFortsThatCanBeCaptured {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            int leftCount = 0;
            int rightCount = 0;
            if(forts[i] == 1) {
                int left = i;
                while(left >= 0 && forts[left] != -1 && forts[left] != 1) {
                    leftCount++;
                    left--;
                }
            }
            if(forts[n-i-1] == 1) {
                int right = n-i-1;
                while(right < n && forts[right] != -1 && forts[right] != 1) {
                    rightCount++;
                    right++;
                }
            }
            System.out.println(leftCount + " " + rightCount);
            ans = Math.min(leftCount, rightCount);

        }
        return ans;
    }

    @Test
    public void testFORN(){
        assertEquals(0, captureForts(new int[]{-1,-1,1,-1,-1,0}));
    }
}
