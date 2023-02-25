package leetcode.Y2023.daily.deasy;

import java.math.BigInteger;

public class Q67AddBinary {
    public String addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger b1 = new BigInteger(b, 2);
        BigInteger c = a1.add(b1);
        return c.toString(2);
    }
}
