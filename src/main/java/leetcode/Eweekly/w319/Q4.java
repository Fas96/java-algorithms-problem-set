package leetcode.Eweekly.w319;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Q4 {
    @Test
    public void testSol(){
        assertEquals(4,maxPalindromes("fttfjofpnpfydwdwdnns",2));
    }
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        //use dfs
        int[] count=new int[26];


        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
        }
        int[] odd=new int[26];
        int[] even=new int[26];
        for(int i=0;i<26;i++){
            odd[i]=count[i]/2;
            even[i]=count[i]-odd[i];
        }
        int[] oddCount=new int[1];
        int[] evenCount=new int[1];



//        Set<String> palindromes=new HashSet<>();
//
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                if(isPalindrome(s,i,j)){
//                    if(j-i+1>=k && isPalindrome(s.substring(i,j+1))){
//                        palindromes.add(s.substring(i,j+1));
//                    }
//                }
//            }
//            for(int j=i;j>=0;j--){
//                if(isPalindrome(s,j,i)){
//                    if(j-i+1>=k && isPalindrome(s.substring(i,j+1))){
//                        palindromes.add(s.substring(j,i+1));
//                    }
//                }
//            }
//        }
//
//        Set<String> uniquePalindroms=new HashSet<>();
//        for(String p:palindromes){
//            boolean isUnique=true;
//            for(String p2:palindromes){
//                if(p2.length()>p.length() && p2.contains(p)){
//                    isUnique=false;
//                    break;
//                }
//            }
//            if(isUnique){
//                uniquePalindroms.add(p);
//            }
//        }
//
//
//
//        return uniquePalindroms.size();
        return 0;


    }

    private boolean isPalindrome(String s) {
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j) {

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
