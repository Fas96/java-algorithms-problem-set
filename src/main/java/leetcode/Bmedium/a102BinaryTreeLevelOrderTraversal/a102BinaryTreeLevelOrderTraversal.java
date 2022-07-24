package leetcode.Bmedium.a102BinaryTreeLevelOrderTraversal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class a102BinaryTreeLevelOrderTraversal {
  @Test
  public void canMakeSquare_test(){
   Solution s= new Solution();
    List<List<Integer>>  arr =new ArrayList<>() ;
    arr.add(new ArrayList<>());
    arr.add(new ArrayList<>());

    assertEquals( arr ,s.levelOrder(new TreeNode()));
  }
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
      callStackLevels(ans,root,0);
    return ans;
    }
    public void callStackLevels(List<List<Integer>>  lelVals,TreeNode root,int level) {
      if(root==null) return;
      if(level>=lelVals.size()){
        lelVals.add(new LinkedList<Integer>());
      }
      lelVals.get(level).add(root.val );
      callStackLevels(lelVals,root.left,level+1);
      callStackLevels(lelVals,root.right,level+1);
    }
  }

   public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

}
