package leet._151_200;

import java.util.Arrays;

/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class _188_Best_Tiem_To_Buy_Sell_Stock4 {
    class Sol_ac {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (k >= n / 2) {
                int res = 0;
                for (int i = 1; i < n; i++) {
                    if (prices[i] > prices[i - 1]) {
                        res += prices[i] - prices[i - 1];
                    }
                }
                return res;
            }

            int MIN = (int) 1e8 * -1;
            //状态机起点是0
            int[][] f = new int[n + 1][k + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(f[i], MIN);
            }
            int[][] g = new int[n + 1][k + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(g[i], MIN);
            }
            f[0][0] = 0;
            int res = 0;
            for (int i = 1; i <= n; i++) {
                //
                for (int j = 0; j <= k; j++) {
                    // idx is fron i - 1
                    f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] + prices[i - 1]);
                    g[i][j] = g[i - 1][j];
                    if (j > 0) {
                        g[i][j] = Math.max(g[i][j], f[i - 1][j - 1] - prices[i - 1]);
                    }
                    res = Math.max(res, f[i][j]);
                }
            }
            return res;
        }
    }

    /**
     * TODO: haojun. Hard
     * https://www.acwing.com/solution/content/6308/
     * <p>
     * See later:
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-w-5/
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] dp = new int[2][n];

        for (int t = 1; t <= k; t++) {
            // 直接用max_val记录最大的dp[k-1][j] - prices[j]
            int maxVal = dp[(t - 1) % 2][0] - prices[0];

            // 省掉了一次枚举
            for (int i = 1; i < n; i++) {
                dp[t % 2][i] = Math.max(dp[t % 2][i - 1], maxVal + prices[i]);
                // 更新max_val
                maxVal = Math.max(maxVal, dp[(t - 1) % 2][i] - prices[i]);
            }
        }

        return dp[k % 2][n - 1];
    }
}
