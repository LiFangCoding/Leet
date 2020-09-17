package leet._301_350;

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
     * 设状态 f(i) 表示第 i 天结束后不持有股票的最大收益；
     * g(i) 表示第 i 天结束后持有股票的最大收益。
     * 初始时，f(0)=0,g(0)=−prices[0]其余待定。
     * 转移时，f(i)=max(f(i−1),g(i−1)+prices[i]),表示第 i 天什么都不做，或者卖掉持有的股票。
     * g(i)=max(g(i−1),f(i−2)−prices[i])，表示第 i 天什么都不做，或者买当天的股票，
     * 但需要从上两天的结果转移。注意，如果 i<2，则 f(i−2) 当做 0。
     * 最终答案为 f(n−1)。
     * <p>
     * 作者：wzc1995
     * 链接：https://www.acwing.com/solution/content/343/
     * 来源：AcWing
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0) {
            return 0;
        }

        // 当天不持有
        int[] f = new int[n];
        // 当天持有
        int[] g = new int[n];

        f[0] = 0;
        g[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], g[i - 1] + prices[i]);
            if (i >= 2) {
                g[i] = Math.max(g[i - 1], f[i - 2] - prices[i]);
            } else {
                g[i] = Math.max(g[i - 1], -prices[i]);
            }
        }

        return f[n - 1];
    }
}
