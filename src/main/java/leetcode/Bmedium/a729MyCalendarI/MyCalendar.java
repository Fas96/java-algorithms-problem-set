package leetcode.Bmedium.a729MyCalendarI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class MyCalendar {
  List<Integer> calKeeper;
  public MyCalendar() {
   calKeeper= new ArrayList<>();
    Collections.fill(calKeeper,-1);

  }

  public boolean book(int start, int end) {


    List<Integer> check= new ArrayList<>(calKeeper.subList(start,end));
    boolean anyMatch = check.stream().distinct().anyMatch(x->x!=-1);
    if(anyMatch){
      return false;
    }else{
       check.stream().map(x->x=1).collect(Collectors.toList());
      return true;
    }

  }
}
