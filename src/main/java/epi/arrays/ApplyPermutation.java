package epi.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplyPermutation {
    @Test
    public void testApplyPermutation() {
        int[] perm = {2, 0, 1, 3};
        int[] A = {1, 2, 3, 4};
        applyPermutation(perm, A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
    public static void applyPermutationLIST(List<Integer> perm, List<Integer> A) {
        for (int i = 0; i < A.size(); ++i) {
            // Check if the element at index i has not been moved by checking if
            // perm.get(i) is nonnegative.
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                // Subtracts perm.size() from an entry in perm to make it negative,
                // which indicates the corresponding move has been performed.
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }
        // Restore perm.
        for (int i = 0; i < perm.size(); ++i) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }
    public static void applyPermutation(int[] perm, int[] A) {
        for (int i = 0; i < A.length; i++) {
            // Check if the element at index i has not been moved by checking if
            // perm[i] is nonnegative.
            int next = i;
            while (perm[next] >= 0) {
                int temp = A[i];
                A[i] = A[perm[next]];
                A[perm[next]] = temp;
                // Subtracts perm.size() from an entry in perm to make it negative,
                // which indicates the corresponding move has been performed.
                int temp2 = perm[next];
                // perm[next] -= perm.size();
                perm[next] -= perm.length;
                next = temp2;

                System.out.println(Arrays.toString(perm)+" - "+Arrays.toString(A));
            }
        }

        // Restore perm.
        for (int i = 0; i < perm.length; i++) {
            perm[i] += perm.length;
        }
    }

    public static void applyPermutationSignBit(List<Integer> perm,List<Integer> A){
        for (int i = 0; i < A.size(); i++) {
            //traverse the cycle to see if its the minimum element
            boolean isMin = true;
            int j = perm.get(i);
            while (j != i){
                if (j < i){
                    isMin = false;
                    break;
                }
                j = perm.get(j);
            }
           if (isMin){
                cyclicPermutation(i,perm,A);
            }


        }

    }

    private static void cyclicPermutation(int start, List<Integer> perm, List<Integer> A) {
        int i = start;
        int temp = A.get(start);
        do {
            int nextI = perm.get(i);
            int nextTemp = A.get(nextI);
            A.set(nextI,temp);
            i = nextI;
            temp = nextTemp;
        }while (i != start);
    }
}
