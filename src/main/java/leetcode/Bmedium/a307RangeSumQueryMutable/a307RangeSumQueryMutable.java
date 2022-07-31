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
      int n = nums.length;
      int height = (int)(Math.log(n)/Math.log(2)) + 1;
      int tree_nodes = (int) Math.pow(2, height + 1);
      SegmentTree ob = new SegmentTree(tree_nodes);
      ob.build(nums, 0, 0, n - 1);
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
