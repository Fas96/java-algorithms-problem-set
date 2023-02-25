package AATemplates.AATricks;

public class QInorderTraversalOfABST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Q98ValidateBinarySearchTree{
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }
        private boolean isValidBST(TreeNode root, Integer min, Integer max) {
            if (root == null) return true;
            if (min != null && root.val <= min) return false;
            if (max != null && root.val >= max) return false;
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }


        //or
        TreeNode prev = null;
        public boolean isValidBST_SEC(TreeNode root) {
            if (root == null) return true;
            if (!isValidBST(root.left)) return false;
            if (prev != null && prev.val >= root.val) return false;
            prev = root;
            return isValidBST(root.right);
        }
    }
}
