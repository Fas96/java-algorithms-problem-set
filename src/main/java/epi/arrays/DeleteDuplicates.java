package epi.arrays;

import org.junit.Test;

import java.util.List;

public class DeleteDuplicates {
    public int deleteDuplicates(List<Integer> A){
        if (A.isEmpty()) {
            return 0;
        }
        int writeIdx = 1;
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(writeIdx - 1).equals(A.get(i))) {
                A.set(writeIdx++, A.get(i));
            }
        }
        return writeIdx;
    }
    @Test
    public void test(){
        System.out.println(deleteDuplicates(List.of(2,3,5,5,7,11,11,11,13)));
    }
}
