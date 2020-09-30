package leet._251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class _300_Longest_increasing_subsequence {
    /**
     * T = nlogn
     */
    class Sol_greedy {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            List<Integer> q = new ArrayList<>();

            for (int x : nums) {
                // x append to last of q. lis Length is q.size() + 1
                if (q.isEmpty() || x > q.get(q.size() - 1)) {
                    q.add(x);
                } else {
                    // x<= . x will not be appended to another lis
                    if (x <= q.get(0)) {
                        q.set(0, x);
                    }
                    // find last postion < x
                    else {
                        int l = 0, r = q.size() - 1;
                        while (l < r) {
                            int mid = l + (r - l + 1) / 2;
                            if (q.get(mid) < x) {
                                l = mid;
                            } else {
                                r = mid - 1;
                            }
                        }

                        // update next position
                        q.set(l + 1, x);
                    }
                }
            }

            return q.size();
        }
    }

    /**
     * T  = n ^ 2
     */
    class Sol_dp {
        public int lengthOfLIS(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }

            int[] f = new int[A.length];
            // better to define 1
            int ans = 1;

            for (int i = 0; i < A.length; i++) {
                f[i] = 1;
                // get value for f[i]
                for (int j = 0; j < i; j++) {
                    if (A[i] > A[j]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                ans = Math.max(ans, f[i]);
            }

            return ans;
        }
    }
}
