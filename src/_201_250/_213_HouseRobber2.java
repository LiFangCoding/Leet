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
    public int rob(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        /**
         * Think about the house i is robbed or not
         */
        int n = A.length;
        if (n == 1) {
            return A[0];
        }

        if (n == 2) {
            return Math.max(A[0], A[1]);
        }

        int res = 0;
        return -1;
    }
}
