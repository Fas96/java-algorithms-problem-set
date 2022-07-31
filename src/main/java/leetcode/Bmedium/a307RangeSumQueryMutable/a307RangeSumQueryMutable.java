package leetcode.Bmedium.a307RangeSumQueryMutable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class a307RangeSumQueryMutable {

//       @Test
//       public void giveenListofArraysWeCanMake(){
//    assertEquals(new int[]{1,2,2,3,3} ,new a307RangeSumQueryMutable(new int[]{1,2,2,3,3}));
//  }
     int [] nums;

    public a307RangeSumQueryMutable(int[] nums) {
      this.nums=nums;
    }

    public void update(int index, int val) {
      nums[index]=val;
    }

    public int sumRange(int left, int right) {
      int sum=0;
      for(int i=left;i<=right;i++)
      {
        sum+=nums[i];
      }
      return sum;
    }

}
