/*
* Example 2:

Input: nums = [2], edges = []
Output: 0
Explanation: There are no edges to be deleted.


Constraints:

1 <= n <= 2 * 104
nums.length == n
1 <= nums[i] <= 50
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
edges represents a valid tree.
* */

function componentValue(nums: number[], edges: number[][]): number {
    // 6211. Create Components With Same Value
    // https://leetcode.com/problems/create-components-with-same-value/
    // You are given a 0-indexed array nums comprising of n non-negative integers.
    //
    // In one operation, you must:
    //
    // Choose an integer i such that 1 <= i < n and nums[i] > 0.
    // Decrease nums[i] by 1.
    // Increase nums[i - 1] by 1.
    // Return the minimum possible value of the maximum integer of nums after performing any number of operations.
    /*
    * Example 2:

    Input: nums = [2], edges = []
    Output: 0
    Explanation: There are no edges to be deleted.


    Constraints:

    1 <= n <= 2 * 104
    nums.length == n
    1 <= nums[i] <= 50
    edges.length == n - 1
    edges[i].length == 2
    0 <= edges[i][0], edges[i][1] <= n - 1
    edges represents a valid tree.
    * */
    // 1 <= n <= 2 * 104
    // nums.length == n
    // 1 <= nums[i] <= 50
    // edges.length == n - 1
    // edges[i].length == 2
    // 0 <= edges[i][0], edges[i][1] <= n - 1
    // edges represents a valid tree.
    // let n = nums.length;
    // let edges = new Array(n - 1);
    // for (let i = 0; i < n - 1; i++) {
    //     edges[i] = new Array(2);
    // }
    // edges[0][0] = 0;
    // edges[0][1] = 1;
    // edges[1][0] = 1;
    // edges[1][1] = 2;
    // edges[2][0] = 2;
    // edges[2][1] = 3;
    // edges[3][0] = 1;
    // edges[3][1] = 4;
    // edges[4][0] = 4;
    // edges[4][1] = 5;
    //
    // let nums = [1, 1, 1, 1, 1, 1];

    let n = nums.length;
    let ans = 0;
    let max = 0;
    for (let i = 0; i < n; i++) {

        if (nums[i] > 0) {
            ans++;
            nums[i]--;
            if (i > 0) {
                nums[i - 1]++;
            }
        }
    }
    for (let i = 0; i < n; i++) {
        max = Math.max(max, nums[i]);
    }
    return max;

};