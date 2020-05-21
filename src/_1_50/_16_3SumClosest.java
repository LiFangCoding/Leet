package _1_50;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _16_3SumClosest {
  public int threeSumClosest(int[] A, int target) {
    if (A == null || A.length < 3) {
      return -1;
    }

    Arrays.sort(A);

    int len = A.length;
    int ans = A[0] + A[1] + A[2];

    for (int i = 0; i < len - 2; i++) {
      // [-1,2,1,-4]. 1. output: 0 exp: 2
      // here is the problem. l should be i + 1, not l = 0
      for (int l = i + 1, r = len - 1; l < r; ) {
        int sum = A[i] + A[l] + A[r];

        if (Math.abs(ans - target) > Math.abs(sum - target)) {
          ans = sum;
        }

        if (sum == target) {
          return sum;
        } else if (sum > target) {
          r--;
        } else {
          l++;
        }
      }
    }

    return ans;
  }
}
