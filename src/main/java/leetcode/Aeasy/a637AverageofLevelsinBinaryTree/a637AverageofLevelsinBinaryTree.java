package leetcode.Aeasy.a637AverageofLevelsinBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a637AverageofLevelsinBinaryTree {
  

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
  
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> ans= new ArrayList<>();
    Queue<TreeNode> queueNode= new LinkedList<>();
    queueNode.offer(root);
    while (!queueNode.isEmpty()){
      int cnt=queueNode.size();
      double sum=0;
      for (int i = 0; i < cnt; i++) {
        TreeNode  cur=queueNode.poll();
        sum+=cur.val;
        System.out.println(cur.val);
        if(cur.left!=null)queueNode.offer(cur.left);
        if(cur.right!=null)queueNode.offer(cur.right);
      }
      List<TreeNode> myList = new ArrayList<TreeNode>(queueNode);
      for (TreeNode theFruit : myList)
        System.out.println(theFruit.val);

      ans.add(sum/cnt);
    }

    return ans;
  }
}
