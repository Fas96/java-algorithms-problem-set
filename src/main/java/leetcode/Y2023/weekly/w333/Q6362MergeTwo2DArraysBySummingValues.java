package leetcode.Y2023.weekly.w333;

public class Q6362MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        //nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
        //Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
        //
        //Only ids that appear in at least one of the two arrays should be included in the resulting array.
        //Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays then its value in that array is considered to be 0.
        int n = nums1.length;
        int m = nums2.length;
        int[][] ans = new int[n + m][2];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
            } else {
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
            }
            k++;
        }
        while (i < n) {
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            i++;
            k++;
        }
        while (j < m) {
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            j++;
            k++;
        }
        int[][] res = new int[k][2];
        for (int l = 0; l < k; l++) {
            res[l][0] = ans[l][0];
            res[l][1] = ans[l][1];
        }
        return res;
    }
}
