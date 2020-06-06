package _251_300;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * <p>
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 */
public class _256_paint_house {
    /**
     * 2ms
     * T = n
     * dp[i][j]表示第i行第j列的最小cost。
     * 由于相邻两行不能在同一列选择，所以dp[i][j]来自dp[i-1][j+1]或者dp[i-1][j+2]。
     * 考虑到j+1和j+2不能越界，取模3即可。
     */
    public int minCost(int[][] costs) {
        int n = costs.length;

        if (n == 0) {
            return 0;
        }

        // f[i][j] 表示第i行第j列的最小cost
        int[][] f = new int[n][costs[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                f[i][j] = costs[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] += Math.min(f[i - 1][(j + 1) % 3], f[i - 1][(j + 2) % 3]);
            }
        }

        return Math.min(Math.min(f[n - 1][0], f[n - 1][1]), f[n - 1][2]);
    }
}
