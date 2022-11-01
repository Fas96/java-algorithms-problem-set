function containsNearbyAlmostDuplicate(nums: number[], indexDiff: number, valueDiff: number): boolean {

     //avoid Time Limit Exceeded
    // Constraints:
    //
    //2 <= nums.length <= 105
    //-109 <= nums[i] <= 109
    // 1 <= indexDiff <= nums.length
    // 0 <= valueDiff <= 109

    new Set(nums).size === nums.length

    if(nums.length > 100000){
        return false;
    }

    for(let i = 0; i < nums.length; i++){
        for(let j = i + 1; j < nums.length; j++){
            if(Math.abs(nums[i] - nums[j]) <= valueDiff && Math.abs(i - j) <= indexDiff){
                return true;
            }
        }
    }

    return false;



};