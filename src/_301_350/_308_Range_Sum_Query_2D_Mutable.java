package _301_350;

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
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * Note:
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _308_Range_Sum_Query_2D_Mutable {
    //TODO

    /**
     * Binary Indexed Tree - 2D 版本
     * https://www.jiuzhang.com/solution/range-sum-query-2d-mutable/#tag-highlight
     */
    class NumMatrix {
        int n, m;
        private int[][] arr, bit;

        /**
         * @return: nothing
         */
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return;
            }

            n = matrix.length;
            m = matrix[0].length;
            arr = new int[n][m];
            bit = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int delta = val - arr[row][col];
            arr[row][col] = val;

            for (int i = row + 1; i <= n; i = i + lowbit(i)) {
                for (int j = col + 1; j <= m; j = j + lowbit(j)) {
                    bit[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return (
                    prefixSum(row2, col2) -
                            prefixSum(row2, col1 - 1) -
                            prefixSum(row1 - 1, col2) +
                            prefixSum(row1 - 1, col1 - 1)
            );
        }

        private int prefixSum(int row, int col) {
            int sum = 0;
            for (int i = row + 1; i > 0; i = i - lowbit(i)) {
                for (int j = col + 1; j > 0; j = j - lowbit(j)) {
                    sum += bit[i][j];
                }
            }
            return sum;
        }

        private int lowbit(int x) {
            return x & (-x);
        }
    }
}
