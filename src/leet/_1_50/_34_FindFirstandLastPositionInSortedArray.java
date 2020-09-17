package leet._1_50;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class _34_FindFirstandLastPositionInSortedArray {
    /**
     * T = O(log n)
     * S = O(1)
     *
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[] { -1, -1 };
        }

        int[] ans = new int[2];

        int l = 0;
        int r = A.length - 1;

        // Find first position
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (A[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (A[l] == target) {
            ans[0] = l;
        } else if (A[r] == target) {
            ans[0] = r;
        } else {
            return new int[] { -1, -1 };
        }

        l = ans[0];
        r = A.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (A[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (A[r] == target) {
            ans[1] = r;
        } else if (A[l] == target) {
            ans[1] = l;
        }

        return ans;
    }
}
