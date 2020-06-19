package _301_350;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * <p>
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 * <p>
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * Follow Up:
 * Can you do it in O(n) time?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _325_Maximum_size_subarray_equal_k {
    public int maxSubArrayLen(int[] A, int k) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int curSum = 0;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            int target = curSum - k;
            if (map.containsKey(target)) {
                ans = Math.max(ans, i - map.get(target));
            }

            if (!map.containsKey(curSum)) {
                map.put(curSum, i);
            }
        }

        return ans;
    }
}
