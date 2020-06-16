package _251_300;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * Example:
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */
public class _280_WiggleSort {
    /**
     * 3ms
     * T = nlogn
     * S = 1
     */
    class Sol_sort {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length - 1; i += 2) {
                swap(nums, i, i + 1);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/wiggle-sort/solution/bai-dong-pai-xu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    /**
     * 1ms
     * T = n
     */
    class Sol_one_time {
        public void wiggleSort(int[] nums) {
            boolean less = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (less) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                } else {
                    if (nums[i] < nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                }
                less = !less;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

//
//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/wiggle-sort/solution/bai-dong-pai-xu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
