package leetcode.Bmedium.a337HouseRobberIII;

public class a337HouseRobberIII {
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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root), robExclude(root));
    }

    private int robExclude(TreeNode root) {

        if (root == null) return 0;
        return rob(root.left) + rob(root.right);
    }

    private int robInclude(TreeNode root) {
        if (root == null) return 0;
        return root.val + robExclude(root.left) + robExclude(root.right);
    }
}
