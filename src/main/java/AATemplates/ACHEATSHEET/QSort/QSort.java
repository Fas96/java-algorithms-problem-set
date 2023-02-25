package AATemplates.ACHEATSHEET.QSort;

public class QSort {
    void msort(int[] nums) {
        msort(nums, 0, nums.length - 1);
    }
    void msort(int[] nums, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        msort(nums, l, m);
        msort(nums, m + 1, r);
        merge(nums, l, r);
    }
    void merge(int[] nums, int l, int r) {
        int m = (l + r) / 2, i = l, j = m + 1;
        int[] arr = new int[r - l + 1];
        for (int k = 0; k < arr.length; k++) {
            if (j > r || (i <= m && nums[i] < nums[j])) arr[k] = nums[i++];
            else arr[k] = nums[j++];
        }
        for (int k = 0; k < arr.length; k++) {
            nums[l++] = arr[k];
        }
    }

    //quick sort
    void qsort(int[] nums) {
        qsort(nums, 0, nums.length - 1);
    }
    void qsort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        qsort(nums, l, p - 1);
        qsort(nums, p + 1, r);
    }
    int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int p = r;
        for (int i = l; i < p; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, p - 1);
                swap(nums, p, p - 1);
                i--;
                p--;
            }
        }
        return p;
    }
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    //Quick Select
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private int quickSelect(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p < k) return quickSelect(nums, p + 1, r, k);
        if (p > k) return quickSelect(nums, l, p - 1, k);
        return nums[p];
    }

}
