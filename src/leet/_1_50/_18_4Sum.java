package leet._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // skip first value
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // skip second vaalue
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = j + 1, u = nums.length - 1; k < u; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (u - 1 > k && nums[i] + nums[j] + nums[k] + nums[u - 1] >= target) u--;
                    if (nums[i] + nums[j] + nums[k] + nums[u] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[u]));
                    }
                }
            }
        }

        return res;
    }
}
