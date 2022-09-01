package leetcode.Bmedium.a133CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a133CloneGraph {
  private void dfs(Node cur, Set<Node> visited, Map<Node, Node> map, List<Node> neighbors) {
    if (visited.contains(cur)) return;
    visited.add(cur);
    for (Node neighbor : neighbors) {
      if (map.get(neighbor) == null) map.put(neighbor, new Node(neighbor.val));
      cur.neighbors.add(map.get(neighbor));
      dfs(map.get(neighbor), visited, map, neighbor.neighbors);
    }
  }

  public Node cloneGraph(Node node) {
    if(node==null) return null;
    Node res= new Node(node.val);
    Set<Node> visitedNodes= new HashSet<>();
    Map<Node,Node> map=new HashMap<>();
    Node curNode=res;
    map.put(node,curNode);
    dfs(curNode, visitedNodes, map, node.neighbors);
    return res;
  }
 private class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}


