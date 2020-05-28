package _301_350;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class _324_WiggleSort2 {
    //TODO: add todo 324

    /**
     * T = nlogn
     * 作者：heator
     * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii/solution/javaxiang-xi-ti-jie-shuo-ming-by-heator/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, i = 0;
        int[] smaller = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)], bigger = new int[len / 2];
        //复制
        System.arraycopy(nums, 0, smaller, 0, smaller.length);
        System.arraycopy(nums, smaller.length, bigger, 0, len / 2);
        //穿插
        for (; i < len / 2; i++) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
            nums[2 * i + 1] = bigger[len / 2 - 1 - i];
        }
        if (len % 2 != 0) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
        }
    }
}
