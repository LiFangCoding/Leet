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
    public boolean searchMatrix(int[][] matrix, int target) {
        // martix == null || matrix.length == 0, we will not have matrix[0]
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;

        int row = rows - 1, col = 0;

        while (row >= 0 && col < cols) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val > target) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }
}
