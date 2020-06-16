package _251_300;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * <p>
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note:
 * n and k are non-negative integers.
 * <p>
 * Example:
 * <p>
 * Input: n = 3, k = 2
 * Output: 6
 * Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
 * <p>
 *             post1  post2  post3
 * -----      -----  -----  -----
 * 1         c1     c1     c2
 *    2         c1     c2     c1
 *    3         c1     c2     c2
 *    4         c2     c1     c1 
 * 5         c2     c1     c2
 *    6         c2     c2     c1
 */
public class _276_PaintFence {
    /**
     * 0ms
     * T = n
     * 采用动态规划的思想。 dpi=(k-1)×(dpi-1+dpi-2) dpi-1×(k-1)代表当前格子的颜色和前一个不同的方案 dpi-2×(k-1)代表当前格子的颜色和前一个相同的方案
     * https://www.jiuzhang.com/solution/paint-fence/
     * https://www.acwing.com/solution/content/8128/
     */
    public int numWays(int n, int k) {
        // Write your code here
        int[] dp = {0, k, k * k, 0};
        if (n <= 2) {
            return dp[n];
        }
        if (k == 1) {
            return 0;
        }
        for (int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }

        return dp[3];
    }
}
