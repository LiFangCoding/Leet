package _151_200;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class _198_HouseRobber {
  public int rob(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    int len = A.length;
    /**
     * !!! be careful the len
     */

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
