package leet._201_250;

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
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if ((m >> i & 1) != (n >> i & 1))
                break;
            if ((m >> i & 1) != 0)
                res += 1 << i;
        }
        return res;
    }
}
