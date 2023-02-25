package leetcode.Y2023.daily.deasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class Q2160MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        List<Integer> sb=new ArrayList<>();
        while (num>0){
            sb.add(num%10);
            num/=10;
        }

        sb.sort(Integer::compareTo);


       int n=sb.size();

        return Integer.parseInt(sb.get(0)+""+sb.get(n-1)) + Integer.parseInt(sb.get(1)+""+sb.get(n-2));

    }
}
