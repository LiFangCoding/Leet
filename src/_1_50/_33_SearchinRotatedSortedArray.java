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
    public static void main(String[] args) {
        _33_SearchinRotatedSortedArray test = new _33_SearchinRotatedSortedArray();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int expected = 4;

        System.out.println(test.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Find where is mid. So we can know which part is sorted. Then determine scope
            if (nums[mid] >= nums[0]) {
                //mid is in the first part of array
                if (target >= nums[0] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // mid is in the second part of array
                if (target > nums[mid] && target < nums[0]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
