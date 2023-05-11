package sedgewick.code;

import org.junit.Test;

import java.util.Arrays;

public class ImplementationOfCOdeFragment {
    public int findtheMaxOfArrays(int[] A){
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) max = A[i];
        }
        return max;
    }
    public double computeAverageOfValues(double[] A){
        double sum = 0.0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum / A.length;
    }
    public double[] copyArray(double[] A){
        int N = A.length;
        double[] B = new double[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i];
        }
        return B;
    }
    public double[] reverseArray(double[] A){
        int N = A.length;
        double[] B = new double[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[N - i - 1];
        }
        return B;
    }
    public double[][] matrixMultiplication(double[][] A, double[][] B){
        int M = A.length;
        int N = B[0].length;
        double[][] C = new double[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;

    }
    @Test
    public void test_matrixMultiplication(){
        double[][] A = {{1, 2, 3}, {4, 5, 6}};
        double[][] B = {{1, 2}, {3, 4}, {5, 6}};
        double[][] C = matrixMultiplication(A, B);
        System.out.println(Arrays.deepToString(C)); 
    }
}
