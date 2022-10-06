package leetcode.Chard.c987VerticalOrderTraversalofaBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class c987VerticalOrderTraversalofaBinaryTree {


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

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer,List<Integer>> res = new TreeMap<>();
    List<List<Integer>> ans= new ArrayList<>();
    int x=0,y=0;
    if(root==null) return ans;
    inOrderTraversal(root,res,x,y);
    System.out.println();
    res.forEach((k,v) -> {Collections.sort(v);ans.add(v);});
    return ans;
  }

  private void inOrderTraversal(TreeNode root,  TreeMap<Integer,List<Integer>> res,int x,int y) {
    if(root==null) return ;
    inOrderTraversal(root.left,res,x+1,y-1);
    res.computeIfAbsent(y, k -> new LinkedList<Integer>());
    res.get(y).add(root.val );
    inOrderTraversal(root.right,res,x+1,y+1);
  }

}
