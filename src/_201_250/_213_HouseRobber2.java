package _201_250;

import java.util.Arrays;

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

        if (A.length == 1) {
            return A[0];
        }
        int len = A.length;
        int ans1 = robOneWay(Arrays.copyOfRange(A, 0, len - 1));
        int ans2 = robOneWay(Arrays.copyOfRange(A, 1, len));
        return Math.max(ans1, ans2);
    }

    public int robOneWay(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        //!!!
        if (len == 1) {
            return A[0];
        }

        /**
         * f[i] means until the ith index, the maximum rob
         */
        int[] f = new int[len];
        f[0] = A[0];
        f[1] = Math.max(A[0], A[1]);

        for (int i = 2; i < len; i++) {
            f[i] = Math.max(f[i - 2] + A[i], f[i - 1]);
        }

        return f[len - 1];
    }
}
