package _251_300;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class _279_PerfectSquares {
    /**
     * //        f[0] = 0;
     * //        f[1] = 1;
     * //        f[2] = 2;
     * //        f[3] = 3;
     * //        f[4] = 1;
     * //        f[5] = 2;
     * //        f[6]= 3
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        /**
         * remember to give max val
         */
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }

        return f[n];
    }
}
