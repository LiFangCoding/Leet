package leet._351_400;

import java.util.HashMap;
import java.util.Map;

public class _377_Combination_Sum_4 {
    class Sol_ac {
        class Solution {
            // 1 每个数用无限次
            // 2 数的顺序不同 方案不同
            // 一般的背包问题不用考虑顺序
            // 先看第一个位置有几种选择 n， 第二个位置还是n个选择，所以枚举用的是位置
            // 比完全背包简单
            // dp 1 状态表示
            // 1.1 集合 f[j] 当前总和为j的所有方案. 背包问题是前i个数总和为j。 不需要f[i, j], 因为位置数量不用
            // 1.2 属性是 数量
            // 2 状态计算
            // 以最后一个位置来划分集合。放ak. f[j] = sum (f[j - a[k]])。 ak > 0, j - ak < j.
            // 状态数量 n. T = n2
            public int combinationSum4(int[] nums, int m) {
                int[] f = new int[m + 1];
                f[0] = 1;
                // j <= m
                for (int j = 0; j <= m; j++) {
                    for (int v : nums) {
                        if (j >= v) {
                            f[j] += f[j - v];
                        }
                    }
                }
                return f[m];
            }
        }
    }

    class Solution_dfs_memo {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        public int combinationSum4(int[] nums, int target) {
            return dfs(nums, target);
        }

        int dfs(int[] nums, int target) {
            if (map.containsKey(target)) return map.get(target);
            if (target == 0) {
                map.put(0, 1);
                return 1;
            } else if (target < 0) return 0;
            else {
                int res = 0;
                for (int i = 0; i < nums.length; i++) {
                    res += dfs(nums, target - nums[i]);
                }
                map.put(target, res);
                return res;
            }
        }
    }
}
