package Algoritms.UnionFind.code;

import java.util.HashMap;
import java.util.Map;

public class DisjointNodeSet {
    private Map<Integer, Node> nodes;

    public DisjointNodeSet() {
        nodes = new HashMap<>();
    }

    // Find the representative element of the set that x belongs to
    public int find(int x) {
        if (!nodes.containsKey(x)) {
            nodes.put(x, new Node(x, x, 0));
            return x;
        }
        Node node = nodes.get(x);
        if (node.parent == x) {
            return x;
        }
        int root = find(node.parent);
        node.parent = root;
        return root;
    }

    // Merge the sets that x and y belong to
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        Node nodeX = nodes.get(rootX);
        Node nodeY = nodes.get(rootY);
        if (nodeX.rank < nodeY.rank) {
            nodeX.parent = rootY;
        } else if (nodeX.rank > nodeY.rank) {
            nodeY.parent = rootX;
        } else {
            nodeY.parent = rootX;
            nodeX.rank++;
        }
    }

    // Inner class representing a node in the disjoint set
    private static class Node {
        int data;
        int parent;
        int rank;

        public Node(int data, int parent, int rank) {
            this.data = data;
            this.parent = parent;
            this.rank = rank;
        }
    }
}

