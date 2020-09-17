package leet._251_300;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 * [-2,0,3]
 * Follow up: Could you solve it in O(n2) runtime?
 */
public class _259_3SumSmaller {
    public int threeSumSmaller(int[] A, int target) {
        int count = 0;

        if (A == null || A.length == 0) {
            return count;
        }

        Arrays.sort(A);
        int len = A.length;
        for (int i = 0; i < len - 2; i++) {
            for (int l = i + 1, r = len - 1; l < r; ) {
                int sum = A[i] + A[l] + A[r];
                if (sum < target) {
                    // 1 2 3 4  t = 5
                    count += (r - l);
                    l++;
                } else {
                    r--;
                }
            }
        }

        return count;
    }
}
