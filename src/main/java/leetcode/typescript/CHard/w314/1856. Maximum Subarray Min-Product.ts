export  function maxSumMinProduct(nums: number[]): number {
    let mod=1000000007;
     //use stack
        let stack:number[]=[];
        let left:number[]=[];
        let right:number[]=[];
        for(let i=0;i<nums.length;i++){
            left[i]=i;
            right[i]=i;
        }
        for(let i=0;i<nums.length;i++){
            while(stack.length>0&&nums[stack[stack.length-1]]>=nums[i]){
                stack.pop();
            }
            if(stack.length>0){
                left[i]=stack[stack.length-1]+1;
            }
            stack.push(i);
        }
        stack=[];
        for(let i=nums.length-1;i>=0;i--){
            while(stack.length>0&&nums[stack[stack.length-1]]>=nums[i]){
                stack.pop();
            }
            if(stack.length>0){
                right[i]=stack[stack.length-1]-1;
            }
            stack.push(i);
        }
        let sum:number[]=new Array(nums.length+1).fill(0);
        for(let i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
        }
        let ans=0;
        for(let i=0;i<nums.length;i++){
            ans=Math.max(ans,nums[i]*(sum[right[i]+1]-sum[left[i]]));
        }
        return ans%mod;

};