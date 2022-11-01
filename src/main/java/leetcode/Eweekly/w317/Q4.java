package leetcode.Eweekly.w317;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Q4 {
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
    @Test
    public void testW317Q4() {

    }
    int [] parents;
    int deepestNode;
    int maxDepth;
    Set<Integer> set;
    int maxDepth2;
    int [] results;
    Integer [] dp;

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = countSize(root);
        maxDepth = 0;
        deepestNode = root.val;
        parents = new int [n + 1];
        results = new int [n + 1];

        explore(root, 0, -1);
        set = new HashSet<>();

        int val = deepestNode;

        do{
            set.add(val);
            val = parents[val];
        }while(val != -1);

        //System.out.println(set);

        maxDepth2 = 0;

        int [] answers = new int [queries.length];
        int idx = 0;

        dp = new Integer [n + 1];
        dfs2(root, 0);



        for (int q : queries){
            if (dp[q] != null){
                answers[idx++] = dp[q];
            }else if (!set.contains(q)){
                answers[idx++] = maxDepth;
            }else{
                answers[idx++] = dp[q];
            }
        }

        return answers;
    }

    private void dfs2(TreeNode node, int depth){
        if (node == null){
            return;
        }

        if (set.contains(node.val))
            dp[node.val] = maxDepth2;
        maxDepth2 = Math.max(maxDepth2, depth);


        if (node.left != null && set.contains(node.left.val)){
            dfs2(node.right, depth + 1);
            dfs2(node.left, depth + 1);
        }else if (node.right != null && set.contains(node.right.val)){
            dfs2(node.left, depth + 1);
            dfs2(node.right, depth + 1);
        }else{
            dfs2(node.left, depth + 1);
            dfs2(node.right, depth + 1);
        }


    }

    private void explore(TreeNode node, int depth, int parent){
        if (node == null) return;

        parents[node.val] = parent;

        if (depth > maxDepth){
            maxDepth = depth;
            deepestNode = node.val;
        }

        explore(node.left, depth + 1, node.val);
        explore(node.right, depth + 1, node.val);
    }

    private int countSize(TreeNode node){
        if (node == null) return 0;

        return 1 + countSize(node.left) + countSize(node.right);
    }
}
