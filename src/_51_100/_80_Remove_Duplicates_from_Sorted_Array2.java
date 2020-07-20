package _51_100;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _80_Remove_Duplicates_from_Sorted_Array2 {
    //TODO
    /**
     * O(n)
     * 由于数组有序，所以相同元素一定是相邻的。
     * 我们定义一个指针 k，表示新数组的末尾，然后从前往后扫描原数组，如果当前数不等于 nums[k]且不等于 nums[k−1]，则将当前数插入新数组的末尾。
     * <p>
     * 时间复杂度分析：总共对原数组仅扫描了一遍，所以总时间复杂度是 n
     */
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length <= 2) {
            return A.length;
        }

        // k means end of the new array
        int k = 1;
        /**
         * be careful here. Because the index will be updated also.
         * !!! for each element iteration, compare with new array, not the old array value.
         * Because old array value can be override by new array.
         */
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[k] && A[i] == A[k - 1]) {
                continue;
            }
            k++;
            A[k] = A[i];
        }

        return k + 1;
    }
}
