package AATemplates.ACHEATSHEET.QInputIsALinkedList;

public class QInputIsALinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) { val = x; this.next = next; }
    }
    // before: 1-2-3-4-5-6-7
    void traverse(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head, dummy = new ListNode(0, head);
        // puts slow in the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //        d h     s     f
        // after: 0-1-2-3-4-5-6-7
    }
}
