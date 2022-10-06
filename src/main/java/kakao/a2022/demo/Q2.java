package kakao.a2022.demo;

import org.junit.Test;

import java.util.Scanner;

public class Q2 {
    @Test
    public void testPrintTriangle(){
        printTriangle();
    }

    private void printTriangle() {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
        int a=3;
        //print triangle of *
        for (int i = 1; i <=a; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = i; j < a ; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
