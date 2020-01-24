package _201_250;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class _238_Product_of_Array_Except_Self {
    /**
     * [1,2,3,4]
     * [24,12,8,6]
     * <p>
     * prev
     * [1, 1, 2, 6]
     * <p>
     * <p>
     * last
     * [ 24 ,12,8,6]
     * <p>
     * <p>
     * [3,4,5]
     * [20, 15, 12]
     * <p>
     * [1, 3, 12]
     * [20 ,15,12]
     */
    public int[] productExceptSelf(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int len = A.length;
        int[] res = new int[len];

        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * A[i - 1];
        }

        int postSum = 1;
        for (int j = len - 1; j >= 0; j--) {
            res[j] = res[j] * postSum;
            postSum *= A[j];
        }

        return res;
    }
}
