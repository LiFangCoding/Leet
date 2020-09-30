package leet._301_350;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class _303_RangeSumQuery_Immutable {

    class Sol_idx_from1 {
        class NumArray {
            int[] s;

            public NumArray(int[] nums) {
                int n = nums.length;
                s = new int[n + 1];
                // 数组下表改为从1开始
                for (int i = 1; i <= n; i++) {
                    s[i] = s[i - 1] + nums[i - 1];
                }
            }

            public int sumRange(int i, int j) {
                ++i;
                ++j;
                return s[j] - s[i - 1];
            }
        }
    }

    class Sol_idx_from0 {
        class NumArray {
            int[] sum;

            public NumArray(int[] A) {
                int[] sum = new int[A.length];

                for (int i = 0; i < A.length; i++) {
                    if (i == 0) {
                        sum[i] = A[i];
                    } else {
                        sum[i] = sum[i - 1] + A[i];
                    }
                }
            }

            // sum[j] - sum[i - 1]
            public int sumRange(int i, int j) {
                if (i == 0) {
                    return sum[j];
                } else {
                    return sum[j] - sum[i - 1];
                }
            }
        }
    }
}
