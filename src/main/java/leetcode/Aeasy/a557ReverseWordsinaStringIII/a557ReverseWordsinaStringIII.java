package leetcode.Aeasy.a557ReverseWordsinaStringIII;

import org.junit.Test;

public class a557ReverseWordsinaStringIII {
    //test
    public String reverseWords(String s) {

        StringBuilder an=new StringBuilder();
        for (String str:s.split(" ")){
            an.append((new StringBuilder(str)).reverse()+" ");
        }

        return an.toString().trim();
    }
    @Test
    public void testreverseWords(){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }


}
