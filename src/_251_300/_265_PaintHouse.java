package _251_300;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * <p>
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 *              Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class _265_PaintHouse {
    /**
     * 3ms
     * T = n * k
     * S = k
     * https://www.jiuzhang.com/solution/paint-house-ii/
     * https://www.acwing.com/solution/content/8126/
     */
    public int minCostII(int[][] costs) {

        int n = costs.length;

        if (n == 0) {

            return 0;

        }

        int k = costs[0].length;

        //dp[i][j]表示第i幢房子涂j的颜色最小的总和

        //初始化状态dp[0][i]=costs[0][i]

        int[][] dp = new int[2][k];

        for (int i = 0; i < k; i++) {

            dp[0][i] = costs[0][i];

        }

        int mi, sec_mi;

        for (int i = 1; i < n; i++) {

            //mi表示最小值，sec_mi表示次小值

            mi = Integer.MAX_VALUE;

            sec_mi = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {

                if (dp[i & 1 ^ 1][j] <= mi) {

                    sec_mi = mi;

                    mi = dp[i & 1 ^ 1][j];

                } else if (dp[i & 1 ^ 1][j] < sec_mi) {

                    sec_mi = dp[i & 1 ^ 1][j];

                }

            }

            for (int j = 0; j < k; j++) {

                //若最小值与当前要涂的颜色相同

                if (dp[i & 1 ^ 1][j] == mi) {

                    dp[i & 1][j] = sec_mi + costs[i][j];

                } else {

                    dp[i & 1][j] = mi + costs[i][j];

                }

            }

        }

        mi = Integer.MAX_VALUE;

        for (int j = 0; j < k; j++) {

            mi = Math.min(mi, dp[n & 1 ^ 1][j]);

        }

        return mi;

    }
}
