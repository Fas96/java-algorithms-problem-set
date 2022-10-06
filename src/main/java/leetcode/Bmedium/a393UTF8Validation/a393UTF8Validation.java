package leetcode.Bmedium.a393UTF8Validation;

import org.junit.Test;

public class a393UTF8Validation {
    public boolean validUtf8(int[] data) {
        for (int dat: data) {
            System.out.println(fixedLengthString(Integer.toBinaryString(dat)));
        }
        return false;
    }
    private  String fixedLengthString(String string) {
        return String.format("%8s", string).replace(' ', '0');
    }
    @Test
    public void validUtf8Test(){
        System.out.println(validUtf8(new int[]{197,130,1}));
    }
}
