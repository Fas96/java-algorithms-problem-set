package leetcode.Y2023.daily.deasy;

import com.github.shanepark.leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q104MaximumDepthOfBinaryTree {
    @Test
    public void test(){

        assertEquals( TreeNode.of(1,null,2).getMaxDepth(),2);
        assertEquals( maxDepth(TreeNode.of(1,null,2)),2);
    }

    public int maxDepth(TreeNode root) {
        return (root==null)?0:Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
}
