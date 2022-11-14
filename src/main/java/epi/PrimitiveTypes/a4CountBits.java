package epi.PrimitiveTypes;

import org.junit.Test;

public class a4CountBits {
    @Test
    public void testCountBits() {
        System.out.println(countBits(8));
        System.out.println(~(8));


    }

    private short countBits(int x) {
        short numBits=0;
        while (x!=0){
            numBits+=(x&1);
            x>>>=1;
        }
        return numBits;
    }
}
