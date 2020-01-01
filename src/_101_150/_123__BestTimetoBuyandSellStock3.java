package _101_150;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class _123__BestTimetoBuyandSellStock3 {
    public static void main(String[] args) {
        _123__BestTimetoBuyandSellStock3 test = new _123__BestTimetoBuyandSellStock3();
        System.out.println("res should be " + 6);
        System.out.println(test.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println("res should be " + 4);
        System.out.println(test.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println("res should be " + 0);
        System.out.println(test.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        if (len < 2) {
            return res;
        }
        /**
         * from 0 - ith day, the maximum profit
         * f[i] = max(f[i - 1], prices[i] - minof (0 ~ i - 1))
         */
        int[] f = new int[len];
        /**
         * g[i] = from ith day to last day, the max profit
         * g[i] = max(g[i + 1], max(i+1 ~ len - 1) - prices[i])
         */
        int[] g = new int[len];

        int low = prices[0];
        for (int i = 1; i < len; i++) {
            low = Math.min(low, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - low);
        }

        int high = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            high = Math.max(high, prices[i]);
            g[i] = Math.max(g[i + 1], high - prices[i]);
        }

        for (int i = 0; i < len; i++) {
            res = Math.max(res, f[i] + g[i]);
        }

        return res;
    }
}
