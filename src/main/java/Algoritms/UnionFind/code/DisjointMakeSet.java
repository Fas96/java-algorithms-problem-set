package Algoritms.UnionFind.code;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DisjointMakeSet {
    private Map<Integer, Node> nodes;

    public DisjointMakeSet() {
        nodes = new HashMap<>();
    }

    // Find the representative element of the set that x belongs to
    public int findSet(int x) {
        if (!nodes.containsKey(x)) {
            makeSet(x);
            return x;
        }
        Node node = nodes.get(x);
        if (node.parent == x) {
            return x;
        }
        int root = findSet(node.parent);
        node.parent = root;
        return root;
    }

    // Add a new element to the disjoint set
    public void makeSet(int x) {
        nodes.put(x, new Node(x, x, 0));
    }

    // Merge the sets that x and y belong to
    public void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
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

    @Test
    public void test() {
        DisjointMakeSet disjointSet = new DisjointMakeSet();
        disjointSet.makeSet(1);
        disjointSet.makeSet(2);
        disjointSet.makeSet(3);
        disjointSet.makeSet(4);
        disjointSet.makeSet(5);
        disjointSet.makeSet(6);
        disjointSet.makeSet(7);
        disjointSet.union(1, 2);
        disjointSet.union(2, 3);
        disjointSet.union(4, 5);
        disjointSet.union(6, 7);
        disjointSet.union(5, 6);
        disjointSet.union(3, 7);
        assertEquals(1, disjointSet.findSet(1));
        assertEquals(1, disjointSet.findSet(2));
        assertEquals(1, disjointSet.findSet(3));
        assertEquals(1, disjointSet.findSet(4));
        assertEquals(1, disjointSet.findSet(5));
        assertEquals(1, disjointSet.findSet(6));
        assertEquals(1, disjointSet.findSet(7));
    }
}

