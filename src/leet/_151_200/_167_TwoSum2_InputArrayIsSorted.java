package leet._151_200;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class _167_TwoSum2_InputArrayIsSorted {
    class Sol_ac {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0, j = nums.length - 1; i < j; i++) {
                while (i < j && nums[i] + nums[j] > target)
                    j--;
                if (i < j && nums[i] + nums[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
            return new int[0];
        }
    }

    public int[] twoSum(int[] A, int target) {
        /**
         * !!! be careful, here do not use i++, j--
         */
        for (int l = 0, r = A.length - 1; l < r; ) {
            int sum = A[l] + A[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                /**
                 * !!! index not zero based
                 */
                return new int[] { l + 1, r + 1 };
            }
        }

        return new int[] { -1, -1 };
    }
}
