package leetcode.Bmedium.a2AddTwoNumbers;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class a2AddTwoNumbers {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          List<Integer> f= new LinkedList<>();
          List<Integer> s= new LinkedList<>();
          ListNode tf=l1;
          while (tf!=null){
              f.add(tf.val);
              tf=tf.next;
          }
        ListNode st=l2;
        while (st!=null){
            f.add(st.val);
            st=st.next;
        }

        BigInteger bigIntegerFromByte = BigInteger.valueOf(0);
        int totalF = 0;
        for (Integer i : f) {
            totalF = 10*totalF + i;
        }
        int totalS = 0;
        for (Integer i : s) {
            totalS = 10*totalS + i;
        }
        int Sum = reverseANum(totalF)+ reverseANum(totalS);
        List<Integer> cb= Arrays.stream((Sum+"").split("\\B")).map(Integer::valueOf).collect(Collectors.toList());

        ListNode dum = new ListNode(-1);
        ListNode res=dum;
        List<Integer> list =cb.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for (int i : list){
            res.next=new ListNode(i);
            res=res.next;
        }



        return res.next;

    }
    private int reverseANum(int num){
        int  reversed = 0;

        for(;num != 0; num /= 10) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
        }

        return  reversed;
    }
}
