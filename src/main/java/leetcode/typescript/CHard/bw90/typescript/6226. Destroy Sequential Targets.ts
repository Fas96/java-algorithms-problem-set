function destroyTargets(nums: number[], space: number): number {
    //consider [1,5,3,2,2] 10000  => result=2
    let result = 0;
    let i = 0;
    while (i < nums.length) {
        let j = i + 1;
        while (j < nums.length && nums[j] - nums[i] <= space) j++;
        result++;
        i = j;
    }
    return result;



};