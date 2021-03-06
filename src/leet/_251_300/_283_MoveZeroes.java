package leet._251_300;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class _283_MoveZeroes {
    /**
     * [0,1,0,3,12]
     * [1,3,12,0,0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int k = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[k++] = x;
            }
        }

        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
