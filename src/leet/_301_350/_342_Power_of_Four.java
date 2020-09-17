package leet._301_350;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _342_Power_of_Four {
    /**
     * (数论) O(1)O(1)
     * 这道题目类似于LeetCode 326. Power of Three。
     * <p>
     * n 是4的整数次幂，等价于 n 是平方数，且 n 的质因子只有2。
     * <p>
     * int范围内，2的最大的整数次幂是 2^30，所以 n 的质因子只有2，等价于 n 能整除 2^30。
     * <p>
     * 时间复杂度分析：只有常数次计算，所以时间复杂度是 O(1)
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        int t = (int) Math.sqrt(num);
        return t * t == num && ((1 << 30) % num == 0);
    }
}
