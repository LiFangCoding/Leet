package _151_200;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 */

public class _172_FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int count = 0;

        /**
         * be careful with n != 0
         */
        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
