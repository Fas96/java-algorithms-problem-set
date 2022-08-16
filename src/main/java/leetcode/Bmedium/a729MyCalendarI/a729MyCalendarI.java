package leetcode.Bmedium.a729MyCalendarI;

import org.junit.Test;

public class a729MyCalendarI {

  public static void main(String[] args) {
    MyCalendar obj = new MyCalendar();
//    [], [10, 20], [15, 25], [20, 30
   boolean param_1 = obj.book(10,20);
   boolean param_2 = obj.book(15,25);
   boolean param_3 = obj.book(20,30);
    System.out.println(param_1);
    System.out.println(param_2);
    System.out.println(param_3);
  }

}
