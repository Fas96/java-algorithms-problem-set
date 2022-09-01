package leetcode.Dpersonal.EricProgramming.LeetcodeFundamental.TopologicalSorting.leecodeExample;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

public class e207CourseSchedule {
  @Test
  public void canFinishFalse(){
    assertEquals(false,canFinish(2,new int[][]{
        {1,0},{0,1},{0,1},{0,1},{0,1}
    }));

  }


  @Test
  public void canFinishTrue(){
    assertEquals(true,canFinish(2,new int[][]{
        {1,0}
    }));

  }
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] table= new int[numCourses];
    for (int[] course : prerequisites) {
      int curCourse= course[0];
      table[curCourse]++;
    }
    System.out.println(Arrays.toString(table));
    Set<Integer> noIncomingEdges= new HashSet<>();
    //find elements that has no incoming edges
    for (int i = 0; i < numCourses; i++) {
      if(table[i]==0)noIncomingEdges.add(i);
    }
    System.out.println(noIncomingEdges);
    System.out.println("::::No incoming edges::::");
    //if set is empty that means we have cyclic graph
    if(noIncomingEdges.isEmpty())return false;

    while (!noIncomingEdges.isEmpty()){
      Iterator<Integer> it=noIncomingEdges.iterator();
      Integer element=  it.next();
      //remove the edges the current element has
      for (int course = 0; course < prerequisites.length; course++) {
        //check if prerequisite is equals to current element
        if(prerequisites[course][1]==element){
          int curCourse=prerequisites[course][0];
          //remove the incoming edges of this current course
          table[curCourse]--;
          if(table[curCourse]==0){
            noIncomingEdges.add(curCourse);
          }
        }
      }
      noIncomingEdges.remove(element);
    }

    //check if there is cycle
    for (int course :table) {
      if(course>0)return false;
    }
    return  Arrays.stream(table).allMatch(e->e<=0);

  }

}
