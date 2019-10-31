package _1_50;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3
 * 1,3,2
 * 2,1,3
 * 2,3,1
 * 3,1,2
 * 3,2,1
 *
 * 1,2,3,4
 * 1,2,4,3
 * 1,3,2,4
 * 1,3,4,2
 * 1,4,2,3
 * 1,4,3,2
 * 2,1,3,4
 * 2,1,4,3
 * 2,3,1,4
 * 2,3,4,1
 * 2,4,1,3
 * 2,4,3,1
 */
public class _31_NextPermutation {
    public static void main(String[] args) {
        _31_NextPermutation test = new _31_NextPermutation();

        int[] nums = {1, 3, 5, 4, 8, 7, 6};
        test.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(',');
        }
    }

    /**
     * This is to find the smallest of nums that are larget than nums.
     * If it is largest, return the reverse version.
     * <p>
     * 1,3,5,4,8,7,6
     * 1,3,5,6,4,7,8
     * <p>
     * 1,6,7
     * 1,7,6
     * <p>
     * 1,7,7
     * 7,1,7
     * 7,7,1
     *
     * Consider edge case problem
     * 1
     * 1,1
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        /**
         * 1 find index which decrese from end to start. If cannot find, reverse all
         * 2 find index which is larger than the decrease index from end to start
         * 3 reverse
         */
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;

        int idxSmall = len - 2;
        while (idxSmall >= 0) {
            if (nums[idxSmall] < nums[idxSmall + 1]) {
                break;
            }
            idxSmall--;
        }

        if (idxSmall < 0) {
            reverse(nums, 0, len - 1);
            /** Do not forget return.
             * else error: [1], [1,1]
             */
            return;
        }

        int idxLarge = len - 1;

        while (nums[idxLarge] <= nums[idxSmall]) {
            idxLarge--;
        }

        int temp = nums[idxSmall];
        nums[idxSmall] = nums[idxLarge];
        nums[idxLarge] = temp;

        reverse(nums, idxSmall + 1, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
