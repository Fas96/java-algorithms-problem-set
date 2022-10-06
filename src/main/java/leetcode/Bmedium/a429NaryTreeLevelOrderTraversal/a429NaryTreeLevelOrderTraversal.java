package leetcode.Bmedium.a429NaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a429NaryTreeLevelOrderTraversal {
  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  public List<List<Integer>> levelOrder(Node root) {

    List<List<Integer>> levelList = new ArrayList<>();
    if (root == null)return levelList;

    Queue<Node> q = new LinkedList<>();

    q.offer(root);
    while (!q.isEmpty()) {

      List<Integer> temp = new ArrayList<>();
      int size = q.size();
      // Current level
      for (int i = 0; i < size; i++) {
        Node node = q.poll();
        temp.add(node.val);

        for (Node child : node.children) {
          q.offer(child);
        }
      }

      levelList.add(temp);
    }


    return levelList;
  }

}
