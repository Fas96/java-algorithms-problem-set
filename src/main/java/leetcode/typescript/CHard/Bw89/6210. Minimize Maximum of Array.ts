function minimizeArrayValue(nums: number[]): number {
    /*
* Input: nums = [3,7,1,6]
Output: 5
Explanation:
One set of optimal operations is as follows:
1. Choose i = 1, and nums becomes [4,6,1,6].
2. Choose i = 3, and nums becomes [4,6,2,5].
3. Choose i = 1, and nums becomes [5,5,2,5].
The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
Therefore, we return 5.
* */
    // [3,7,1,6] returns 5
    //Choose an integer i such that 1 <= i < n and nums[i] > 0.
    // Decrease nums[i] by 1.

    let ans = 0;
    let n = nums.length;
    let max = 0;
    for (let i = 0; i < n; i++) {
        //integer i such that 1 <= i < n and nums[i] > 0.
        if (nums[i] > 0) {
            ans++;
            nums[i]--;
            // Increase nums[i - 1] by 1.
            if (i > 0) {
                nums[i - 1]++;
            }
        }
    }
    for (let i = 0; i < n; i++) {
        max = Math.max(max, nums[i]);
    }
    return max;







    // Increase nums[i - 1] by 1.
    // Return the minimum possible value of the maximum integer of nums after performing any number of operations.




};

// You are given a 0-indexed array nums comprising of n non-negative integers.
//
//     In one operation, you must:
//
//     Choose an integer i such that 1 <= i < n and nums[i] > 0.
// Decrease nums[i] by 1.
// Increase nums[i - 1] by 1.
// Return the minimum possible value of the maximum integer of nums after performing any number of operations.