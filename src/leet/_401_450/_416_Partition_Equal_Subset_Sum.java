package leet._401_450;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * <p>
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *  
 * <p>
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _416_Partition_Equal_Subset_Sum {
    class Sol_ac {
        // 01背包问题。
        // 体积ai,背包容量 sum / 2
        public boolean canPartition(int[] nums) {
            int n = nums.length, m = 0;
            for (int x : nums) {
                m += x;
            }
            if (m % 2 != 0) return false;
            m /= 2;
            int[] f = new int[m + 1];
            f[0] = 1;
            for (int x : nums) {
                for (int j = m; j >= x; j--) {
                    f[j] |= f[j - x];
                }
            }
            return f[m] == 1;
        }
    }

    /**
     *
     */
    class Sol_dp {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 == 1) {
                return false;
            }

            int target = sum / 2;
            int n = nums.length;
            // f[i][w] first i to get weight w
            // dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
            boolean[][] f = new boolean[n + 1][target + 1];

            for (int i = 0; i <= n; i++) {
                f[i][0] = true;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    f[i][j] = f[i - 1][j];

                    int choice = nums[i - 1];

                    if (j - choice >= 0) {
                        f[i][j] = f[i][j] || f[i - 1][j - choice];
                    }
                }
            }

            return f[n][target];
        }
    }

    /**
     * 34 ms
     * <p>
     * Search with memo
     * If without memo, 超出时间限制
     */
    class Sol_Memo {
        Map<String, Boolean> map;

        public boolean canPartition(int[] A) {
            if (A == null || A.length == 0) {
                return false;
            }

            int sum = 0;
            for (int num : A) {
                sum += num;
            }

            if (sum % 2 == 1) {
                return false;
            }

            int target = sum / 2;
            map = new HashMap<>();

            return search(A, target, 0, 0);
        }

        private boolean search(int[] A, int target, int start, int cur) {
            String key = start + "," + cur;
            if (map.containsKey(key)) {
                return map.get(key);
            }

            if (cur > target) {
                return false;
            }
            if (cur == target) {
                return true;
            }

            for (int i = start; i < A.length; i++) {
                cur += A[i];
                if (search(A, target, i + 1, cur)) {
                    map.put(key, true);
                    return true;
                }
                cur -= A[i];
            }

            map.put(key, false);
            return false;
        }
    }
}
