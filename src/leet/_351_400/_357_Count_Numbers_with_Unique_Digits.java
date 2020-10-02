package leet._351_400;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _357_Count_Numbers_with_Unique_Digits {
    //选数字 0- 10^n - 1
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        //n位数的个数
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 9;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * (11 - i);
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += f[i];
        }
        return res;
    }
}
