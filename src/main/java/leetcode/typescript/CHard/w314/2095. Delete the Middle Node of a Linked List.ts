
  class ListNode {
      val: number
      next: ListNode | null
      constructor(val?: number, next?: ListNode | null) {
          this.val = (val===undefined ? 0 : val)
          this.next = (next===undefined ? null : next)
      }
  }


function deleteMiddle(head: ListNode | null): ListNode | null {
    let slow=head;
    let fast=head;
    let prev=null;
    //if head is null or head.next is null, return head
    if(head.next==null){
        return null;
    }
    while(fast!=null&&fast.next!=null){
        prev=slow;
        slow=slow.next;
        fast=fast.next.next;
    }
    prev.next=slow.next;
    return head;

};