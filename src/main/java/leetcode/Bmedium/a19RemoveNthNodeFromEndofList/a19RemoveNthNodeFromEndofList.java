package leetcode.Bmedium.a19RemoveNthNodeFromEndofList;

import java.util.LinkedList;
import java.util.List;

public class a19RemoveNthNodeFromEndofList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
          List<ListNode> getList= new LinkedList<>();
          ListNode temp=head;
          while (temp!=null){
              getList.add(temp);
              temp=temp.next;
          }
          // remove the nth node from the end
//            int index=getList.size()-n;
//            if (index==0){
//                head=head.next;
//            }else {
//                getList.get(index-1).next=getList.get(index).next;
//            }
//            return head;

          //create ListNode and add getList to its next values to form answer
            ListNode answer=new ListNode();
            ListNode temp2=answer;
        System.out.println();
            for (int i = 0; i < getList.size(); i++) {
                temp2.next=getList.get(i);
                temp2=temp2.next;
            }
            return answer.next;

    }
}
