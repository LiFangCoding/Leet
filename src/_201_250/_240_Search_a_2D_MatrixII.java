package _201_250;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class _240_Search_a_2D_MatrixII {
    /**
     * !!! []
     * 0
     */
    public boolean searchMatrix(int[][] A, int target) {
        /**
         * !!!chain check important
         */
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return false;
        }
        int rows = A.length;
        int cols = A[0].length;
        if (rows == 0 || cols == 0) {
            return false;
        }

        for (int i = rows - 1, j = 0; i >= 0 && j < cols; ) {
            if (A[i][j] == target) {
                return true;
            } else if (A[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }

        return false;
    }
}
