package AATemplates;

public class QBinaryTreeDFSRecursive {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        // do logic
        dfs(root.left);
        dfs(root.right);
        return ans;
    }
}
