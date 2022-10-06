package leetcode.Bmedium.a2415ReverseOddLevelsofBinaryTree;

import leetcode.Chard.c23MergekSortedLists.c23MergekSortedLists;

import java.util.*;

public class a2415ReverseOddLevelsofBinaryTree {
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
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList();
        int level = 0;
        int tmp;

        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(level%2 == 1) {  // reversing the current level vals
                Deque<TreeNode> queue1 = new LinkedList(queue);
                while(!queue.isEmpty())
                {
                    tmp = queue.getFirst().val;
                    queue.getFirst().val = queue.getLast().val;
                    queue.getLast().val = tmp;
                    queue.pollFirst();
                    queue.pollLast();
                }
                queue=queue1;
            }

            if(queue.peek().left == null)     break;

            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                queue.add(node.left);
                queue.add(node.right);
            }
            level++;
        }
        return root;
    }

    private void formNodeN(TreeNode n, List<List<TreeNode>> result,int l) {
        for (List<TreeNode> level : result) {
            List<TreeNode> levelNodes=result.get(l);

        }
    }

    public void dfs(List<List<TreeNode>>  lelVals,TreeNode root,int level) {
        if(root==null) return;
        if(level>=lelVals.size()){
            lelVals.add(new LinkedList<TreeNode>());
        }
        lelVals.get(level).add(root );
        dfs(lelVals,root.left,level+1);
        dfs(lelVals,root.right,level+1);
    }
}
