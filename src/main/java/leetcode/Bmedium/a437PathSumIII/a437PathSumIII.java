package leetcode.Bmedium.a437PathSumIII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class a437PathSumIII {

    /*
    * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

    * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    @Test
    public void testSol(){
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(-3);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);
        root.left.right.right=new TreeNode(1);
        root.right.right=new TreeNode(11);

        assertEquals(3, pathSum(root, 8));
    }
@Test
    public void testSolS(){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.right.left=new TreeNode(5);
        root.right.right.right=new TreeNode(1);

        assertEquals(3, pathSum(root, 22));
    }

    public int pathSum(TreeNode root, int i) {
        if (root == null) return 0;
        return dfs(root, i) + pathSum(root.left, i) + dfs(root.right, i);
    }

    private int dfs(TreeNode root, int i) {
        if(root==null)return 0;
        return (root.val==i?1:0)+dfs(root.left,i-root.val)+dfs(root.right,i-root.val);
    }
}



