package _201_250;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class _213_HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        // important
        if (n == 1) return nums[0];

        int[] f = new int[n + 1];
        int[] g = new int[n + 1];

        // do not select idx 0
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        int res = Math.max(f[n], g[n]);

        // must select idx 0
        f[1] = nums[0];
        g[1] = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        res = Math.max(res, g[n]);
        return res;
    }
}
