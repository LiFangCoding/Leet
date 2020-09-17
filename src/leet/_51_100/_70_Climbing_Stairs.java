package leet._51_100;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _70_Climbing_Stairs {
    public int climbStairs(int n) {
        /**
         * f(n) = f(n - 1) + f(n - 2)
         */
        int[] f = new int[n + 1];
        if (n <= 2) {
            return n;
        }

        /**
         * !!! be careful, if n == 1, no f[2] index.
         */
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }

        return f[n];
    }
}
