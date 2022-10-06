package leetcode.Bmedium.a430FlattenaMultilevelDoublyLinkedList;

public class a430FlattenaMultilevelDoublyLinkedList {
public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next;
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                while (cur.next != null) cur = cur.next;
                cur.next = next;
                if (next != null) next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

}
