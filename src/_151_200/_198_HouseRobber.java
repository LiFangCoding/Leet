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
  class Sol_easy_no_bug {
    public int rob(int[] A) {
      if (A == null || A.length == 0) {
        return 0;
      }

      int len = A.length;
      //f[i] = max(f[i - 2] + A[i] ,f[i - 1])
      int[] f = new int[len];

      int ans = 0;
      for (int i = 0; i < len; i++) {
        if (i == 0) {
          f[i] = A[i];
        } else if (i == 1) {
          f[i] = Math.max(f[i - 1], A[i]);
        } else {
          f[i] = Math.max(f[i - 2] + A[i], f[i - 1]);
        }
        ans = Math.max(ans, f[i]);
      }

      return ans;
    }
  }

  public int rob(int[] A) {
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
