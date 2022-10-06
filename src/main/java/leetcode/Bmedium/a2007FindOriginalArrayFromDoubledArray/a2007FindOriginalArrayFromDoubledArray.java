package leetcode.Bmedium.a2007FindOriginalArrayFromDoubledArray;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a2007FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int L=0,R=0,P=0,N=changed.length;
        List<Integer> res= new ArrayList<>();
        if(N<2)return new int[]{};
        while (R<N){
            if(changed[L]*2==changed[R] && changed[L]!=changed[R]){
                res.add(changed[L]);
                L++;
            }else if(changed[L]==changed[R]){
                P++;
            }
            R++;
        }
        int[] array=null;

        if(verifyAllEqualUsingHashSet(changed)&& P>0){
            array=new int[(int)P/2];
            for (int i = 0; i < array.length; i++) {
                array[i]=res.get(i);
            }
            System.out.println(Arrays.toString(array));
            return array;
        }
          array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i]=res.get(i);
        }
        return   array;
    }

    public boolean verifyAllEqualUsingHashSet(int[] arr) {
        Set<Integer> distinct = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        boolean allEqual = distinct.size() <= 1;
       return allEqual;
    }
    @Test
    public void findOriginalArrayTest() {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1,3,4,2,6,8})));
    }
}
