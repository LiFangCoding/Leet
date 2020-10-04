package leet._351_400;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: a = 2, b = [3]
 * Output: 8
 * Example 2:
 * <p>
 * Input: a = 2, b = [1,0]
 * Output: 1024
 * Example 3:
 * <p>
 * Input: a = 1, b = [4,3,3,8,5,2]
 * Output: 1
 * Example 4:
 * <p>
 * Input: a = 2147483647, b = [2,0,0]
 * Output: 1198
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _372_Super_Pow {
    static class Solution {
        static int p = 1337;

        int qmi(int a, int b) {
            a %= p;
            int res = 1;
            while (b != 0) {
                if ((b & 1) != 0) {
                    res = res * a % p;
                }
                a = a * a % p;
                b >>= 1;
            }
            return res;
        }

        public int superPow(int a, int[] b) {
            return helper(a, b, b.length - 1);
        }

        private int helper(int a, int[] b, int n) {
            if (n == -1) return 1;
            int k = b[n];
            return qmi(helper(a, b, n - 1), 10) * qmi(a, k) % p;

        }
    }
}
