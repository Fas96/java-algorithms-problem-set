package leetcode.Y2023.daily.deasy;

import java.util.LinkedList;
import java.util.List;

public class Q144BinaryTreePreorderTraversal {

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new LinkedList<>();
        if(root==null)return ans;
        dfs(root,ans);

        return  ans;

    }

    private void dfs(TreeNode root,List<Integer> ans) {
        if(root==null) return;
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
}
