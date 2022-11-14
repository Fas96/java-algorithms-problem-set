package leetcode.Chard.a899OrderlyQueue;

import java.util.Arrays;

public class a899OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if(k==1){
            String ans=s;
            for(int i=0;i<s.length();i++){
                String temp=s.substring(i)+s.substring(0,i);
                if(temp.compareTo(ans)<0){
                    ans=temp;
                }
            }
            return ans;
        }else{
            char[] c=s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }

    }
}
