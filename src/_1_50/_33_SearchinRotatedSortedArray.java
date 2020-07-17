package _1_50;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class _33_SearchinRotatedSortedArray {
    class Sol_compare_Start {
        public int search(int[] A, int target) {
            if (A == null || A.length == 0) {
                return -1;
            }

            int l = 0;
            int r = A.length - 1;

            while (l + 1 < r) {
                int mid = l + (r - l) / 2;

                if (A[mid] == target) {
                    return mid;
                }

                // Find where is mid. So we can know which part is sorted. Then determine scope
                if (A[mid] >= A[0]) {
                    //mid is in the first part of array
                    if (target >= A[0] && target < A[mid]) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                } else {
                    // mid is in the second part of array
                    if (target > A[mid] && target < A[0]) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
            }

            if (A[l] == target) {
                return l;
            }

            if (A[r] == target) {
                return r;
            }

            return -1;
        }
    }

    class Sol_compare_end {
        public int search(int[] A, int target) {
            if (A == null || A.length == 0) {
                return -1;
            }

            int l = 0;
            int r = A.length - 1;
            int endVal = A[r];

            while (l + 1 < r) {
                int mid = l + (r - l) / 2;

                if (A[mid] == target) {
                    return mid;
                }

                // Find where is mid. So we can know which part is sorted. Then determine scope
                if (A[mid] <= endVal) {
                    //mid is in the first part of array
                    if (target <= endVal && target >= A[mid]) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                } else {
                    // mid is in the second part of array
                    if (target >= A[l] && target <= A[mid]) {
                        r = mid;
                    } else {
                        l = mid;
                    }
                }
            }

            if (A[l] == target) {
                return l;
            }

            if (A[r] == target) {
                return r;
            }

            return -1;
        }
    }
}
