package leetcode.Y2023.personal.bsearch;

public class Q1283FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1,right=1_000_000;
        while(left<right){
            int mid=left+(right-left)/2;
            if(checkIfCanDivideAll(nums,threshold,mid))right=mid;
            else left=mid+1;
        }
        return left;
    }

    private boolean checkIfCanDivideAll(int[] nums, int threshold, int mid) {
        int sum=0;
        for(int num:nums){
            sum+=num/mid+(num%mid==0?0:1);
        }
        return sum<=threshold;
    }
}
