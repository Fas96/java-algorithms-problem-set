function averageValue(nums: number[]): number {
    // nums of positive integers, return the average value of all even integers that are divisible by 3.
    //Note that the average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
    let ans = 0;
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] % 2 === 0 && nums[i] % 3 === 0) {
            ans += nums[i];
            count++;
        }
    }
    return count === 0 ? 0 : Math.floor(ans / count);
};