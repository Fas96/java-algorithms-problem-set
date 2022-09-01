package leetcode.Bmedium.a1448CountGoodNodesinBinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class a1448CountGoodNodesinBinaryTree {


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

  int res=0;
  TreeNode tem=null;
  public int goodNodes(TreeNode root) {
    if(root==null) return 0;
    if(root.left==null && root.right==null) return 1;
    tem=root;
    goodNodesCountHelper(root,root.val);
    return res;
  }

  private void goodNodesCountHelper(TreeNode root,int curVal) {
    if(root==null) return;
    if(root.val>=curVal)res++;
    goodNodesCountHelper(root.left,Math.max(curVal,root.val));

    goodNodesCountHelper(root.right,Math.max(curVal,root.val));
  }

  @Test
  public void testgoodNodes(){
    System.out.println();
  }
}
