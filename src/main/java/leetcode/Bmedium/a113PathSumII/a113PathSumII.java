package leetcode.Bmedium.a113PathSumII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class a113PathSumII {
  private class TreeNode {
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
  List<List<Integer>>  res= new ArrayList<>();


  public boolean pathSum(TreeNode root, int targetSum) {

    if(root==null)return false;
    Stack<Integer> stkTrack = new Stack<>();
    getPathSum(root,targetSum,stkTrack);
    return res.size()>0;
  }

  private void getPathSum(TreeNode root, int targetSum, Stack<Integer> stkTrack) {
    stkTrack.push(root.val);
    //The root val can only be same as the targetSum if after substraction all the previous values
//    the remaining is same as the value of the last node
    if(root.left==null && root.right==null && targetSum==root.val)res.add(new ArrayList<>(stkTrack));
    if(root.left!=null)getPathSum(root.left,targetSum-root.val,stkTrack);
    if(root.right!=null)getPathSum(root.right,targetSum-root.val,stkTrack);
    stkTrack.pop();
  }
}
