package AATemplates;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QFindTopKElementsWithHeap {
    public int[] fn(int[] arr, int k) {
        //TODO:CRITERIA specify the creation of the heap
        Comparator<Integer> CRITERIA = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        PriorityQueue<Integer> heap = new PriorityQueue<>(CRITERIA);
        for (int num: arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }

        return ans;
    }
}
