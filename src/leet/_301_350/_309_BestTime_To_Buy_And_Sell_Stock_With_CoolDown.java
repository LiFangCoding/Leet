package leet._301_350;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _309_BestTime_To_Buy_And_Sell_Stock_With_CoolDown {
    /**
     * 1ms
     * T = n
     * 状态机
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int INF = Integer.MIN_VALUE;

        int[][] f = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][1] = -prices[0];
        f[0][0] = 0;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
            f[i][2] = f[i - 1][1] + prices[i];
        }

        return Math.max(Math.max(f[n - 1][0], f[n - 1][1]), f[n - 1][2]);
    }
}
