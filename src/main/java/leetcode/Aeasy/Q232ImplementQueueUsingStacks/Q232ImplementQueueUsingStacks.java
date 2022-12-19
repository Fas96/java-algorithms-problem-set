package leetcode.Aeasy.Q232ImplementQueueUsingStacks;

import java.util.Stack;

public class Q232ImplementQueueUsingStacks {
    Stack<Integer> back= null;
    Stack<Integer> front=null;


    public Q232ImplementQueueUsingStacks() {
        back=new Stack<>();
        front= new Stack<>();
    }

    public void push(int x) {
        front.push(x);
    }

    public int pop() {
       if (back.size()==0){
           while (front.size()>0) back.add(front.pop());
       }
        return back.pop();
    }

    public int peek() {
        if (back.size()==0){
            while (front.size()>0) back.add(front.pop());
        }
        return  back.peek();
    }

    public boolean empty() {
        return back.size()+front.size()==0;
    }
}
