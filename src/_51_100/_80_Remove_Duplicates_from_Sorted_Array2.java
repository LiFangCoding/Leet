package _51_100;

import java.util.Arrays;

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
    public static void main(String[] args) {
        _80_Remove_Duplicates_from_Sorted_Array2 test = new _80_Remove_Duplicates_from_Sorted_Array2();
        int[] A = new int[]{1, 1, 1, 2, 2, 3};

        test.removeDuplicates(A);
        System.out.println(Arrays.toString(A));
    }

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length <= 2) {
            return A.length;
        }

        int newIdx = 1;
        /**
         * be careful here. Because the index will be updated also.
         * !!! for each element iteration, compare with new array, not the old array value.
         * Because old array value can be override by new array.
         */
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[newIdx] && A[i] == A[newIdx - 1]) {
                continue;
            }
            newIdx++;
            A[newIdx] = A[i];
        }

        return newIdx + 1;
    }
}
