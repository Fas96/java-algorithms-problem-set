package hackerrank.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Breakingbestandworstrecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        List<Integer> temp=scores;
        Collections.sort(temp);
        int min=temp.get(0);
        int max=temp.get(temp.size()-1);
        System.out.println(max);
        System.out.println(min);

        return Arrays.asList(scores.lastIndexOf(max),scores.lastIndexOf(min));

    }
    @Test
    public void  testBreakingbestandworstrecords(){
        System.out.println(breakingRecords(Arrays.asList(10 ,5 ,20, 20, 4 ,5 ,2 ,25, 1)));
    }

}
