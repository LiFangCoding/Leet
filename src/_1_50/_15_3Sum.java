package _1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            /**
             * skip duplicate triples with the same first number
             */
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // skip duplicate pairs with the same left
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // skip duplicate pairs with the same right
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
