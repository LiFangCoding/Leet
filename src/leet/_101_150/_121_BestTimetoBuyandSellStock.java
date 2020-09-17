package leet._101_150;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class _121_BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        _121_BestTimetoBuyandSellStock test = new _121_BestTimetoBuyandSellStock();
        System.out.println(test.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(test.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, curProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
