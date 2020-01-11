package _151_200;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class _154_FindMinimum_in_RotatedSortedArrayII {
    public int findMin(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        while (A[end] == A[start] && end > start) {
            end--;
        }

        /**
         * ！！！Important. This need to be after delete the end equals
         * [0,0,1,1,2,0]
         *
         * [1,1,1,1]
         */
        if (A[end] >= A[start]) {
            return A[start];
        }

        /**
         * Important is to update the start and end point by binary search
         * throw half away
         *
         * Now,
         * 竖直虚线左边的数满足 nums[i]≥nums[0]nums[i]≥nums[0]
         * 并且 nums[i]>nums[n−1]nums[i]>nums[n−1]，
         * 其中 nums[n−1]nums[n−1] 是数组最后一个元素；
         * 而竖直虚线右边的数不满足这个条件。分界点就是整个数组的最小值。
         */
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= A[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return A[start] < A[end] ? A[start] : A[end];
    }
}
