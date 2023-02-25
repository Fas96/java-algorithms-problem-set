package AATemplates;

import java.util.Stack;

public class QBinaryTreeDFSIterative {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            // do logic
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return ans;
    }
}
