package epi.arrays;

import java.util.*;

public class GeneratePrimeNumbers {

    public List<Integer> generatePrimeNumbers(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int p = 2; p <= n; p++) {
            if (isPrime.get(p)) {
                primes.add(p);
                for (int i = p; i <= n; i += p) {
                    isPrime.set(i, false);
                }
            }
        }
        return primes;
    }

    public List<Integer> generatePrimeNumbers2(int n) {
       if(n < 2) {
           return Collections.emptyList();
       }
       int size = (n - 3) / 2 + 1;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
        for (int i = 0; i < size; i++) {
            if (isPrime.get(i)) {
                int p = 2 * i + 3;
                primes.add(p);
                for (int j = ((i * i) *2) + 6*i+3; j < size; j += p) {
                    isPrime.set(j, false);
                }
            }
        }

        return primes;
    }
}
