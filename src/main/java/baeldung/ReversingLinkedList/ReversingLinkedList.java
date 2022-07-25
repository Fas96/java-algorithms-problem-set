package baeldung.ReversingLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

//two linked list reversal algorithms
public class ReversingLinkedList {
  @Test
  public void givenLinkedList_whenIterativeReverse_thenOutputCorrectResult() {
    ListNode head = constructLinkedList();
    ListNode node = head;
    for (int i = 1; i <= 5; i++) {
      assertNotNull(node);
      assertEquals(i, node.getData());
      node = node.getNext();
    }

    ReversingLinkedList reversal = new ReversingLinkedList();
    node = reversal.reverseList(head);

    for (int i = 5; i >= 1; i--) {
      assertNotNull(node);
      assertEquals(i, node.getData());
      node = node.getNext();
    }
  }
  @Test
  public void givenLinkedList_whenRecursiveReverse_thenOutputCorrectResult() {
    ListNode head = constructLinkedList();
    ListNode node = head;
    for (int i = 1; i <= 5; i++) {
      assertNotNull(node);
      assertEquals(i, node.getData());
      node = node.getNext();
    }

    ReversingLinkedList reversal = new ReversingLinkedList();
    node = reversal.reverseListRecursive(head);

    for (int i = 5; i >= 1; i--) {
      assertNotNull(node);
      assertEquals(i, node.getData());
      node = node.getNext();
    }
  }
  ListNode constructLinkedList() {
    ListNode head = null;
    ListNode tail = null;
    for (int i = 1; i <= 5; i++) {
      ListNode node = new ListNode(i);
      if (head == null) {
        head = node;
      } else {
        tail.setNext(node);
      }
      tail = node;
    }
    return head;
  }

  //iterative Implementation
  ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    while (current != null) {
      ListNode nextElement = current.getNext();
      //turning the pointer of current node to previous
      current.setNext(previous);
      //previous pointer to current
      previous = current;
      //current pointer to next in LinkedList
      current = nextElement;
    }
    return previous;
  }
  //recursive implementation
  ListNode reverseListRecursive(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.getNext() == null) {
      return head;
    }
    ListNode node = reverseListRecursive(head.getNext());
    head.getNext().setNext(head);
    head.setNext(null);
    return node;
  }

}
