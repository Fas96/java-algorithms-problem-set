function check(nums: number[], mid: number) {
    let c = 0;
    for (let i = nums.length - 1; i >= 0; i--) {
        c += nums[i];
        c -= mid;
        c = Math.max(c, 0);
    }
    return c === 0;

}

function minimizeArrayValue(nums: number[]): number {
    let low = -1;
    let high = 1000000001;
    while (high - low > 1) {
        let mid = Math.floor((low + high) / 2);
        if (check(nums, mid)) {
            high = mid;
        } else {
            low = mid;
        }
    }
    return high;
}