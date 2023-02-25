package leetcode.Y2023.daily.deasy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q226InvertBinaryTree {
    // [4,2,7,1,3,6,9]
    //Output: [4,7,2,9,6,3,1]
    @Test
    public void testInvertTree(){
        TreeNode equals=TreeNode.of(4,7,2,9,6,3,1);
        TreeNode testTree=TreeNode.of(4,2,7,1,3,6,9);
        assertEquals(invertTree(testTree),equals);
        //[2,1,3]
        //Output: [2,3,1]
        equals=TreeNode.of(2,1,3);
        testTree=TreeNode.of(2,3,1);
        assertEquals(invertTree(testTree),equals);

        equals=TreeNode.of();
        testTree=TreeNode.of();

        assertEquals(invertTree(testTree),equals);

    }


    public TreeNode invertTree(TreeNode root) {
      dfs(root);
      return root;
    }

    private void dfs(TreeNode root) {
        if(root==null)return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        dfs(root.left);
        dfs(root.right);
    }
}
