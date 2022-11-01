function arrayNesting(nums: number[]): number {
    let mx=0;
    for (let i = 0; i < nums.length; i++) {
        let cnt=0;
        let j=i;
        while (nums[j]!=-1){
            let temp=nums[j]
            nums[j]=-1
            j=temp;
            cnt++;
        }
        mx=Math.max(mx,cnt)
    }

    return mx;
};