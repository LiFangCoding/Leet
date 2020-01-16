package _151_200;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [0,1]
 * Output: 0
 */
public class _201_BitwiseANDofNumbersRange {
    //TODO: haojun, need more time
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;

        while (m < n) {
            res = n & (n - 1);
            n = res;
        }
        return n;
    }
}