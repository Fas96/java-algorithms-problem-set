package leetcode.Eweekly.w314;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class Q3 {
    @Test
    public void testSol(){
        assertEquals("addb",robotWithString("bdda"));
    }

    public String robotWithString(String s) {

        String p="";
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)<s.charAt(j)) {
                 p=p+s.charAt(i);
                i++;
            }else{
                p=p+s.charAt(j);
                j--;
            }
        }
        return p;





    }

//    public String robotWithString(String s) {
//        //Perform one of the operations greedily,until s and t are both empty:
//        //Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
//        //Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
//
//    }
}
