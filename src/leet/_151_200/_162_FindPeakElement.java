package leet._151_200;

/**
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 */
public class _162_FindPeakElement {
    class Sol_ac {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }
    }

    class Sol_old {
        public int findPeakElement(int[] A) {
            if (A == null || A.length == 0) {
                return -1;
            }

            if (A.length == 1) {
                return 0;
            }

            int start = 0;
            int end = A.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;

                if (A[mid] > A[mid + 1]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (A[start] > A[end]) {
                return start;
            } else {
                return end;
            }
        }
    }
}
