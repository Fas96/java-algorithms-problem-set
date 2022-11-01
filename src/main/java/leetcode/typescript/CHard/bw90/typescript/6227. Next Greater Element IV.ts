export  function secondGreaterElement(nums: number[]): number[] {
    let result = [];
    for (let i = 0; i < nums.length; i++) {
        let second = -1;
        let cnt = 0;
        let subArray = nums.slice(i + 1, nums.length);
        subArray.sort((a, b) => a - b);
        for (let j = 0; j < subArray.length; j++) {
            if (subArray[j] > nums[i]) {
                cnt++;
                if (cnt === 2) {
                    second = subArray[j];
                    break;
                }
            }

        }
        result.push(second);
    }
    return result;

};