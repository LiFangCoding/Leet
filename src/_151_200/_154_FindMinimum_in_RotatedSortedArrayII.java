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

        int l = 0;
        int r = A.length - 1;

        // delete black line. Because minimum will at least be A[l]. It can reduce the problem size
        while (A[r] == A[l] && r > l) {
            r--;
        }

        int splitVal = A[r];
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            // condiser the left part of min point will always large than split val
            if (A[mid] > splitVal) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return A[l] < A[r] ? A[l] : A[r];
    }
}
