package leetcode.Bmedium.a565ArrayNesting;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class a565ArrayNesting {
    @Test
    public void testarrayNesting(){
        assertEquals(4,arrayNesting(new int[]{0,1,2}));
    }

    public int arrayNesting(int[] ints) {
        int ans=0;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < ints.length; i++) {
            if(!set.contains(i)){
                int count=0;
                int index=i;
                while(!set.contains(index)){
                    set.add(index);
                    index=ints[index];
                    count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}
