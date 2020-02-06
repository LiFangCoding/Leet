package _251_300;

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
     * @param A
     */
    public void moveZeroes(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                A[cur++] = A[i];
            }
        }

        for (; cur < A.length; cur++) {
            A[cur] = 0;
        }
    }
}
