package _51_100;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class _81_Search_in_Rotated_Sorted_Array2 {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            /**
             * first consider all the conditions then think which part mid is on.
             */
            if (A[mid] == target) {
                return true;
            }

            if (A[mid] > A[start]) {
                if (target >= A[start] && target < A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[mid] < A[start]) {
                if (target > A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }

        return A[start] == target || A[end] == target;
    }
}
