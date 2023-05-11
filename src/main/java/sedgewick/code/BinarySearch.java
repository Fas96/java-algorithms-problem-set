package sedgewick.code;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;

import java.util.Arrays;
public class BinarySearch
{
    public static int rank(int key, int[] a)
    {  // Array must be sorted.
        int lo  = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1; }
    @Test
    public  void test() {
        int[] whitelist = {1, 2, 4, 4, 4, 4, 4, 21, 22, 323, 2, 32, 3, 23, 2, 3, 23};
        System.out.println(Math.abs(-2147483648));
        Arrays.sort(whitelist);
        System.out.println(1.0/0.0);
        StdOut.println(Arrays.toString(whitelist));

        System.out.println(14/3);
        System.out.println(((2/3)*3)+(2%3));
        System.out.println((2%3));
        System.out.println("===============");

        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.printf("%d, ",f);
            f = f + g;
            g = f - g;
        }

        System.out.println("===============");
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        System.out.println("===============");
        int N=89;
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        System.out.println(s);
        System.out.println("===============");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < 10; i++){
            StdOut.printf("%d. ",a[i]);
            a[i] = a[a[i]];}
        System.out.println("==");
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++)
            StdOut.printf("%d, ",a[i]);

        System.out.println("===============");
        mystery(3,10);
        System.out.println("===============");
        System.out.println( exR1(5));
    }
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
    public static int mystery(int a, int b)
    {
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
}
