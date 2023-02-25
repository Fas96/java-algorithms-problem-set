package leetcode.Y2023.daily.deasy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q989AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
       return String.valueOf((new BigInteger(Arrays.stream(num).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString())).add(new BigInteger(String.valueOf(k)))).chars().mapToObj(c -> c - '0').collect(Collectors.toList());
    }

}
