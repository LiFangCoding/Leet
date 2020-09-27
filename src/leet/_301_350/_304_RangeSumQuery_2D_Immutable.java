package leet._301_350;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * <p>
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class _304_RangeSumQuery_2D_Immutable {
    //TODO
    class Sol_ac {
        class NumMatrix {
            // aij, sij means ij 左上方总和
            //sij = si-1j + sij-1 - si-1j-1 + aij
            // sx2y2 - sx1 -1y2 - sx2y1-1 + sx1-1y1-1

            int[][] s;

            public NumMatrix(int[][] matrix) {
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
                s = new int[matrix.length + 1][matrix[0].length + 1];
                for (int i = 1; i <= matrix.length; i++) {
                    for (int j = 1; j <= matrix[0].length; j++) {
                        // i, j from 1, matrix is from 0
                        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }

            public int sumRegion(int x1, int y1, int x2, int y2) {
                // because index is from 0, we need to add 1
                ++x1;
                ++y1;
                ++x2;
                ++y2;
                return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
            }
        }
    }
}
