package _501_550;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 *  
 * <p>
 * Note:
 * <p>
 * You can assume that
 * <p>
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _518_Coin_Change2 {
  public int change(int target, int[] coins) {
    int n = coins.length;

    // the first ith conins for the amount how mnay number of combinations
    int[][] dp = new int[n + 1][target + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        dp[i][j] = dp[i - 1][j];

        // the index in coins is i - 1. i is the first i chars
        int coinVal = coins[i - 1];
        if (j - coinVal >= 0) {
          // can use the first infinite number
          dp[i][j] += dp[i][j - coinVal];
        }
      }
    }

    return dp[n][target];
  }
}
