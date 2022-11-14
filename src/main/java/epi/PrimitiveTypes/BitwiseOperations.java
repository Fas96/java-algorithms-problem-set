package epi.PrimitiveTypes;

public class BitwiseOperations {

    public void Operations(){
        // Initial values
        int a = 5;
        int b = 7;

        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));

        // bitwise not
        // ~00000000 00000000 00000000 00000101=11111111 11111111 11111111 11111010
        // will give 2's complement (32 bit) of 5 = -6
        System.out.println("~a = " + ~a);

        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b
        a &= b;
        System.out.println("a= " + a);
    }

    public void bitWiseOperationsDemo(){
        String binary[]={
                "0000","0001","0010","0011","0100","0101",
                "0110","0111","1000","1001","1010",
                "1011","1100","1101","1110","1111"
        };

        // initializing the values of a and b
        int a=3; // 0+2+1 or 0011 in binary
        int b=6; // 4+2+0 or 0110 in binary

        // bitwise or
        int c= a | b;

        // bitwise and
        int d= a & b;

        // bitwise xor
        int e= a ^ b;

        // bitwise not
        int f= (~a & b)|(a &~b);
        int g= ~a & 0x0f;


        System.out.println(" a= "+binary[a]);
        System.out.println(" b= "+binary[b]);
        System.out.println(" a|b= "+binary);
        System.out.println(" a&b= "+binary[d]);
        System.out.println(" a^b= "+binary[e]);
        System.out.println("~a & b|a&~b= "+binary[f]);
        System.out.println("~a= "+binary[g]);
    }
}
