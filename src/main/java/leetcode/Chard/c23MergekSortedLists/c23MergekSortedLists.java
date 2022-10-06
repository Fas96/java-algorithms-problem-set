package leetcode.Chard.c23MergekSortedLists;

import java.util.PriorityQueue;

public class c23MergekSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> ans = new PriorityQueue<Integer>();
        for (ListNode ls:lists) {
            System.out.println(ls);
            while (ls.next!=null){
                int val=ls.val;
                System.out.println(val);
            }
        }
        return  null;
    }

}
