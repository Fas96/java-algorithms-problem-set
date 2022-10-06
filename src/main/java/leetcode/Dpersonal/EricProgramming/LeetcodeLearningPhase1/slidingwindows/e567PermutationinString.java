package leetcode.Dpersonal.EricProgramming.LeetcodeLearningPhase1.slidingwindows;

import java.util.HashMap;
import java.util.Map;

public class e567PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> s1A=new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1A.merge(s1.charAt(i),1,Integer::sum);
        }

        return false;
    }
}
