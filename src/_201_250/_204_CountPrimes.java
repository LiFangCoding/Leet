package _201_250;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class _204_CountPrimes {
    public int countPrimes_faster(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        /**
         * Here is because find all primes less than n.
         * i * i < n is also ok.
         * To be safe, just add <=.
         */
        for (int i = 2; i * i <= n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        /**
         * No need to find primes equal square(n)
         */
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }

    public int countPrimes(int n) {
        /**
         * true means not prime
         * false means is prime
         *
         * default, all are primes
         */
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;

                for (int j = 2 * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return count;
    }
}
