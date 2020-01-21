package _201_250;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 */
public class _231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
