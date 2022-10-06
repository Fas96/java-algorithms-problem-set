package leetcode.Bmedium.a75SortColors;


public class a75SortColors {
  public void sortColors(int[] nums) {
    int n=nums.length;
    int curIdx=0,R=n,L=0;

    while (curIdx<=R){
      if(nums[curIdx]==2){
        swap( nums,curIdx,R);
        R--;
      } else if (nums[curIdx]==1) {
        curIdx++;
      }else {
        swap( nums,curIdx,L);
        L++;
      }
    }
  }
  private  void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
