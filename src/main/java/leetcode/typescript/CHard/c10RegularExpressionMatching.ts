export default  function isMatch(s: string, p: string): boolean {
    count:Number;
    tem:String;
    if(p.length==0){
        return s.length==0;
    }
    if(p.length==1){
        return s.length==1&&(p[0]==s[0]||p[0]=='.');
    }
    if(p[1]!='*'){
        if(s.length==0){
            return false;
        }
        return (p[0]==s[0]||p[0]=='.')&&isMatch(s.substring(1),p.substring(1));
    }
    while(s.length>0&&(p[0]==s[0]||p[0]=='.')){
        if(isMatch(s,p.substring(2))){
            return true;
        }
        s=s.substring(1);
    }
    return isMatch(s,p.substring(2));

}
function threeSumClosest(nums: number[], target: number): number {
    let gap:number=Number.MAX_SAFE_INTEGER;
    let ans:number=0;
    nums.sort((a,b)=>a-b);
    for(let i=0;i<nums.length-2;i++){
        let j=i+1;
        let k=nums.length-1;
        while(j<k){
            let sum=nums[i]+nums[j]+nums[k];
            if(sum==target){
                return target;
            }
            if(Math.abs(sum-target)<gap){
                gap=Math.abs(sum-target);
                ans=sum;
            }
            if(sum<target){
                j++;
            }else{
                k--;
            }
        }
    }

    return ans;

}