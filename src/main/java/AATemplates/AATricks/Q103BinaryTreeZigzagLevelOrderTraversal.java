package AATemplates.AATricks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q103BinaryTreeZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        // use ArrayDeque as a Queue
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (q.isEmpty() == false) {
            int size = q.size();
            // use ArrayDeque as a Linked List
            Deque<Integer> ll = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.removeFirst();
                if (result.size() % 2 == 0) ll.addLast(node.val);
                else ll.addFirst(node.val);
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }
            result.add(new ArrayList<Integer>(ll));
        }
        return result;
    }
}
