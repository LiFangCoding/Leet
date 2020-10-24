package leet._151_200;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    class Sol_ac {
        public int findMin(int[] nums) {
            // special case, no change
            int n = nums.length;
            int l = 0, r = n - 1;
            if (nums[l] < nums[r]) return nums[0];

            // has two points
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < nums[0]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return nums[r];
        }
    }

    class Sol_old {
        /**
         * 为了便于理解，我们将数组中的数画在二维坐标系中，横坐标表示数组下标，纵坐标表示数值，如下所示：
         * <p>
         * <p>
         * 我们会发现数组中最小值前面的数 nums[i]nums[i] 都满足：nums[i]≥nums[0]nums[i]≥nums[0]，其中 nums[n−1]nums[n−1] 是数组最后一个元素；而数组中最小值后面的数（包括最小值）都不满足这个条件。
         * 所以我们可以二分出最小值的位置。
         * <p>
         * 另外，不要忘记处理数组完全单调的特殊情况。
         * <p>
         * 时间复杂度分析：二分查找，所以时间复杂度是 O(logn)
         */
        public int findMin(int[] A) {
            if (A == null) {
                return 0;
            }

            int l = 0;
            int r = A.length - 1;

            int splitVal = A[r];

            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (A[mid] > splitVal) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            return A[l] < A[r] ? A[l] : A[r];
        }
    }
}
