package leet._51_100;

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
    /**
     * 这道题类似于Search in Rotated Sorted Array，不同点在于这道题里的数组可能包含相同元素。
     * 目前能想到的二分做法的最坏时间复杂度都是 O(n)，所以索性就拿线性扫描做了^^。
     * <p>
     * 时间复杂度分析：整个数组只扫描一遍，所以时间复杂度是 O(n)
     * https://www.acwing.com/solution/content/165/
     *
     * @param A
     * @param target
     * @return
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int l = 0;
        int r = A.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            /**
             * first consider all the conditions then think which part mid is on.
             */
            if (A[mid] == target) {
                return true;
            }

            if (A[mid] > A[l]) {
                if (target >= A[l] && target < A[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else if (A[mid] < A[l]) {
                if (target > A[mid] && target <= A[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                l++;
            }
        }

        return A[l] == target || A[r] == target;
    }
}
