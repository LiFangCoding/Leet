package leet._301_350;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _343_Integer_break {
    class Sol_n {
        public int integerBreak(int n) {
            if (n <= 3) return 1 * (n - 1);
            int p = 1;
            while (n >= 5) {
                n -= 3;
                p *= 3;
            }
            return p * n;
        }
    }

    class Sol_dp {
        public int integerBreak(int n) {
            //f = f[ i - j]
            int[] f = new int[n + 1];

            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = i - 1; j >= 1; j--) {
                    // just two integers
                    f[i] = Math.max(f[i], j * (i - j));
                    // divide f[j]
                    f[i] = Math.max(f[i], f[j] * (i - j));
                }
            }

            return f[n];
        }
    }
}
