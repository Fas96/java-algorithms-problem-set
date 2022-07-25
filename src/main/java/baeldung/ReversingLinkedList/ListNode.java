package baeldung.ReversingLinkedList;

import lombok.Data;

@Data
public class ListNode {

  private int data;
  private ListNode next;

  ListNode(int data) {
    this.data = data;
    this.next = null;
  }

}