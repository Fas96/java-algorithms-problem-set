function applyOperations(nums: number[]): number[] {

    let answer = [];
    let i = 0;
    while (i < nums.length) {
        if (nums[i] == nums[i + 1]) {
            answer.push(nums[i] * 2);
            i++;
        } else {
            answer.push(nums[i]);
        }
        i++;
    }

    while (answer.length < nums.length) {
        answer.push(0);
    }

    let j = 0;
    while (j < nums.length) {
        if (nums[j] == 0) {
            nums.splice(j, 1);
            nums.push(0);
        }
        j++;
    }


    return answer;


};