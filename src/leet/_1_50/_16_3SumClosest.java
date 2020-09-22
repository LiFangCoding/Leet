package leet._1_50;

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
    //TODO
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);

        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                // find least k that is >= target
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= target) {
                    k--;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (j < k - 1) {
                    sum = nums[i] + nums[j] + nums[k - 1];
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                }
            }
        }

        return res;
    }
}
